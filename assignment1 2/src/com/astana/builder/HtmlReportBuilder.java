package com.astana.builder;

import java.util.ArrayList;
import java.util.List;

public class HtmlReportBuilder implements ReportBuilder {
    private String title;
    private String author;
    private final List<String> sections = new ArrayList<>();
    private String footer;

    @Override
    public ReportBuilder reset() {
        this.title = null;
        this.author = null;
        this.sections.clear();
        this.footer = null;
        return this;
    }

    @Override
    public ReportBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public ReportBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public ReportBuilder addSection(String sectionHeading, String content) {
        this.sections.add("<h2>" + sectionHeading + "</h2>\n<p>" + content + "</p>");
        return this;
    }

    @Override
    public ReportBuilder setFooter(String footer) {
        this.footer = "<footer><small>" + footer + "</small></footer>";
        return this;
    }

    @Override
    public Report build() {
        validateState();
        return new Report(title, author, ReportFormat.HTML, new ArrayList<>(sections), footer);
    }

    @Override
    public String getFormattedOutput() {
        validateState();
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n<html>\n<head><title>").append(title).append("</title></head>\n<body>\n");
        html.append("<h1>").append(title).append("</h1>\n");
        html.append("<p><em>Author: ").append(author).append("</em></p>\n<hr/>\n");
        for (String s : sections) {
            html.append(s).append("\n");
        }
        if (footer != null) html.append(footer).append("\n");
        html.append("</body>\n</html>");
        return html.toString();
    }

    private void validateState() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Report building failed: Title must not be null or blank.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalStateException("Report building failed: Author must not be null or blank.");
        }
    }
}