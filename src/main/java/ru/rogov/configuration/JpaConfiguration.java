package ru.rogov.configuration;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
@EnableJpaRepositories("ru.rogov.repository")
public class JpaConfiguration
{

	@Autowired
	public Environment	env;

	@Autowired
	private DataSource	dataSource;

	@Bean(name = "transactionManager")
	public JpaTransactionManager jpaTransMan()
	{
		JpaTransactionManager jtManager = new JpaTransactionManager(entityManagerFactory().getObject());
		return jtManager;
	}

	/*@Bean
	public EntityManager entityManager()
	{
		return entityManagerFactory().getObject().createEntityManager();
	}*/

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setDataSource(dataSource);
		lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lcemfb.setPackagesToScan(env.getProperty("packageScan"));
		lcemfb.setJpaProperties(jpaProperties());
		LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
		lcemfb.setLoadTimeWeaver(loadTimeWeaver);
		return lcemfb;
	}

	private Properties jpaProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

}
