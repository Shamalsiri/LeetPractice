import java.util.Arrays;
import java.util.HashMap;

/**
 * For Problem 2: Add Two Numbers
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

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

        //Problem 1: Two Sum
        System.out.println();
        System.out.println("Problem 1: Two Sum");
        int[] p2Ex1 = {2, 7, 11, 15};
        int[] p2Ex2 = {3,2,4};
        System.out.println("Example 1: nums = [2,7,11,15], target = 9: \n" +
                Arrays.toString(problems.twoSum(p2Ex1, 9)));
        System.out.println("Example 2: nums = [3,2,4], target = 6: \n" +
                Arrays.toString(problems.twoSum(p2Ex2, 6)));

        //Problem 2: Add Two Numbers
        System.out.println();
        System.out.println("Problem 2: Add Two Numbers");
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode p2 = problems.addTwoNumbers(l1, l2);
        System.out.println("Example 1: l1 = [ 2 -> 4 -> 3 ] | L2 = [ 5 -> 6 -> 4 ]");
        System.out.printf("[ ");
        while (p2 != null) {
            System.out.printf("" + p2.val);
            if (p2.next != null) {
                System.out.printf(" -> ");
            }
            p2 = p2.next;
        }
        System.out.printf(" ]\n");

        //Problem 3: Longest Substring without repeating characters
        System.out.println();
        System.out.println("Problem 3: Longest Substring without repeating characters");
        problems._3LongestSubstringWithoutRepeats("abcabcbb");
        problems._3LongestSubstringWithoutRepeats("bbbb");

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


    /**
     * <b>Problem 2: Add Two Numbers</b> *takes some thinking in reverse
     * <br><br>
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * <br>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <br><br>
     * <b>Example:</b> <br>
     * Input: l1 = [2,4,3], l2 = [5,6,4]<br>
     * Output: [7,0,8]<br>
     * Explanation: 342 + 465 = 807.<br>
     * <br><br>
     * <b>Thoughts:</b><br>
     * Multi digit addition is done back to front with a carry-over value for anything larger than 10. So: <br>
     *
     * | 2 , 4 , 3 | <br>
     * | 5 , 6 , 4 | <br>
     * -----------<br>
     * | 7 , 0 , 8 |<br>
     * carry 1 over from 4 + 6 to the 3 + 4 making it 3 + 4 + 1
     * <br><br>
     * <b> Programing Solution:</b><br>
     * You need a new node while there is values in l1, l2 or if carry is not 0; <br>
     * Add the carry to the total that is reset. then add l1 val and l2 val before
     * calculating the digit for the node and carry value.<br>
     * Return the first node of the dummy list. (keep a separate pointer at the beginning to return). <br>
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = 0, carry = 0, num;
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            total = total + carry;

            if (l1 != null) {
                total = total + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total = total + l2.val;
                l2 = l2.next;
            }

            num = total % 10; // calculate the last digit that goes in the node
            carry = total / 10; // calculate the carry value for the next calculation;
            total = 0;
            dummy.next = new ListNode(num);
            dummy = dummy.next;

        }

        return res.next;

    }

    /**
     * <b>Problem 3: Longest Substring without repeating characters</b>
     * <br><br>
     * Given a string s, find the length of the longest substring without duplicate characters.
     * <br><br>
     * <b>Example 1: </b><br>
     *  Input: s = "abcabcbb"<br>
     * Output: 3<br>
     * Explanation: The answer is "abc", with the length of 3.
     * <br> <br>
     *  <b>Example 2:</b><br>
     *  Input: s = "pwwkew"<br>
     *  Output: 3<br>
     *  Explanation: The answer is "wke", with the length of 3.<br>
     *  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.<br>
     */
    public void _3LongestSubstringWithoutRepeats(String s) {
        StringBuilder sub = new StringBuilder();
        int max = 0, count = 0;
        char temp;

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);

            if ( sub.toString().indexOf(temp) != -1 ) {
                max = Math.max(count, max);
                count = 0;
            } else {
                sub.append(temp);
                count++;
            }
        }

        System.out.println("max : " + max);
    }


}
