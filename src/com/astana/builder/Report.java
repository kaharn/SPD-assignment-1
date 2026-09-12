package com.astana.builder;

import java.util.Collections;
import java.util.List;

public class Report {
    private final String title;
    private final String author;
    private final ReportFormat format;
    private final List<String> sections;
    private final String footer;

    public Report(String title, String author, ReportFormat format, List<String> sections, String footer) {
        this.title = title;
        this.author = author;
        this.format = format;
        this.sections = Collections.unmodifiableList(sections);
        this.footer = footer;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public ReportFormat getFormat() { return format; }
    public List<String> getSections() { return sections; }
    public String getFooter() { return footer; }

    @Override
    public String toString() {
        return String.format("Report [Title='%s', Author='%s', Format=%s, Sections=%d]",
                title, author, format, sections.size());
    }
}