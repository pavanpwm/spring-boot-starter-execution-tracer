package dev.vice.execution.tracer.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.EvictingQueue;


/**
 * 
 * @author Vice Dev
 *
 */

@Service
public class ExcecutionTimeTracer {

	@Value("${dev.vice.tracer.size:#{100}}")
	private Integer tracerSize;
	@Value("${dev.vice.tracer.log.errors:#{false}}")
	private Boolean logErrors;

	private Map<String, Queue<HashMap<String, LocalDateTime>>> tracer = new HashMap<String, Queue<HashMap<String, LocalDateTime>>>();

	public synchronized void updateTraceQueue(String api, HashMap<String, LocalDateTime> timestamps) {
		if (tracer.get(api) == null) {
			Queue<HashMap<String, LocalDateTime>> evictingQueue = EvictingQueue.create(tracerSize);
			tracer.put(api, evictingQueue);
		}
		try {
			tracer.get(api).add(timestamps);
		} catch (Exception e) {
			if (logErrors) {
				e.printStackTrace();
			}
		}
	}

	public Integer getTracerSize() {
		return tracerSize;
	}

	public void setTracerSize(Integer tracerSize) {
		this.tracerSize = tracerSize;
	}

	public Boolean getLogErrors() {
		return logErrors;
	}

	public void setLogErrors(Boolean logErrors) {
		this.logErrors = logErrors;
	}

	public Map<String, Queue<HashMap<String, LocalDateTime>>> getTracer() {
		return tracer;
	}

	public void setTracer(Map<String, Queue<HashMap<String, LocalDateTime>>> tracer) {
		this.tracer = tracer;
	}

}
