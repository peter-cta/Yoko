package shop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import shop.dao.AccountDAO;
import shop.dao.AccountDAOImpl;
import shop.dao.BrandDAO;
import shop.dao.BrandDAOImpl;
import shop.dao.CustomerDAO;
import shop.dao.CustomerDAOImpl;
import shop.dao.ProductDAO;
import shop.dao.ProductDAOImpl;
import shop.service.AccountService;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "shop")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource  = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/YokoShop");
		dataSource.setUsername("root");
		dataSource.setPassword("chuanh255");
		return dataSource;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
    }
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	
	@Bean
	public AccountDAO getAccountDAO() {
		AccountDAO dao = new AccountDAOImpl(getDataSource());
		return dao;
	}
	
	
	@Bean
	public BrandDAO getBrandDAO() {
		BrandDAO dao = new BrandDAOImpl(getDataSource());
		return dao;
	}
	
	@Bean
	public CustomerDAO getCustomerDAO() {
		CustomerDAO dao = new CustomerDAOImpl(getDataSource());
		return dao;
	}
	
	@Bean
	public ProductDAO getProductDAO() {
		ProductDAO dao = new ProductDAOImpl(getDataSource());
		return dao;
	}
	
}
