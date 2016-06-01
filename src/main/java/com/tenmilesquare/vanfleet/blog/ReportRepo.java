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
}
