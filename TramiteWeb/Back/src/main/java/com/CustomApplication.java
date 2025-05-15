package com;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.citizentech.presentacion.CORSFilter;

 
public class CustomApplication extends ResourceConfig 
{
    public CustomApplication() 
    {
        packages("com.citizentech");
	    register(LoggingFilter.class);
        register(CORSFilter.class);
        register(JacksonFeature.class);
    }
}