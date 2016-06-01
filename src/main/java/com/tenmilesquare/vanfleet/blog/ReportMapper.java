package com.tenmilesquare.vanfleet.blog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ry on 6/1/16.
 */
public final class ReportMapper implements RowMapper<Report> {

    /**
     * The singleton
     */
    private final static ReportMapper MAPPER = new ReportMapper();

    /**
     * Singleton constructor
     */
    private ReportMapper() {
        super();
    }

    /**
     * Get the singleton
     * @return The mapper singleton
     */
    public static ReportMapper getMAPPER() {
        return MAPPER;
    }

    /**
     * Maps the report object from the result set
     * @param rs The sql result set
     * @param i The row number
     * @return A report object
     * @throws SQLException Thrown if there was a SQL issue during mapping
     */
    public Report mapRow(ResultSet rs, int i) throws SQLException {
        Report report = new Report();
        report.setId(rs.getLong("report_id"));
        report.setName(rs.getString("name"));
        report.setReportParameters(rs.getString("parameters"));
        return report;
    }
}
