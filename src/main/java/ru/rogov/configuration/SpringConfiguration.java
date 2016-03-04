package ru.rogov.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.rogov")
public class SpringConfiguration extends WebMvcConfigurerAdapter
{
	@Bean(name = "viewResolver")
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
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
}