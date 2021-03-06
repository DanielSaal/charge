package br.com.dsa.charge;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@ServletComponentScan
@SpringBootApplication
public class ChargeApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChargeApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ChargeApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	// @Configuration
	// public static class MvcConfig extends WebMvcConfigurerAdapter {
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addRedirectViewController("/", "/registries");
	// }
	// }
}
