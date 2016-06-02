package com.tenmilesquare.vanfleet.blog;

/**
 * Report Domain for example
 */
public class Report {

    private String reportParameters;
    private Long id;
    private String name;

    /** Simple class constructor */
    public Report() {
        super();
    }

    /**
     * Class constructor
     * @param name Name
     * @param reportParameters json as a string
     */
    public Report(String name, String reportParameters) {
        this.name = name;
        this.reportParameters = reportParameters;
    }

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

    @Override
    public String toString() {
        return "Report{" +
                "reportParameters='" + reportParameters + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
