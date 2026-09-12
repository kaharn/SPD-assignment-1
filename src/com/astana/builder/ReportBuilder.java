package com.astana.builder;

public interface ReportBuilder {
    ReportBuilder reset();
    ReportBuilder setTitle(String title);
    ReportBuilder setAuthor(String author);
    ReportBuilder addSection(String sectionHeading, String content);
    ReportBuilder setFooter(String footer);
    Report build();
    String getFormattedOutput();
}