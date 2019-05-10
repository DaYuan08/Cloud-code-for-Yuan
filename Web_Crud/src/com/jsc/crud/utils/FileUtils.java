package com.jsc.crud.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUtils {

	public static String getHeaderPath(Part headerImg,String storeDir) {
		String contentType = headerImg.getContentType();
		String suffix = contentType.replace("image/", "");
		String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
		//自定义保存路径
		String url = "ua/" + fileName;
		File file = new File(storeDir, url);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			Files.copy(headerImg.getInputStream(), file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
}
