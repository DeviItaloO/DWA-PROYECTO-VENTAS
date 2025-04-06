package com.venta.cibertec.proyecto.config.ConexionesConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ConexionesConfig {
/*
    @Value("${DB_VENTAS_URL}")
    private String dbVentasUrl;
    @Value("${DB_VENTAS_USER}")
    private String dbVentasUser;
    @Value("${DB_VENTAS_PASS}")
    private String dbVentasPass;
    @Value("${DB_VENTAS_DRIVER}")
    private String dbVentasDriver;

    @Primary
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbVentasUrl);
        hikariConfig.setUsername(dbVentasUser);
        hikariConfig.setPassword(dbVentasPass);
        hikariConfig.setDriverClassName(dbVentasDriver);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/
}
