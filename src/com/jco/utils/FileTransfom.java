package com.jco.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileTransfom {
	
	public static ArrayList<Integer> fileToIntList(String fileName) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((i) -> list.add(Integer.parseInt(i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int[] inLineFileToIntArray(String fileName, String splitString) {
		String str = "";
		
		try (InputStream ips = new FileInputStream(fileName);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr)) {
			
			String line;
			while ((line = br.readLine()) != null){
				str = line;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		int inputs[] = Arrays.stream(str.split(splitString))
		        .mapToInt(Integer::valueOf)
		        .toArray();
		
		return inputs;
	}
}
