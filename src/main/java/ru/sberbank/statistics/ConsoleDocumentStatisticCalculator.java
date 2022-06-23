package ru.sberbank.statistics;

import ru.sberbank.model.Document;
import ru.sberbank.model.DocumentInfo;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleDocumentStatisticCalculator implements DocumentStatisticCalculator {
    @Override
    public void calculateStat(List<? extends Document> docs) {
        calcStatisticByDocType(docs);
    }

    private void calcStatisticByDocType(List<? extends Document> docs) {
        docs.stream().map(Document::getDocInfo)
                .collect(Collectors.groupingBy(DocumentInfo::getType))
                .forEach((key, value) ->
                System.out.println("Тип документа : " + key.name() + " найден " + value.size() + " раз"));
    }
}
