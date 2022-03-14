package com.bike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.bike.mapper")
@EnableTransactionManagement
public class SpringMainApplication {

public static void main(String[] args) {
SpringApplication.run(SpringMainApplication.class, args);
}
}
