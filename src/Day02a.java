import com.jco.utils.FileTransfom;

public class Day02a {

	public static void main(String[] args) {
		String fileName = "inputs/day02a.txt";
		
		int[] inputs = FileTransfom.inLineFileToIntArray(fileName, ",");

		inputs[1] = 12;
		inputs[2] = 2;
		
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
		
//		for (int i: inputs) {
//			System.out.println(i);
//		}
		
		System.out.println(inputs[0]);
	}

}
