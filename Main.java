package com.astana.builder;

public class Main {
    public static void main(String[] args) {
        ReportDirector director = new ReportDirector();

        // 1. Direct construction via Fluent API
        ReportBuilder htmlBuilder = new HtmlReportBuilder();
        Report customHtmlReport = htmlBuilder
                .setTitle("Custom Student Project Report")
                .setAuthor("Alice Smith")
                .addSection("Abstract", "Demonstrating the GoF Builder pattern in Java 17.")
                .addSection("Results", "Achieved 100% test coverage and clean architecture standard.")
                .setFooter("Generated via Builder Pattern")
                .build();

        System.out.println("=== Custom HTML Report Object ===");
        System.out.println(customHtmlReport);
        System.out.println("\n--- HTML Output ---");
        System.out.println(htmlBuilder.getFormattedOutput());

        // 2. Construction using Director for reusable configurations
        ReportBuilder mdBuilder = new MarkdownReportBuilder();
        director.constructExecutiveSummary(mdBuilder, "Bob Jones");
        Report execReport = mdBuilder.build();

        System.out.println("\n=== Director-Built Markdown Report ===");
        System.out.println(execReport);
        System.out.println("\n--- Markdown Output ---");
        System.out.println(mdBuilder.getFormattedOutput());

        // 3. Demonstrating validated construction failure
        try {
            new HtmlReportBuilder().setTitle("").build();
        } catch (IllegalStateException e) {
            System.out.println("\n=== Validation Catch ===");
            System.out.println("Validation correctly caught invalid state: " + e.getMessage());
        }
    }
}