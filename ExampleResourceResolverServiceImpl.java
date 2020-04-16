package com.example.core.services.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.core.constants.Constants;
import com.example.core.services.ExampleResourceResolverService;

/**
 * ExampleResourceResolverService Impl class
 * Reusable service Resource resolver by using Example System user
 *
 */
@Component(service = ExampleResourceResolverService.class)
public class ExampleResourceResolverServiceImpl implements ExampleResourceResolverService {

    private static final Logger log = LoggerFactory.getLogger(ExampleResourceResolverServiceImpl.class);

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    public ResourceResolver getResourceResolver() {
        ResourceResolver resourceResolver = null;
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ResourceResolverFactory.SUBSERVICE,
                    Constants.RESOURCE_RESOLVER_SERVICE_USER);
            resourceResolver = resolverFactory.getServiceResourceResolver(param);
        } catch (LoginException e) {
            log.error("LoginException{}", e);
        }
        return resourceResolver;
    }

    @Override
    public void closeResourceResolver(ResourceResolver resolver) {
        if(null!=resolver && resolver.isLive()){
            resolver.close();
        }
    }

}
