package com.srs.common.smtp;

public enum SmtpTemplate {
    APP_APPROVED("app-approved");

    private final String filename;

    SmtpTemplate(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
