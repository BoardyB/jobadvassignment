package web.config;

import hu.iit.me.service.BasicJobService;
import hu.iit.me.service.JobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Bean
    public JobService jobService() {
        return new BasicJobService();
    }

}
