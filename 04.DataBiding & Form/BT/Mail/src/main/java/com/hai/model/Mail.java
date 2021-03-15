package com.hai.model;

public class Mail {
    private String language;
    private int pageSize;
    private boolean filter;
    private String signature;

    public Mail(){}

    public Mail(String language, int pageSize, boolean filter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", filter=" + filter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
