package mvc;

import org.junit.Test;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Keesun Baik
 */
public class WebAppInitAPI {

    @Test
    public void webApplicationInitializer(){
        WebApplicationInitializer initializer = null;
    }

    class SampleWebAppInitializer implements WebApplicationInitializer {

        @Override
        public void onStartup(ServletContext servletContext) throws ServletException {
            AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//            ac.register(AppConfig.java);
            ServletContextListener listener = new ContextLoaderListener(ac);
            servletContext.addListener(listener);

            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//            ac.register(WebConfig.class);
            ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring", new DispatcherServlet(context));
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/app");
        }
    }

}
