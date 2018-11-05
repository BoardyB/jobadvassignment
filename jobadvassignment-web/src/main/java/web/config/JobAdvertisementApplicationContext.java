package web.config;

import hu.iit.me.controller.ApplicantController;
import hu.iit.me.controller.JobController;
import hu.iit.me.service.ApplicantService;
import hu.iit.me.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"hu.iit.me.dao", "web.config", "hu.iit.me.controller"})
public class JobAdvertisementApplicationContext {

    private JobService jobService;
    private ApplicantService applicantService;

    @Autowired
    public JobAdvertisementApplicationContext(JobService jobService, ApplicantService applicantService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
    }

    @Bean
    public JobController jobController() {
        return new JobController(jobService);
    }

    @Bean
    public ApplicantController applicantController() {
        return new ApplicantController(applicantService);
    }

}
