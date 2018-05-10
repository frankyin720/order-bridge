package com.rw.orderbridge.context;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.rw.orderbridge.resource.CustomerOrderResource;
import com.rw.orderbridge.resource.CustomerResource;

@Configuration
public class Application extends ResourceConfig {
    public Application() {
        register(CustomerResource.class);
        register(CustomerOrderResource.class);
    }
}
