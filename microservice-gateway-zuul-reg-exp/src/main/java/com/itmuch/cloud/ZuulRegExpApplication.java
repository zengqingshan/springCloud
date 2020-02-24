package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulRegExpApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulRegExpApplication.class, args);
  }
}
