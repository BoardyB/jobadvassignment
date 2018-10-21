package web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(JobAdvertisementApplicationContext.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
        servletRegistration.setLoadOnStartup(0);
        servletRegistration.addMapping("/");
    }


}
