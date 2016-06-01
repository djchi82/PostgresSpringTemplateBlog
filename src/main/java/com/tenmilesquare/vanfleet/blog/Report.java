package com.tenmilesquare.vanfleet.blog;

/**
 * Report Domain for example
 */
public class Report {

    private String reportParameters;
    private Long id;
    private String name;

    public String getReportParameters() {
        return reportParameters;
    }

    public void setReportParameters(String reportParameters) {
        this.reportParameters = reportParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
