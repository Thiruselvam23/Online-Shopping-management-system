package com.onlineShopping.Eproject;

import java.io.IOException;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.onlineShopping")  
@EnableJpaRepositories(basePackages = "com.onlineShopping.EprojectRepo")  
@EntityScan(basePackages = "com.onlineShopping.EprojectModel")
public class EprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EprojectApplication.class, args);
    }

    @Bean
    public ApplicationRunner runFrontend() {
        return args -> {
            try {
                String url = "\"D:\\DBMS\\project files\\Online-Shopping-management-system-main\\Online-Shopping-management-system-main\\src\\main\\resources\\static\\index.html\"";
                String url = "file:///C:\\Users\\SSN\\EPROJECT\\EPROJECT\\src\\main\\resources\\static/index.html";
                ProcessBuilder builder = new ProcessBuilder();
                
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    // Windows
                    builder.command("rundll32", "url.dll,FileProtocolHandler", url);
                } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    
                    builder.command("open", url);
                } else {
                    
                    builder.command("xdg-open", url);
                }
                
                builder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
