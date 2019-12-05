import com.jco.utils.FileTransfom;

public class Day05a {

	final static String POSTION_MODE 	= "0";
	final static String IMMEDIATE_MODE 	= "1";
	
	final static int INPUT = 1;
	
	public static void main(String[] args) {
		
		
		String fileName = "inputs/day05a.txt";
		
		int inputs[] = FileTransfom.inLineFileToIntArray(fileName, ",");
		
		int index = 0;
		
//		for (int i : inputs) {
//			System.out.println(i);
//		}
//		
//		System.exit(1);
		
		String instruction = String.valueOf(inputs[0]);
		int opCode;
		if (instruction.length() >= 2) {
			opCode = Integer.valueOf(instruction.substring(instruction.length() - 2));
		} else {
			opCode = Integer.valueOf(instruction);
		}
		
		
		while(index < inputs.length && (opCode == 1 || opCode == 2 || opCode == 3 || opCode == 4)) {
			
			String modeParam1;
			String modeParam2;
			String modeParam3;
			
			if (instruction.length() >= 3) {
				modeParam1 = instruction.substring(instruction.length() - 3, instruction.length() - 2);
			} else {
				modeParam1 = POSTION_MODE;
			}
			if (instruction.length() >= 4) {
				modeParam2 = instruction.substring(instruction.length() - 4, instruction.length() - 3);
			} else {
				modeParam2 = POSTION_MODE;
			}
			if (instruction.length() >= 5) {
				modeParam3 = instruction.substring(instruction.length() - 5, instruction.length() - 4);
			} else {
				modeParam3 = POSTION_MODE;
			}
			
			int op1;
			int op2;
			int op3;
			
			switch (opCode) {
				case 1: 
					if (modeParam1.equals(POSTION_MODE)) {
						op1 = inputs[inputs[index + 1]];
					} else {
						op1 = inputs[index + 1];
					}
					
					if (modeParam2.equals(POSTION_MODE)) {
						op2 = inputs[inputs[index + 2]];
					} else {
						op2 = inputs[index + 2];
					}
					
					if (modeParam3.equals(POSTION_MODE)) {
						op3 = inputs[index + 3];
					} else {
						op3 = index + 3;
					}
					
					inputs[op3] = op1 + op2;
					
					index += 4;
					break;
					
				case 2:
					if (modeParam1.equals(POSTION_MODE)) {
						op1 = inputs[inputs[index + 1]];
					} else {
						op1 = inputs[index + 1];
					}
					
					if (modeParam2.equals(POSTION_MODE)) {
						op2 = inputs[inputs[index + 2]];
					} else {
						op2 = inputs[index + 2];
					}
					
					if (modeParam3.equals(POSTION_MODE)) {
						op3 = inputs[index + 3];
					} else {
						op3 = index + 3;
					}
					
					inputs[op3] = op1 * op2;
					
					index += 4;
					break;
					
				case 3:
					inputs[inputs[index + 1]] = INPUT;
					index += 2;
					break;
					
				case 4:
					if (modeParam1.equals(POSTION_MODE)) {
						op1 = inputs[inputs[index + 1]];
					} else {
						op1 = inputs[index + 1];
					}
					
					System.out.println(op1);
					
					index += 2;
					break;
					
				default:
					break;
			}
			
//			for (int i : inputs) {
//				System.out.println(i);
//			}

			
			instruction = String.valueOf(inputs[index]);
			
			if (instruction.length() >= 2) {
				opCode = Integer.valueOf(instruction.substring(instruction.length() - 2));
			} else {
				opCode = Integer.valueOf(instruction);
			}
		}
		
//			
//			index += 4;
//			opCode = inputs[index];
//		
//		if (inputs[0] == intToFind) {
//			System.out.println("Found !");
//			System.out.println("Noun = " + inputs[1]);
//			System.out.println("Verb = " + inputs[2]);
//			System.out.println("Answer = " + ((inputs[1] * 100) + inputs[2]));
//		}
		
		
//		for (int i : inputs) {
//			System.out.println(i);
//		}
	}

}
