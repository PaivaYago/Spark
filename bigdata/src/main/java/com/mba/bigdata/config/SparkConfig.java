package com.mba.bigdata.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class SparkConfig {
	
	
	@Value("${spark.app.name}")
	private String appName;
	
	@Value("${spark.master}")
	private String masterUri;
	
	@Bean
    public SparkConf conf() {
        return new SparkConf().setAppName(appName).setMaster(masterUri);
    }
 
    @Bean
    public JavaSparkContext javaSparkContext() {
        return new JavaSparkContext(conf());
    }
	

    @Bean
    public SparkSession sparkSession() {
        return SparkSession
                .builder()
                .sparkContext(javaSparkContext().sc())
                .appName(appName)
                .getOrCreate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
