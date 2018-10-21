package web.config;

import hu.iit.me.service.ApplicantService;
import hu.iit.me.service.BasicApplicantService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicantConfiguration {

    @Bean
    public ApplicantService applicantService() {
        return new BasicApplicantService();
    }
}
