package org.mxkphotography.config;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class WebConfigurationTest {

    private WebConfiguration webConfiguration = new WebConfiguration();

    @Test
    public void configureMessageConverters() throws Exception {
        List<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<>();
        webConfiguration.configureMessageConverters(httpMessageConverterList);
    }

    @Test
    public void addCorsMappings() throws Exception {
        CorsRegistry corsRegistry = Mockito.mock(CorsRegistry.class);

        webConfiguration.addCorsMappings(corsRegistry);

        verify(corsRegistry).addMapping("/**");
    }

    @Test
    public void addResourceHandlers() throws Exception {
        ResourceHandlerRegistry resourceHandlerRegistry = Mockito.mock(ResourceHandlerRegistry.class);
        ResourceHandlerRegistration resourceHandlerRegistration = Mockito.mock(ResourceHandlerRegistration.class);
        when(resourceHandlerRegistry.addResourceHandler(anyString())).thenReturn(resourceHandlerRegistration);

        webConfiguration.addResourceHandlers(resourceHandlerRegistry);

        verify(resourceHandlerRegistration).addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Test
    public void addViewControllers() throws Exception {
        ViewControllerRegistry viewControllerRegistry = Mockito.mock(ViewControllerRegistry.class);
        ViewControllerRegistration viewControllerRegistration = Mockito.mock(ViewControllerRegistration.class);

        when(viewControllerRegistry.addViewController(anyString())).thenReturn(viewControllerRegistration);
        webConfiguration.addViewControllers(viewControllerRegistry);

        verify(viewControllerRegistration).setViewName(anyString());
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/public/"
    };

}