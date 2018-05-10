package com.rw.orderbridge.util;

import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.Gson;
import com.rw.orderbridge.exception.ApplicationException;

@Component
public class JSONValidator {
    private String JSON_V4_SCHEMA_IDENTIFIER = "http://json-schema.org/draft-04/schema#";
    private String JSON_SCHEMA_IDENTIFIER_ELEMENT = "$schema";
    private Logger logger = LoggerFactory.getLogger(JSONValidator.class);

    /**
     * @param schemaText
     * @param request
     * @throws ApiException
     */
    public void validateJson(String schemaText, Object request) throws ApplicationException {
        try {
            Gson gson = new Gson();
            String jsonText = gson.toJson(request);
            JsonNode schemaNode = JsonLoader.fromString(schemaText);
            final JsonNode schemaIdentifier = schemaNode.get(JSON_SCHEMA_IDENTIFIER_ELEMENT);
            if (null == schemaIdentifier) {
                ((ObjectNode) schemaNode).put(JSON_SCHEMA_IDENTIFIER_ELEMENT, JSON_V4_SCHEMA_IDENTIFIER);
            }
            final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            final JsonSchema schema = factory.getJsonSchema(schemaNode);
            final JsonNode jsonNode = JsonLoader.fromString(jsonText);
            ProcessingReport report = schema.validate(jsonNode);
            if (!report.isSuccess()) {
                ApplicationException ex = new ApplicationException();
                StringBuilder builder = new StringBuilder();
                for (Iterator<ProcessingMessage> iterator = report.iterator(); iterator.hasNext();) {
                    ProcessingMessage message = iterator.next();
                    builder.append(message.getMessage());
                }
                logger.error("JSON Schema is invalid: " + builder.toString());
                ex.setMessage(builder.toString());
            }
        } catch (ProcessingException e) {
            logger.error("JSON Schema validation is failed: " + e.getMessage());
            throw new ApplicationException(e);
        } catch (IOException e) {
            logger.error("JSON Schema validation is failed: " + e.getMessage());
            throw new ApplicationException(e);
        }
    }
}
