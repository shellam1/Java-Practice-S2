package cmsc256;

/*
*	Programmer #1:Daanish Fiaz
*	Programmer #2:Asia Shell
*/

public class RecursiveMethods {
	public static void main(String [] args) {
		char ch = 'a';
		int length = 4;
		System.out.println(buildStringOfCharacters(ch, length));
		
		int [] nums = {1, 2, 3, 4, 5};
		int backIndex = 4;
		int [] newArray = (reverseNumArray(nums, backIndex));
		for(int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.println();
		
		
		int [] values = {85,57,1};
		int firstIndex = 0;
		System.out.println(isSmallestToLargest(values, firstIndex));
		
		
		String str = "racecar";
		int begin = 0;
		int end = 6;
		System.out.println(isPalindrome(str, begin, end));
		
		
	}
	
	
	/* 
	 * @returns a String of character, ch. The length is determined
	 * 			by the second parameter, length.
	 */
	public static String buildStringOfCharacters(char ch, int length) {
		
		if(length == 0) {
			return "";
		}
		else {
			return(buildStringOfCharacters(ch, length - 1) + ch);
		}
	}
	
	/*
	 * returns an int array that has the elements in reverse order
	 * 			of the parameter array, nums. 
	 * Process this recursively beginning with the last element.
	 */
	public static int[] reverseNumArray(int[] nums, int backIndex) {
		int frontIndex = nums.length - backIndex - 1;
		if(frontIndex > backIndex) {
			return nums;
		}
		else {
			
		int temp = nums[frontIndex];
		nums[frontIndex] = nums[backIndex];
		nums[backIndex] = temp;
		
		return(reverseNumArray(nums, backIndex - 1));
		
		}
	}
	
	/*
	 * returns true if the int array parameter is sorted from smallest
	 * 			to largest, false otherwise.
	 * Process this recursively beginning with the first element.
	 */
	public static boolean isSmallestToLargest(int[] values, int firstIndex) {
		int backIndex = values.length - 1;
		
		if(firstIndex == backIndex) {
			return true;
		}
		
			if(values[firstIndex] > values[firstIndex + 1]) {
				return false;
			}
			
			return isSmallestToLargest(values, firstIndex + 1);
		}
	
	
	/* 
	 * @returns true if the parameter String, str is a palindrome
	 * 			false otherwise
	 */
	public static boolean isPalindrome(String str, int begin, int end) {
		if(begin >= end) {
			return true;
		}
		if(str.charAt(begin) != str.charAt(end)) {
			return false;
		}
		else {
			return isPalindrome(str, begin += 1, end -= 1);
		}
	}
}
