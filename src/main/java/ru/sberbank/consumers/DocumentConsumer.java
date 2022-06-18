package ru.sberbank.consumers;

import ru.sberbank.model.Document;

import java.util.List;

public interface DocumentConsumer {
    void saveDocuments(List<? extends Document> docs);
}
