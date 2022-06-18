package ru.sberbank.producers;

import ru.sberbank.model.Document;

import java.util.List;

public interface DocumentProducer {
    List<? extends Document> getDocuments();
}
