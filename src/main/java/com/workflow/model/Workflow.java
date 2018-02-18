package com.workflow.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Workflow {
	@Id @GeneratedValue
	private int id;
	private String local_uniq_id;
	private Date company_receive_date;	
	private String country;
	private String submission_country;
	private String lp_name;
	private String seriousness;
	private String expedite;
	private String reason;
	private String Valid;
	private String file_path;
	private int createdBy;
	private int updatedBy;
	private int status=0;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	private SubWorkflowData de;
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	private SubWorkflowData qc;
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	private SubWorkflowData mr;
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
	private SubWorkflowData fs;

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

	public String getLocal_uniq_id() {
		return local_uniq_id;
	}

	public void setLocal_uniq_id(String local_uniq_id) {
		this.local_uniq_id = local_uniq_id;
	}

	public Date getCompany_receive_date() {
		return company_receive_date;
	}

	public void setCompany_receive_date(Date company_receive_date) {
		this.company_receive_date = company_receive_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubmission_country() {
		return submission_country;
	}

	public void setSubmission_country(String submission_country) {
		this.submission_country = submission_country;
	}

	public String getLp_name() {
		return lp_name;
	}

	public void setLp_name(String lp_name) {
		this.lp_name = lp_name;
	}

	public String getSeriousness() {
		return seriousness;
	}

	public void setSeriousness(String seriousness) {
		this.seriousness = seriousness;
	}

	public String getExpedite() {
		return expedite;
	}

	public void setExpedite(String expedite) {
		this.expedite = expedite;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getValid() {
		return Valid;
	}

	public void setValid(String valid) {
		Valid = valid;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public SubWorkflowData getDe() {
		return de;
	}

	public void setDe(SubWorkflowData de) {
		this.de = de;
	}

	public SubWorkflowData getQc() {
		return qc;
	}

	public void setQc(SubWorkflowData qc) {
		this.qc = qc;
	}

	public SubWorkflowData getMr() {
		return mr;
	}

	public void setMr(SubWorkflowData mr) {
		this.mr = mr;
	}

	public SubWorkflowData getFs() {
		return fs;
	}

	public void setFs(SubWorkflowData fs) {
		this.fs = fs;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
			
}
