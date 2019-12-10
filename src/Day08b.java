import java.util.ArrayList;

import com.jco.utils.FileTransfom;

public class Day08b {
	
	final static int WIDTH = 25;
	final static int HEIGHT = 6;

	public static void main(String[] args) {
		String fileName = "inputs/day08a.txt";
		
		String[] input;
		
		ArrayList<String> tmp = new ArrayList<String>();
		tmp = FileTransfom.fileToStringList(fileName);
		
		String s = tmp.get(0);
		
		input = FileTransfom.splitEqually(s, WIDTH*HEIGHT);
		
		
		int min = 150;
		int index = 100;
		
		for (int i=0; i<input.length; i++) {
			int cpt = 0;
			for (int j=0; j<input[i].length(); j++) {
				if (input[i].charAt(j) == '0') {
					cpt++;
				}
			}
			if (cpt < min) {
				min = cpt;
				index = i;
			}
		}
		
//		System.out.println(index);
		
		int cpt1 = 0;
		for (int j=0; j<input[index].length(); j++) {
			if (input[index].charAt(j) == '1') {
				cpt1++;
			}
		}
		int cpt2 = 0;
		for (int j=0; j<input[index].length(); j++) {
			if (input[index].charAt(j) == '2') {
				cpt2++;
			}
		}
		
		System.out.println(cpt1 * cpt2);
		
		System.out.println("-----");
		for (String s1 : input) {
			System.out.println(s1);
		}
		System.out.println("-----");
		
		String res = "";
		
		for (int i=0; i<WIDTH*HEIGHT; i++) {
			int j = 0;
			boolean found = false;
			while (j<input.length && !found) {
				if (input[j].charAt(i) < '2') {
					res += input[j].charAt(i);
					found = true;
				}
				j++;
				
				if (j>=input.length && !found) {
					res += '2';
				}
			}
		}
		
		String[] output;
				
		output = FileTransfom.splitEqually(res, WIDTH);
		
		for (String s1: output) {
			System.out.println(s1);
		}
	}

}

