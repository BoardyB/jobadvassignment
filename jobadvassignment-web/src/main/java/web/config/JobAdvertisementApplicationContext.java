package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({"web.config", "hu.iit.me.controller", "hu.iit.me.dao", "hu.iit.me.service"})
public class JobAdvertisementApplicationContext {

}
