import java.util.HashMap;

public class EasyProblems {

    public static void main(String[] args){
        EasyProblems problems = new EasyProblems();

        // Problem: 3442. Maximum Difference Between Even and Odd Frequency
        System.out.println("example 1: \"aaaaabbc\": \n" +
                problems.maxDifference("aaaaabbc"));
        System.out.println("example 2: \"abcabcab\": \n" +
                problems.maxDifference("abcabcab"));
    }

    /**
     * <b>Problem: 3442. Maximum Difference Between Even and Odd Frequency</b>
     * <br><br>
     * You are given a string s consisting of lowercase English letters.
     * <br><br>
     * Your task is to find the maximum difference diff = freq(a1) - freq(a2)
     * between the frequency of characters a1 and a2 in the string such that:
     * <br><br>
     * - a1 has an odd frequency in the string.<br>
     * - a2 has an even frequency in the string.<br>
     * - Return this maximum difference.
     * <br><br><br>
     * <b>Notes on the problem</b>
     * <br><br>
     * <i>a1 is always odd and is the max number</i> <br>
     * <i>a2 is always even and is the min number</i>
     * <br><br>
     * - Since the string is lowercase we only have to worry about 26 letters.<br>
     * - Create a map by letters and assign frequency (use ascii value in-relation to 'a'). <br>
     * - Iterate thru the map to find the max-odd and min-even numbers and calculate the difference.
     * <br><br><br>
     * <b>Complexity analysis</b>
     * <br><br>
     * Let n be the length of the string s, and ∣Σ∣ the size of its character set.<br>
     * Since s contains only lowercase letters, ∣Σ∣=26.<br>
     * - Time Complexity: O(n). <br>
     * - Space Complexity: O(∣Σ∣).
     */
    public int maxDifference(String s) {
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();

        for(char ch: s.toCharArray()) { //convert string to an array of chars
            charFreq.put(ch, charFreq.getOrDefault(ch,0) + 1); // update the map with char frequency.
        }

        int minEven = s.length(); // start the min with the max value it can be; so it can be updated properly
        int maxOdd = 0; //start the max with the lowest value it can be; so it can be updated properly

        for (int value: charFreq.values()) {
            if (value % 2 != 0 ) { // if value is odd; update the max odd value
                maxOdd = Math.max(maxOdd, value);
            } else { // if value is even; update the min even value
                minEven = Math.min(minEven, value);
            }
        }

        return maxOdd - minEven;
    }


}
