package SchoolAdministration.App.config;

import javax.sql.DataSource;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	auth.jdbcAuthentication().dataSource(dataSource)
	.usersByUsernameQuery(
	"select username,password, enabled from users where username=?")
	.authoritiesByUsernameQuery(
	"select username, rolename from user_roles where username=?");
	} 
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		 http
         .authorizeRequests()
         	.antMatchers("/","/login","css/app.css","/h2-console").permitAll()
            /*.antMatchers("css/app.css").access("hasRole('ROLE_ADMIN')")*/
            .antMatchers("/newseller").access("hasRole('ROLE_ADMIN')")
         	.antMatchers("/seller").access("hasRole('ROLE_ADMIN')")
        	.antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
        	.antMatchers("/saveseller").access("hasRole('ROLE_ADMIN')")
        	.antMatchers("/updateseller").access("hasRole('ROLE_ADMIN')")
        	.antMatchers("/updateorder").access("hasRole('ROLE_ADMIN')")
        	.antMatchers("/loginHome").access("hasRole('ROLE_ADMIN')")
         	.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password");
		// .and()
		//	.csrf().disable();
/*	http.authorizeRequests()
	.antMatchers("/newseller").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/seller").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/saveseller").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/updateseller").access("hasRole('ROLE_ADMIN')")
	.anyRequest().permitAll()*/
/*	.and()
	.formLogin().loginPage("/login")
	.usernameParameter("username").passwordParameter("password")
	.and()
	.logout().logoutSuccessUrl("/login?logout") 
	.and()
	.exceptionHandling().accessDeniedPage("/403")
	.and()
	.csrf();*/
	}
}