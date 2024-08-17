package org.portevent.springpotager;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPotagerApplication {

    private static final Logger logger
            = LoggerFactory.getLogger(SpringPotagerApplication.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", SpringPotagerApplication.class.getSimpleName());
        SpringApplication.run(SpringPotagerApplication.class, args);
    }

}
