/**
 * 
 */
package com.workflow.services;

import com.workflow.model.Workflow;
import com.workflow.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.workflow.common.WorkflowConstants.DeaultValues.WORKFLOW_TYPE_ENTRY_STATUS;

/**
 * @author Kishan
 *
 */
@Service
public class EntryService {
	
	@Autowired
	private WorkflowRepository repository;

	public Workflow add(Workflow workflow) {		
	    workflow.setStatus(WORKFLOW_TYPE_ENTRY_STATUS.getIntValue());
		return repository.save(workflow);
	}		
	
	public Iterable<Workflow> list() {		
		return repository.findByStatus(WORKFLOW_TYPE_ENTRY_STATUS.getIntValue());
	}

	public Workflow get(int id){
        return repository.findByIdAndStatus(id,WORKFLOW_TYPE_ENTRY_STATUS.getIntValue());
    }

    public boolean delete(int id){
	    if(repository.existsById(id)) {
             repository.deleteById(id);
             return true;
        }
        return false;
    }

    public boolean update(int id,Workflow workflow){
        if(repository.existsById(id)) {
            workflow.setId(id);
            workflow.setStatus(WORKFLOW_TYPE_ENTRY_STATUS.getIntValue());
            repository.save(workflow);
            return true;
        }
        return false;
    }

    public int getEntryCount(){
       return repository.countByStatus(WORKFLOW_TYPE_ENTRY_STATUS.getIntValue());
    }

}
