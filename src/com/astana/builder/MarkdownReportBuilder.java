package com.astana.builder;

import java.util.ArrayList;
import java.util.List;

public class MarkdownReportBuilder implements ReportBuilder {
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
        this.sections.add("## " + sectionHeading + "\n\n" + content);
        return this;
    }

    @Override
    public ReportBuilder setFooter(String footer) {
        this.footer = "---\n*" + footer + "*";
        return this;
    }

    @Override
    public Report build() {
        validateState();
        return new Report(title, author, ReportFormat.MARKDOWN, new ArrayList<>(sections), footer);
    }

    @Override
    public String getFormattedOutput() {
        validateState();
        StringBuilder md = new StringBuilder();
        md.append("# ").append(title).append("\n\n");
        md.append("**Author:** ").append(author).append("\n\n---\n\n");
        for (String s : sections) {
            md.append(s).append("\n\n");
        }
        if (footer != null) md.append(footer);
        return md.toString();
    }

    private void validateState() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Report building failed: Title cannot be null or empty.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalStateException("Report building failed: Author cannot be null or empty.");
        }
    }
}