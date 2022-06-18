package ru.sberbank.spring;

import ru.sberbank.spring.ApplicationContext;

/**
 * @author Evgeny Borisov
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
