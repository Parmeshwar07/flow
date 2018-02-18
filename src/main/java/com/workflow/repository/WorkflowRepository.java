/**
 * 
 */
package com.workflow.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workflow.model.Workflow;

/**
 * @author Kishan
 *
 */
@Repository
@Transactional
public interface WorkflowRepository extends CrudRepository<Workflow,Integer> {
	
	List<Workflow> findByStatusAndCreatedBy(int status, int createdBy);

	List<Workflow> findByStatus(int status);

	Workflow findByIdAndStatus(int id,int status);

	int countByStatus(int status);

}
