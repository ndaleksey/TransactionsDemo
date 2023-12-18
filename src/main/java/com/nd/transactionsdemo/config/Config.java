package com.nd.transactionsdemo.config;

import com.nd.transactionsdemo.handler.UuidTypeHandler;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * @author alexey.shishkov@softline.com
 * @since 2023
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.nd.transactionsdemo.dao.mapper"})
public class Config {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setVfs(SpringBootVFS.class);
        org.apache.ibatis.session.Configuration sessionConfig = new org.apache.ibatis.session.Configuration();
        sessionConfig.setMapUnderscoreToCamelCase(true);
        sessionConfig.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        factoryBean.setConfiguration(sessionConfig);
        sessionConfig.getTypeHandlerRegistry().register(UUID.class, new UuidTypeHandler());

        return factoryBean.getObject();
    }

}
