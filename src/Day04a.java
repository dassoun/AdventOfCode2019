
public class Day04a {

	public static void main(String[] args) {
		int cpt = 0;
		
		int min = 235741;
		int max = 706948;
		
		for (int i=min; i<=max; i++) {
			String s = String.valueOf(i);
			
			boolean isSame = false;
			boolean doesIncrease = true; 
			for (int j=0; j<s.length(); j++) {
				if (j > 0) {
					if (s.charAt(j) == s.charAt(j-1)) {
						isSame = true;
					}
					if (s.charAt(j) < s.charAt(j-1)) {
						doesIncrease = false;
					}
				}
			}
			
			if (isSame && doesIncrease) {
				cpt++;
			}
		}
		
		System.out.println(cpt);
	}

}
