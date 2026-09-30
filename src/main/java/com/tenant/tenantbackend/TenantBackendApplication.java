package com.tenant.tenantbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TenantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenantBackendApplication.class, args);
    }

}
