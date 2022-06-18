package ru.sberbank.producers;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import ru.sberbank.Utils;
import ru.sberbank.model.CommonDocument;
import ru.sberbank.model.Document;
import ru.sberbank.model.DocumentInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileDocumentProducer implements DocumentProducer{

//    @InjectProperty("file-path")
    private String filePath = "C:\\Users\\Michail\\IdeaProjects\\coronadesinfectorlifedemo\\src\\main\\resources\\initial-documents.txt";

    @Override
    public List<? extends Document> getDocuments() {
        var fileDataAsString = readDataFromFile(filePath);
        return getCommonDocumentsFromString(fileDataAsString);
    }

    private List<CommonDocument> getCommonDocumentsFromString(String fileDataAsString) {
        return Arrays.stream(fileDataAsString.split(";"))
                .map(String::trim)
                .map(this::getMapFromJsonString)
                .map(values -> new CommonDocument( new DocumentInfo(values)))
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private Map<String, String> getMapFromJsonString(String s) {
        return new HashMap<String, String>(Utils.mapper.readValue(s, Map.class));
    }

    private String readDataFromFile(String path) {
        try (var file = new FileInputStream(path)) {
            return IOUtils.toString(file, Charset.defaultCharset());
        } catch (IOException ex) {
            //TODO log ex
            throw new RuntimeException("Невозможно чтение данных в файле ", ex);
        }
    }
}
