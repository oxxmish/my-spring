package ru.sberbank;

import ru.sberbank.spring.Application;
import ru.sberbank.spring.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("ru.sberbank", new HashMap<>(Map.of()));
        MapperApp mapperApp = context.getObject(MapperApp.class);
        mapperApp.start();
    }
}
