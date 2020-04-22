package practice.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *	If there is no common prefix, return an empty string "".
 * */
public class LongestCommonPrefix_14 {
	public static void main(String[] args) {
		String[] strs = new String[]{"flower","flow","flight"};
		System.out.println(longestCommonPrefix_1(strs));
	}//end main()

	/**
	 * Make full use of the methods of the String class.<br>
	 * 1. Find the shortest  string.<br>
	 * 2. Compare it to each element of the string array from beginning to end.<br>
	 * 3. If it does not match any of the elements in the string array, it is clipped off the last character and out of the for loop.<br>
	 * 4. When its length is zero, break out of the while loop.
	 * */
	
	/*
	 * Test Data:
	 * ["dog","racecar","car"]
	 * ["flower","flow","flight"]
	 * ["ca","a"]
	 * ["a"]
	 * ["aca","cba"]
	 * */
public static String longestCommonPrefix_1(String[] strs) {
	
	if (strs == null || strs.length == 0)
        return "";
	// Find the shortest  string.
	String minString = strs[0];
	for(int i=1;i<strs.length;i++) {
		if(minString.length()>strs[i].length()) {
			minString = strs[i];
		}else {
			continue;
		}//end if
	}//end for

	//Find whether  other strings include the minString.
	boolean isInclude = true;
		while(minString!=null) {
			for(int i=0;i<strs.length;i++) {
				if(strs[i].startsWith(minString)) {
					isInclude = true;
				}else {
					minString=minString.substring(0, minString.length()-1);
					isInclude = false;
					break;
				}//end if
			}//end for
			if(isInclude == true) 
				break;
			else ;
		}//end while
		
	return minString;
        
    }//end longestCommonPrefix()

/**
 * Use the simply method.
 * 1. Find the shortest  string.<br>
 * 2. Using two for loops, the outer loop's control condition is the length of the shortest string, 
 * and the memory loop's control condition is each element of the string array<br>
 * */
public static String longestCommonPrefix_2(String[] strs) {
	
	if (strs == null || strs.length == 0)
        return "";
	// Find the shortest  string.
	String minString = strs[0];
	for(int i=1;i<strs.length;i++) {
		if(minString.length()>strs[i].length()) {
			minString = strs[i];
		}else {
			continue;
		}//end if
	}//end for

	//Find whether  other strings include the minString.
	boolean isInclude = true;
	StringBuilder str = new StringBuilder();
	for (int j = 0; j < minString.length(); j++) {
		for (int i = 0; i < strs.length-1; i++) {
			if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
				isInclude = true;
			} else {
				isInclude = false;
				break;
			}//end if
		}// end for
		if(isInclude==true){
			str.append(minString.charAt(j));
		}else if(isInclude == false&&j==0) {
			break;
		}//end if
	}// end for
	
	return String.valueOf(str);
        
    }//end longestCommonPrefix()

/**
 * Answer online.
 * Horizontal scanning
 * */
public String longestCommonPrefix_3(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }        
    return prefix;
}//end longestCommonPrefix()

/**
 * Answer online.
 * Binary search
 * */
public static String longestCommonPrefix_4(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}
/**aiding method */
private static boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}
}//end LongestCommonPrefix_14
