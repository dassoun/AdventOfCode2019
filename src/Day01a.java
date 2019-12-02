import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day01a {

	public static void main(String[] args) {
		String fileName = "inputs/day01.txt";
		double TotalfuelAmount = 0;
		double fuelAmount; 
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = FileTransfom.fileToIntList(fileName);
		
		for(Integer i : list) {
			fuelAmount = Math.floor(i.doubleValue() / 3.0);
			fuelAmount -= 2;
			TotalfuelAmount += fuelAmount;
		}
		
		System.out.println(TotalfuelAmount);
	}

}
