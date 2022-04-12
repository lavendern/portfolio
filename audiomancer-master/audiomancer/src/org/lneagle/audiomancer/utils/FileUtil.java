package org.lneagle.audiomancer.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
	
	
	public static void writeToTextFile(List<String> lines, String path)
	{
		Path file;

		file = Paths.get(path);
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeToTextFile(String message, String path)
	{
		Path file;
		List<String> lines;
		
		file = Paths.get(path);
		try {
			Files.write(file, lines = Arrays.asList(message), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static List<String> readTextFile(String path)
	{
		Path file = Paths.get(path);
		try {
			return Files.readAllLines(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean fileExists(String path)
	{
		File f = new File(path);
		if(f.exists() && !f.isDirectory())
		{
			return true;
		}
		return false;
	}
	
	public static URI createURI(String URI)
	{
		URI authlink = null;
		try {
			authlink = new URI(URI);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authlink;
	}
	
	public static boolean removeTextFile(String path)
	{
		Path file = Paths.get(path);

			try {
				return Files.deleteIfExists(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;

	}
	
	//public static boolean getSettings(Setting setting)
}
