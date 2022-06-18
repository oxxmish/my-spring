package ru.sberbank;

import ru.sberbank.consumers.DocumentConsumer;
import ru.sberbank.producers.DocumentProducer;
import ru.sberbank.spring.InjectByType;
import ru.sberbank.statistics.DocumentStatisticCalculator;

public class MapperApp {
    @InjectByType
    DocumentProducer documentProducer;
    @InjectByType
    DocumentConsumer documentConsumer;
    @InjectByType
    DocumentStatisticCalculator documentStatisticCalculator;

    void start() {
        var docs2Save = documentProducer.getDocuments();
        documentStatisticCalculator.calculateStat(docs2Save);
        documentConsumer.saveDocuments(docs2Save);
    };
}
