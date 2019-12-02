

import com.jco.utils.FileTransfom;

public class Day02b {

	public static void main(String[] args) {
		String fileName = "inputs/day02a.txt";
		
		int intToFind = 19690720;
		
		for (int i=0; i<=99; i++) {
			for (int j=0; j<=99; j++) {
				int[] inputs = FileTransfom.inLineFileToIntArray(fileName, ",");
				
				inputs[1] = i;
				inputs[2] = j;
				
				int index = 0;
				int opCode = inputs[index];
				while (opCode == 1 || opCode == 2) {
					switch (opCode) {
						case 1: 
							inputs[inputs[index + 3]] = inputs[inputs[index + 1]] + inputs[inputs[index + 2]];
							break;
						case 2:
							inputs[inputs[index + 3]] = inputs[inputs[index + 1]] * inputs[inputs[index + 2]];
							break;
						default:
							break;
					}
					
					index += 4;
					opCode = inputs[index];
				}
				
				if (inputs[0] == intToFind) {
					System.out.println("Found !");
					System.out.println("Noun = " + inputs[1]);
					System.out.println("Verb = " + inputs[2]);
					System.out.println("Answer = " + ((inputs[1] * 100) + inputs[2]));
				}
			}
		}
	}

}
