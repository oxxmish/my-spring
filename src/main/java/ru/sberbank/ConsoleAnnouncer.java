package ru.sberbank;

import ru.sberbank.spring.InjectByType;

/**
 * @author Evgeny Borisov
 */
public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;
    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
