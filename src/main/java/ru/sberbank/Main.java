package ru.sberbank;

import ru.sberbank.consumers.DocumentConsumer;
import ru.sberbank.consumers.FileDocumentConsumer;
import ru.sberbank.producers.DocumentProducer;
import ru.sberbank.producers.FileDocumentProducer;
import ru.sberbank.spring.Application;
import ru.sberbank.spring.ApplicationContext;
import ru.sberbank.statistics.ConsoleDocumentStatisticCalculator;
import ru.sberbank.statistics.DocumentStatisticCalculator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Class, Class> beanDefinitions = new HashMap<>();
        beanDefinitions.put(DocumentConsumer.class, FileDocumentConsumer.class);
        beanDefinitions.put(DocumentProducer.class, FileDocumentProducer.class);
        beanDefinitions.put(DocumentStatisticCalculator.class, ConsoleDocumentStatisticCalculator.class);

        ApplicationContext context = Application.run("ru.sberbank", beanDefinitions);
        MapperApp mapperApp = context.getObject(MapperApp.class);
        mapperApp.start();
    }
}

