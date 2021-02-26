package com.example.demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {

	@GetMapping("doc/{document}")
	public void doc(@PathParam(value = "document") String document) {
	
	} 
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String test(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		String dir = System.getProperty("user.dir");
				
		String name = multipartFile.getOriginalFilename();
		
		byte[] bytes = multipartFile.getBytes();
		File file = new File(dir, name);		
		
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
		
		stream.write(bytes);
		stream.close();
		
		
	return "upload";
	} 
}
