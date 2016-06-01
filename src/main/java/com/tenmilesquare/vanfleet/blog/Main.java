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
    }
}
