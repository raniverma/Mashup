package com.stackroute.domain;
public class Code {
    private String codeTemplate;

    public Code() {
    }

    public Code(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    public String getCodeTemplate() {
        return this.codeTemplate;
    }
}