package ru.sberbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {
    public static final ObjectMapper mapper = new ObjectMapper();
}
