import java.util.ArrayList;

public class Day04b {

	public static void main(String[] args) {
		int cpt = 0;
		
		int min = 235741;
		int max = 706948;
		
		for (int i=min; i<=max; i++) {
			String s = String.valueOf(i);
			String sequence = "";
			
			int sequenceSize = 100;
			boolean isSequenceCorrect = false;
			boolean doesIncrease = true; 
			for (int j=0; j<s.length(); j++) {
				if (j > 0) {
					if (s.charAt(j) == s.charAt(j-1)) {
						if (sequence == "") {
							sequence = String.valueOf(s.charAt(j-1)) + String.valueOf(s.charAt(j));
						} else {
							sequence += String.valueOf(s.charAt(j));
						}
					} else {
						if (!sequence.equals("")) {
							sequenceSize = Math.min(sequenceSize, sequence.length());
							sequence = "";
						}
					}
					if (s.charAt(j) < s.charAt(j-1)) {
						doesIncrease = false;
					}
				}
			}
			
			if (!sequence.equals("")) {
				sequenceSize = Math.min(sequenceSize, sequence.length());
				sequence = "";
			}

			if (sequenceSize == 2) {
				isSequenceCorrect = true;
			}
			
			if (isSequenceCorrect && doesIncrease) {
				cpt++;
			}
			
		}
		
		System.out.println(cpt);
	}

}
