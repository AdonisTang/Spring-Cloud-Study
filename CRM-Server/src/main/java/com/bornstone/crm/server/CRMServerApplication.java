package com.bornstone.crm.server;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CRMServerApplication {
    private static final Logger logger = Logger.getLogger(CRMServerApplication.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(CRMServerApplication.class).web(true).run(args);
        logger.info("Application started");
    }
}
