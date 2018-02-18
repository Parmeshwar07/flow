package com.workflow.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.workflow.model.Attachement;
import com.workflow.services.FileUploadDownloadService;


@RestController
@RequestMapping("/upload_download")
public class FileUploadDownloadController {
	
	@Autowired
	private FileUploadDownloadService service;
	
	 @PostMapping("/upload") 
	 public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
           throw new Exception("Please select file");
        }
        return service.uploadFile(file);
	  }
	 
	 @GetMapping("/download")
	 protected void downloadFile(@RequestParam(value = "attachId") Integer attachId,HttpServletResponse response)
	            throws Exception {
		 	Attachement attachement=service.getAttachementById(attachId);
	        response.setContentType("application/pdf");
	        response.setHeader("Content-disposition", "attachment; filename=" +attachement.getFileName());
	        response.setContentLength(attachement.getAttachement().length);
	        response.getOutputStream().write(attachement.getAttachement());
	        response.getOutputStream().flush();
	    }

}
