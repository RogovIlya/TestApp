package ru.rogov.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:configDB.properties")
public class DbConfiguration extends WebMvcConfigurerAdapter
{
	@Autowired
	public Environment env;
	
	@Bean(name = "jdbc")
	public JdbcTemplate jdbc(DataSource dataSource)
	{
		return  new JdbcTemplate(dataSource);
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName(env.getProperty("db.driverClassName"));
	    driverManagerDataSource.setUrl(env.getProperty("db.url"));
	    driverManagerDataSource.setUsername(env.getProperty("db.username"));
	    driverManagerDataSource.setPassword(env.getProperty("db.password"));
	    // для записи SQL логов
	    Log4jdbcProxyDataSource log4jdbc = new Log4jdbcProxyDataSource(driverManagerDataSource);
	    return log4jdbc;
	}
}

