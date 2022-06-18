package ru.sberbank.spring;

import org.reflections.Reflections;

/**
 * @author Evgeny Borisov
 */
public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    Reflections getScanner();
}
