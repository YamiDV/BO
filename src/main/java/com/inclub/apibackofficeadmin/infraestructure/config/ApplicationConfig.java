package com.inclub.apibackofficeadmin.infraestructure.config;

import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

public class ApplicationConfig extends AbstractR2dbcConfiguration {

    @SuppressWarnings("null")
    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, "postgresql")
                .option(ConnectionFactoryOptions.HOST, "postgres.inclub.world")
                .option(ConnectionFactoryOptions.USER, "jvilchez")
                .option(ConnectionFactoryOptions.PASSWORD, "jvilchez")
                .option(ConnectionFactoryOptions.DATABASE, "dev_bo_admin")
                .build());
    }

}
