package com.venta.cibertec.proyecto.config.ConexionesConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ConexionesConfig {

    @Value("${DB_VENTAS_URL}")
    private String dbVentasUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWordUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWordPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWordDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig hikariConfig = new HikariConfig();
        // mi conexion
        hikariConfig.setJdbcUrl(dbVentasUrl);
        hikariConfig.setUsername(dbWordUser);
        hikariConfig.setPassword(dbWordPass);
        hikariConfig.setDriverClassName(dbWordDriver);
        // personalizado
        hikariConfig.setMaximumPoolSize(30);
        hikariConfig.setMinimumIdle(4);
        hikariConfig.setIdleTimeout(240000);
        hikariConfig.setConnectionTimeout(45000);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public PlatformTransactionManager transactionManager(HikariDataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }
}
