package com.tenmilesquare.vanfleet.blog;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Spring application context config
 */
@Configuration
@ComponentScan(basePackages = {"com.tenmilesquare.vanfleet.blog"})
public class Config {

    /**
     * DataSource for working with the publishing database.
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/jsontest");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setValidationQuery("SELECT version()");
        dataSource.setAccessToUnderlyingConnectionAllowed(true);
        return dataSource;
    }

    /**
     * NamedParameterJdbcTemplate for working with named parameter SQL with the publishing database.
     * @return NamedParameterJdbcTemplate
     */
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    /**
     * JdbcTemplate for working with SQL with the publishing database.
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
