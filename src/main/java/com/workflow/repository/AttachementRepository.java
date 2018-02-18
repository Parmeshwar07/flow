package com.workflow.repository;

import org.springframework.data.repository.CrudRepository;

import com.workflow.model.Attachement;

public interface AttachementRepository extends CrudRepository<Attachement, Integer> {

	Attachement findById(int attachementId);
}
