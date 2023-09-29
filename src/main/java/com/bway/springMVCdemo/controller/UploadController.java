package com.bway.springMVCdemo.controller;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("/upload")
	public String getUploadForm() {
		return "Upload";
	}

	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile image, Model model) {
		
		if(!image.isEmpty()) {
			try {
				//copying image file to folder 
				//		changing path to string			uploading image to the path
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/images/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				
				model.addAttribute("msg","Upload success");
				return "Upload";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		model.addAttribute("msg","Upload failed");
		return "Upload";
	}
}
