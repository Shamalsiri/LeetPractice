import java.util.Arrays;
import java.util.HashMap;

public class EasyProblems {

    public static void main(String[] args){
        EasyProblems problems = new EasyProblems();

        // Problem: 3442. Maximum Difference Between Even and Odd Frequency
        System.out.println();
        System.out.println("Problem 3442: Maximum Difference Between Even and Odd Frequency");
        System.out.println("Example 1: \"aaaaabbc\": \n" +
                problems.maxDifference("aaaaabbc"));
        System.out.println("Example 2: \"abcabcab\": \n" +
                problems.maxDifference("abcabcab"));

        //Problem 2: Two Sum
        System.out.println();
        System.out.println("Problem 2: Two Sum");
        int[] p2Ex1 = {2, 7, 11, 15};
        int[] p2Ex2 = {3,2,4};
        System.out.println("Example 1: nums = [2,7,11,15], target = 9: \n" +
                Arrays.toString(problems.twoSum(p2Ex1, 9)));
        System.out.println("Example 2: nums = [3,2,4], target = 6: \n" +
                Arrays.toString(problems.twoSum(p2Ex2, 6)));
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

    /**
     * <b>Problem: 1: Two Sum</b>
     * <br><br>
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * <br><br>
     * <b>Notes</b> <br>
     * You can use the brute force way of iterating thru the array twice. This would end in a O(n^2) time complexity
     * <br><br>
     * Better option would be to create a hashmap with the value as the key and the index as the value. <br>
     * You would then iterate thru the array once, find the complement by target - arr[i], <br>
     * then check if it exists in the map and return it; if not add the
     * current value to the map.<br><br>
     *
     * <b>Complexity analysis</b>
     * Time ComplexitySince Hashmap look ups are O(1) the total time complexity is O(n) (iterate thru the array once to add to the map) <br>
     * Space Complexity: Creating an hashmap of size of the array makes it: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int complement;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }


}
