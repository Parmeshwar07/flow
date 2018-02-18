package com.workflow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class UserWorkflows {

	@Id @GeneratedValue
	private int id;
	@OneToOne
	private Workflow workflow;
	@Column(nullable=false)
	private int userId;
	private int deUserId;
	private int qcUserId;
	private int mrUserId;
	private int fsUserId;
	private int createdBy;
	private int UpdatedBy;
	private int status=1;	
	private String worldWideUniqId;
	
	private Date created;
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDeUserId() {
		return deUserId;
	}

	public void setDeUserId(int deUserId) {
		this.deUserId = deUserId;
	}

	public int getQcUserId() {
		return qcUserId;
	}

	public void setQcUserId(int qcUserId) {
		this.qcUserId = qcUserId;
	}

	public int getMrUserId() {
		return mrUserId;
	}

	public void setMrUserId(int mrUserId) {
		this.mrUserId = mrUserId;
	}

	public int getFsUserId() {
		return fsUserId;
	}

	public void setFsUserId(int fsUserId) {
		this.fsUserId = fsUserId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		UpdatedBy = updatedBy;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWorldWideUniqId() {
		return worldWideUniqId;
	}

	public void setWorldWideUniqId(String worldWideUniqId) {
		this.worldWideUniqId = worldWideUniqId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
}
