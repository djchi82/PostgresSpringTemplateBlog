package com.tenmilesquare.vanfleet.blog;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ry on 6/1/16.
 */
@Repository
public class ReportRepo {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final static String SQL_GET = "SELECT * FROM jsontest.report WHERE report_id = :report_id";
    /**
     * Retrieves a report entity by its database id
     * @param id the database id
     * @return returns the associated report if it exists, Null otherwise
     */
    public Report getReportById(Long id){
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("report_id", id);
        List<Report> reports = jdbcTemplate.query(SQL_GET, params, ReportMapper.getMAPPER());
        if(CollectionUtils.isEmpty(reports)){
            return null;
        }
        //Assume that the fist element is the one we are seeking.
        return reports.get(0);
    }

    private final static String INSERT_SQL_CAST_EXC = "INSERT INTO jsontest.report (name, parameters) VALUES (:name, :parameters) RETURNING report_id";
    /**
     * Insert report will throw Casting exception if JSON is supplied
     * @param report the report
     * @return the database id.
     */
    public Long insertReportCastException(Report report){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", report.getName());
        parameters.put("parameters", report.getReportParameters());
        return jdbcTemplate.queryForObject(INSERT_SQL_CAST_EXC, parameters, Long.class);
    }


    private final static String INSERT_SQL_CASTED = "INSERT INTO jsontest.report (name, parameters) VALUES (:name, cast(:parameters AS JSON)) RETURNING report_id";
    /**
     * Insert report. Will work, because we have casted the string to json
     * @param report the report
     * @return the database id.
     */
    public Long insertReportCasted(Report report){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", report.getName());
        parameters.put("parameters", report.getReportParameters());
        return jdbcTemplate.queryForObject(INSERT_SQL_CASTED, parameters, Long.class);
    }
}
