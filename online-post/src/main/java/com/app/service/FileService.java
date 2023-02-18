/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 30-Dec-2022 11:43:14 PM
*/

package com.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String uploadImage(String path, MultipartFile file) throws IOException;
	
	InputStream getResource(String path, String fileName) throws FileNotFoundException;
}
