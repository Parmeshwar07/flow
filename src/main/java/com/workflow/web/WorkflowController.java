package com.workflow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.model.Workflow;
import com.workflow.services.WorkflowService;

@RestController
@RequestMapping("/flow")
public class WorkflowController {
	
	@Autowired
	private WorkflowService workflowService;
	
	@PostMapping("/add")
	private @ResponseBody Workflow add(@RequestBody Workflow workflow) {
		return workflowService.add(workflow);
	}
	
	@GetMapping("/list")
	private @ResponseBody Iterable<Workflow> list() {
		return workflowService.list();
	}
	
	@GetMapping("/heloo")
	private @ResponseBody String getMessage() {
		return "Welcome to Spring boot application";
	}
}
