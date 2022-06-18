package ru.sberbank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class DocumentInfo {
    private DocumentType type;
    private Map<String, String> fields;

    public DocumentInfo(Map<String, String> serializedMap) {
        this.type = DocumentType.valueOf(serializedMap.get("type"));
        serializedMap.remove("type");
        this.fields = serializedMap;
    }
}
