package com.search.web.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.server.support.HttpSolrServerFactoryBean;

@Configuration
@PropertySource("classpath:dev.application.properties")
public class HttpSolrContext {

    @Resource
    private Environment environment;

    @Bean
    public HttpSolrServerFactoryBean solrServerFactoryBean() {
        HttpSolrServerFactoryBean factory = new HttpSolrServerFactoryBean();
        factory.setUrl(environment.getRequiredProperty("solr.server.url"));
        return factory;
    }
}