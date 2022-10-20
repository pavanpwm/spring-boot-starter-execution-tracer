package dev.vice.execution.tracer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Vice Dev
 *
 */

@Configuration
public class TraceInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	TracerInterceptor tracerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tracerInterceptor);
	}
}
