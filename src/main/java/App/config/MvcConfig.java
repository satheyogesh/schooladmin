package App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.Validator;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.MessageSource;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/newstudent").setViewName("newstudent");
        registry.addViewController("/student").setViewName("newstudent");
        registry.addViewController("/savestudent").setViewName("newstudent");
        registry.addViewController("/updatestudent").setViewName("newstudent");
        registry.addViewController("/deletestudent").setViewName("newstudent");
        
        registry.addViewController("/newbatch").setViewName("batch");
        registry.addViewController("/batch").setViewName("batch");
        registry.addViewController("/savebatch").setViewName("batch");
        registry.addViewController("/updatebatch").setViewName("batch");
        registry.addViewController("/deletebatch").setViewName("batch");
        
        registry.addViewController("/loginHome").setViewName("LoginHome");
        registry.addViewController("/updateorder").setViewName("updateorder");
 
        registry.addViewController("/all-tasks").setViewName("index");
        registry.addViewController("/new-task").setViewName("index");
        registry.addViewController("/save-task").setViewName("index");
        registry.addViewController("/update-task").setViewName("index");
        registry.addViewController("/delete-task").setViewName("index");
        
    }
    
    @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
 	   DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
 	   driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 	   driverManagerDataSource.setUrl("jdbc:sqlserver://database-1.crotnk9kagij.us-east-1.rds.amazonaws.com;databaseName=medikart");
 	   driverManagerDataSource.setUsername("awsrdsadmin");
 	   driverManagerDataSource.setPassword("success12!#");
 	   return driverManagerDataSource;
    }
    
    @Bean
    public MessageSource messageSource() {
       ResourceBundleMessageSource source = new ResourceBundleMessageSource();
       source.setBasename("message");
       return source;
    }

    @Override
    public Validator getValidator() {
       LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
       validator.setValidationMessageSource(messageSource());
       return validator;
    }

}