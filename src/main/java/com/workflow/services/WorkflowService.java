/**
 * 
 */
package com.workflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.model.Workflow;
import com.workflow.repository.WorkflowRepository;

/**
 * @author Kishan
 *
 */
@Service
public class WorkflowService {
	
	@Autowired
	private WorkflowRepository repository;

	public Workflow add(Workflow workflow) {		
		return repository.save(workflow);
	}		
	
	public Iterable<Workflow> list() {		
		return repository.findAll();
	}
}
