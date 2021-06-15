package com.my.university.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ConfigurationProperties(value = "application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UniversityAppTestConfig {

    @Test
    public void contextLoads() {
    }
}
