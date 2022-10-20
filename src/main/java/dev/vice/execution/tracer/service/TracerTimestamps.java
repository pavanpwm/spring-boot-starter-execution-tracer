package dev.vice.execution.tracer.service;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


/**
 * 
 * @author Vice Dev
 *
 */

@Component
@RequestScope
public class TracerTimestamps {
	
	private HashMap<String, LocalDateTime> executionTimestamps = new HashMap<String, LocalDateTime>();

	public HashMap<String, LocalDateTime> getExecutionTimestamps() {
		return executionTimestamps;
	}

	public void setExecutionTimestamps(HashMap<String, LocalDateTime> executionTimestamps) {
		this.executionTimestamps = executionTimestamps;
	}
	
	

}
