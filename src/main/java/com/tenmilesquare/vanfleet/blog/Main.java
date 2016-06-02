package com.tenmilesquare.vanfleet.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class for the application example
 *
 * Created by ry on 6/1/16.
 */
public class Main {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ReportRepo repo = context.getBean(ReportRepo.class);
        Report report1 = repo.getReportById(1L);
        System.out.println("Report1: " + report1.toString());

        Report report2 = new Report("Report2", "{\"param1\": \"Rolling Stones\"}");
        try {
            Long report2Id = repo.insertReportCastException(report2);
            System.out.println(report2Id);
        } catch (Exception e){
            e.printStackTrace();
        }
        // Now let try casting the String to JSON
        Long report2Id = repo.insertReportCasted(report2);
        System.out.println("Report2: " + repo.getReportById(report2Id));
    }
}
