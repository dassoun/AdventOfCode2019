import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day01b {

	public static void main(String[] args) {
		String fileName = "inputs/day01a.txt";
		double TotalfuelAmount = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = FileTransfom.fileToIntList(fileName);
		
		for(Integer i : list) {
			TotalfuelAmount += getFuelAmount(i);
		}
		
		System.out.println(TotalfuelAmount);
	}

	public static double getFuelAmount(int mass) {
		double fuelAmount = 0;
		
		fuelAmount = Math.floor(((double) mass) / 3.0);
		fuelAmount -= 2;
		if (fuelAmount <= 0) {
			return 0;
		} else {
			return (fuelAmount + (getFuelAmount((int) fuelAmount)));
		}
	}
}
