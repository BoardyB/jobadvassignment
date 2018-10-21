package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class SerializationConfiguration extends WebMvcConfigurationSupport {

    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
        addDefaultHttpMessageConverters(converters);
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter() {
        return new MappingJackson2HttpMessageConverter();
    }
}
