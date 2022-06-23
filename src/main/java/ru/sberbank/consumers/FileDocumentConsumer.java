package ru.sberbank.consumers;

import lombok.SneakyThrows;
import ru.sberbank.Utils;
import ru.sberbank.model.Document;
import ru.sberbank.model.DocumentInfo;
import ru.sberbank.spring.InjectProperty;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FileDocumentConsumer implements DocumentConsumer {

    @InjectProperty("input-file-path")
    private String outputFilePath;

    @Override
    public void saveDocuments(List<? extends Document> docs) {
        String dataAsString = docs.stream()
                .map(Document::getDocInfo)
                .map(this::parse2Json)
                .collect(Collectors.joining(";\r\n"));
        writeString2File(dataAsString);
    }

    private void writeString2File(String dataAsString) {
        try (var outputStream = new FileOutputStream(outputFilePath)) {
            byte[] bytes = dataAsString.getBytes();
            outputStream.write(bytes);
        } catch ( IOException ex) {
            throw new RuntimeException("Ошибка при записи в файл", ex);
        }
    }

    @SneakyThrows
    private String parse2Json(DocumentInfo documentInfo) {
        HashMap<String, String> stringHashMap = new LinkedHashMap<>();
        stringHashMap.put("type", documentInfo.getType().name());
        stringHashMap.putAll(documentInfo.getFields());
        return Utils.mapper.writeValueAsString(stringHashMap);
    }
}
