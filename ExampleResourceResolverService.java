package com.example.core.services;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * ExampleResourceResolverService Service interface class
 * Service is invoked to get the Resource Resolver using example-service-user
 *
 */
public interface ExampleResourceResolverService {

    /**
     * Returns Resource Resolver using subservice.
     *
     * @return ResourceResolver
     */
    public ResourceResolver getResourceResolver();

    /**
     * Closes the ResourceResolver session
     *
     * @param ResourceResolver
     */
    public void closeResourceResolver(ResourceResolver resolver);
}
