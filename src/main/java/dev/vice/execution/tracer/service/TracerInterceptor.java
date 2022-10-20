package dev.vice.execution.tracer.service;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Vice Dev
 *
 */

@Component
public class TracerInterceptor implements HandlerInterceptor {

	@Autowired
	ExcecutionTimeTracer excecutionTimeTracer;
	@Autowired
	TracerTimestamps tracerTimestamps;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		tracerTimestamps.getExecutionTimestamps().put("0.requestRecievedAt", LocalDateTime.now());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		tracerTimestamps.getExecutionTimestamps().put("99.responseSentAt", LocalDateTime.now());
		excecutionTimeTracer.updateTraceQueue(request.getServletPath(), tracerTimestamps.getExecutionTimestamps());
	}

}
