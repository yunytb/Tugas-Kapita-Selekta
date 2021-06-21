/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Qeisarcom
 */
@Configuration
public class RestConfig {
    
    @Bean   //proses ketika aplikasi yg dibuat membuat objeknya. jadi objek ini akan berjalan ketika aplikasi berjalan
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}
