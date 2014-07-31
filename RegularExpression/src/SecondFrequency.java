/*
 * Given a string "aaabbcccc", 
 * write a program to find the character with the second highest frequency.
 */

public class SecondFrequency {

	public static Character SecondFrequencyCharacter(String string) {
		char result = ' ';
		int[] frequency = new int[2];

		// tempSum,
		char lastChar = string.charAt(0), firstChar = lastChar, secondChar = ' ';

		int sum = 1;
		char compareChar = ' ';
		for (int i = 1; i < string.length(); i++) {
			compareChar = string.charAt(i);

			if (lastChar == compareChar) {
				sum++;
			}

			else {
                //lastChar != compareChar
				if (frequency[1] == 0) {
					frequency[1] = sum;
					firstChar = lastChar;
				}

				else if (frequency[0] == 0) {
					frequency[0] = (sum > frequency[1]) ? frequency[1] : sum;
					frequency[1] = (sum > frequency[1]) ? sum : frequency[1];
					secondChar = (sum > frequency[1])? firstChar : lastChar;
					firstChar = (sum > frequency[1])? lastChar : firstChar;
				}

				else {
					int tempFre = frequency[0];

					if (tempFre > sum)
						continue;

					else {
						if (sum > frequency[1]) {
							frequency[0] = frequency[1];
							frequency[1] = sum;
							firstChar = lastChar;
						}

						else {
							frequency[0] = sum;
							secondChar = lastChar;
						}
					}
				}

				sum = 1;
				lastChar = compareChar;
			}
		//	System.out.println(frequency[0] + " " + frequency[1]);
		}

		if (sum > frequency[1]) {
			frequency[0] = frequency[1];
			frequency[1] = sum;
			secondChar = firstChar;
			firstChar = compareChar;
		}

		else if (sum > frequency[0]) {
			frequency[0] = sum;
			secondChar = compareChar;
		}

		System.out.println(frequency[0] + " " + frequency[1]);
		System.out.println(firstChar + " " + secondChar);
		result = secondChar;
		return result;
	}
	
	/*If this method, then ask first how many kinds of characters, 26 or 256*/
	public static Character SecondFrequencyII(String str){
		int[] charFrequency = new int[26];
		for(int i = 0; i < str.length(); i++){
		//	System.out.println(str.charAt(i));
			charFrequency[str.charAt(i) - 97]++;
		}
		
		int firstSum = 0, secondSum = 0;
		char firstChar = ' ', secondChar = ' ';
		for(int i = 0; i < 26; i++){
			int tempSum = charFrequency[i];
			
			if(tempSum > firstSum){
				secondSum = firstSum;
				firstSum = tempSum;
				secondChar = firstChar;
				firstChar = (char)(i + 97);
			}
			
			else if(tempSum < secondSum)
				continue;
			
			else{
				secondSum = tempSum;
				secondChar = (char)(i + 97);
			}
		}
		return secondChar;
	}
	
	
	public static void main(String[] args) {
		String string = "aaaebbccccddddd";
		System.out.println(SecondFrequencyII(string));
		//System.out.println(SecondFrequencyCharacter(string));
	}
}
