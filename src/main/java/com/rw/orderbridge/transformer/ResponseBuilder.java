package com.rw.orderbridge.transformer;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rw.orderbridge.jsonschema.AddCustomerOrderRequestSchema;
import com.rw.orderbridge.jsonschema.AddCustomerRequestSchema;
import com.rw.orderbridge.model.Customer;
import com.rw.orderbridge.model.CustomerOrder;

public class ResponseBuilder {
    private static final String SYSTEM_USER = "system";

    private ResponseBuilder() {/* Do not construct */
    }

    public static Response buildResponse(Object entity) throws JsonGenerationException, JsonMappingException, IOException {
        return Response.ok().entity(entity).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS").header("content-type", "application/json; charset=utf-8")
                .build();
    }
}