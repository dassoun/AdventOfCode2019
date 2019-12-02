package com.jco.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileTransfom {
	
	public static ArrayList<Integer> fileToIntList(String fileName) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			//list = stream.collect(Collectors.toList());
			stream.forEach((i) -> list.add(Integer.parseInt(i)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
