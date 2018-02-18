package com.workflow.services;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.workflow.model.Attachement;
import com.workflow.repository.AttachementRepository;
import static com.workflow.constants.WorkFlowConstants.*;

@Service
public class FileUploadDownloadService {
	
	@Autowired
	private AttachementRepository attachementRepository;
	
	public String uploadFile(MultipartFile file) throws Exception{
		if(!file.getOriginalFilename().contains(".pdf"))
			throw new Exception("Accepts only pdf files");
		Attachement attchmnt=new Attachement();
		attchmnt.setAttachement(file.getBytes());
		attchmnt.setCreatedDate(new Date());
		attchmnt.setFileName(file.getOriginalFilename());
		attachementRepository.save(attchmnt);
		return FILE_UPLOAD_SUCCESS;
	}
	
	public Attachement getAttachementById(int attachId) throws Exception{
		Attachement attachement=null;
		attachement=attachementRepository.findById(attachId);
		if(attachement==null)
			throw new Exception("Attachement not found");
		return attachement;
	}

}
