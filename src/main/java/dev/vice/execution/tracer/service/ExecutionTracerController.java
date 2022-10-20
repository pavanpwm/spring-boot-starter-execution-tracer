package dev.vice.execution.tracer.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author Vice Dev
 *
 */

@RestController
@RequestMapping("${dev.vice.tracer.context-path:#{'/api'}}/execution-tracer")
public class ExecutionTracerController {
	
	@Autowired
	ExcecutionTimeTracer excecutionTimeTracer;
	
	@GetMapping
	public Map<String, Queue<HashMap<String, LocalDateTime>>> getTraceData() {
		return excecutionTimeTracer.getTracer();
	} 

}
