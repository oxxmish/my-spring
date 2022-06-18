package ru.sberbank.model;

public class CommonDocument implements Document {
    private final DocumentInfo documentInfo;

    public CommonDocument(DocumentInfo documentInfo) {
        this.documentInfo = documentInfo;
    }

    @Override
    public DocumentInfo getDocInfo() {
        return this.documentInfo;
    }
}
