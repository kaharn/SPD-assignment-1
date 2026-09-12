package com.astana.builder;

public class ReportDirector {

    public void constructExecutiveSummary(ReportBuilder builder, String author) {
        builder.reset()
               .setTitle("Q3 Financial Executive Summary")
               .setAuthor(author)
               .addSection("Overview", "Revenue increased by 14% quarter-over-quarter across primary operational segments.")
               .addSection("Key Metrics", "EBITDA margin reached 28.4%, beating quarterly targets.")
               .setFooter("Confidential - Internal Board Distribution Only");
    }

    public void constructTechnicalAudit(ReportBuilder builder, String author) {
        builder.reset()
               .setTitle("System Security & Infrastructure Audit")
               .setAuthor(author)
               .addSection("Scope", "Evaluated core microservices and database backup redundancy.")
               .addSection("Findings", "Zero critical vulnerabilities detected; 2 minor dependencies require patching.")
               .setFooter("Astana IT University Security Department");
    }
}