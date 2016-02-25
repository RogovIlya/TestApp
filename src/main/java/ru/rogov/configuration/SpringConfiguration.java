package ru.rogov.configuration;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.rogov")
public class SpringConfiguration extends WebMvcConfigurerAdapter
{
	
	@Bean(name = "jdbc")
	public JdbcTemplate jdbcTepmlate(DataSource dataSource)
	{
		return  new JdbcTemplate(dataSource);
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/db");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("password");
	    // для записи SQL логов
	    Log4jdbcProxyDataSource log4jdbc = new Log4jdbcProxyDataSource(driverManagerDataSource);
	    return log4jdbc;
	}
	
	@Bean(name = "Configuration")
	public ViewResolver viewResolver()
	{
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(true);
		resolver.setPrefix("/WEB-INF/ftl/");
		resolver.setSuffix(".ftl");
		
		return resolver;
	}

	@Bean(name = "freemarkerConfig")
	public FreeMarkerConfigurer freeMarkerConfigurer()
	{
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/");
		configurer.setDefaultEncoding("UTF-8");

		return configurer;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
	{
		configurer.ignoreUnknownPathExtensions(false).defaultContentType(MediaType.TEXT_HTML);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		registry.freeMarker();
	}

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}