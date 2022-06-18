package ru.sberbank.statistics;

import ru.sberbank.model.Document;

import java.util.List;

public interface DocumentStatisticCalculator {
    void calculateStat(List<? extends Document> docs);
}
