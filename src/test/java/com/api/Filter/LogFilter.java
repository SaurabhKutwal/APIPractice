package com.api.Filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LogFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    private void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("Request context is as below.");
        logger.info("Headers : {}", filterableRequestSpecification.getHeaders());
        logger.info("Payload :" + filterableRequestSpecification.getBody());
    }

    private void logResponse(Response response){
        logger.info("Response context is as below.");
        logger.info("Body : {}", response.getBody());
        logger.info("Status code : {}", response.getStatusCode());
    }
}
