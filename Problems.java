import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

public class Problems {

    public static void main(String[] args){
        Problems problems = new Problems();

        // Problem: 3442. Maximum Difference Between Even and Odd Frequency
        System.out.println();
        System.out.println("Problem 3442: Maximum Difference Between Even and Odd Frequency");
        System.out.println("Example 1: \"aaaaabbc\": \n" +
                problems._1_maxDifference("aaaaabbc"));
        System.out.println("Example 2: \"abcabcab\": \n" +
                problems._1_maxDifference("abcabcab"));

        //Problem 1: Two Sum
        System.out.println();
        System.out.println("Problem 1: Two Sum");
        int[] p2Ex1 = {2, 7, 11, 15};
        int[] p2Ex2 = {3,2,4};
        System.out.println("Example 1: nums = [2,7,11,15], target = 9: \n" +
                Arrays.toString(problems._2_twoSum(p2Ex1, 9)));
        System.out.println("Example 2: nums = [3,2,4], target = 6: \n" +
                Arrays.toString(problems._2_twoSum(p2Ex2, 6)));

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
        int max = problems._3_LongestSubstringWithoutRepeats("abcabcbb");
        System.out.println("Example 1: string \"abcabcbb\": \n" + max);
        max = problems._3_LongestSubstringWithoutRepeats("bbbb");
        System.out.println("Example 1: string \"bbbb\": \n" + max);

        //Problem 4: Median Sorted Arrays
        System.out.println();
        System.out.println("Problem 4: Median Sorted Arrays ");
        int[] num1 = {1,3};
        int[] num2 = {2};
        double res = problems._4_findMedianSortedArray(num1, num2);
        System.out.println("EXxample 1: nums1 = [1,3] | num2 = [2]: \n" + res);
        num1 = new int[] {1, 2};
        num2 = new int[] {3, 4};
        res = problems._4_findMedianSortedArray(num1, num2);
        System.out.println("Example 2: nums1 = [1,2] | num2 = [3,4]: \n" + res);

        //Problem 5: Longest Palindrome
        System.out.println();
        System.out.println("Problem 5: Longest Palindrome");
        String str = "babad";
        System.out.println("Example 1: str = \"" + str + "\": \n" +
        problems._5_LongestPalindrome(str));
        str = "cbbd";
        System.out.println("Example 2: str = \"" + str + "\": \n" +
                problems._5_LongestPalindrome(str));

        //Problem 6: ZigZag Conversion
        System.out.println();
        System.out.println("Problem 6: ZigZag Conversion");
        str = "PAYPALISHIRING";
        System.out.println("Example 1: str: " + str + " | numRows = 4:\n" +
                problems._6_ZigZagConversion(str, 3));
        str = "PAYPALISHIRING";
        System.out.println("Example 2: str: " + str + " | numRows = 3:\n" +
                problems._6_ZigZagConversion(str, 4));

        //Problem 7: Reverse x
        System.out.println();
        System.out.println("Problem 7: Reverse Integer");
        int x  = -120;
        System.out.println("Example 1: x: " + x + "\n" +problems._7_reverseInteger(x));
        x  = 1534236469;
        System.out.println("Example 2: x: " + x + "\n" +problems._7_reverseInteger(x));

        //Problem 8: String to Integer aka myAtoi
        System.out.println();
        System.out.println("Problem 8: String to Integer aka myAtoi");
        str = "42";
        System.out.println("Example 1: str: " + str + "\n"
                + problems._8_myAtoi(str));
        str = "  -042";
        System.out.println("Example 2: str: " + str + "\n"
                + problems._8_myAtoi(str));
        str = "1234df03";
        System.out.println("Example 3: str: " + str + "\n"
                + problems._8_myAtoi(str));
        str = "+-12";
        System.out.println("Example 4: str: " + str + "\n"
                + problems._8_myAtoi(str));

        //Problem 8: String to Integer (ATOI)

        //Problem 9: isPalindrome
        System.out.println("" + problems._9_isPalindrome(1000021));

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
    public int _1_maxDifference(String s) {
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
    public int[] _2_twoSum(int[] nums, int target) {
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
    public int _3_LongestSubstringWithoutRepeats(String s) {
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

        return max;
    }

    /**
     * <b>Problem 4: Median of Two Sorted Arrays</b>
     * <br><br>
     * Given two sorted arrays {@code nums1} and {@code nums2} of size {@code m} and {@code n} respectively,<br>
     * return the <b>median</b> of the two sorted arrays.
     * <br>
     * The overall run time complexity should be {@code O(log (m+n))}.
     * <br><br>
     * <b>Example 1:</b><br>
     * Input: nums1 = [1,3], nums2 = [2]<br>
     * Output: 2.00000<br>
     * Explanation: merged array = [1,2,3] and median is 2.
     * <br><br>
     * <b>Example 2:</b><br>
     * Input: nums1 = [1,2], nums2 = [3,4]<br>
     * Output: 2.50000<br>
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     * <br><br>
     * <b>Notes:</b><br>
     * On an {@code ODD} list of numbers Median is the middle value so {@code (m + n) / 2}; <br>
     * however to get the index its {@code (m + n + 1) / 2} <br>
     * For an {@code EVEN} list; you need to find the middle value the the value before it and average them.<br>
     * Therefore you repeat parsing thru the arrays {@code ((m + n) / 2) + 1} times and average the last two values
     * <br><br>
     * <b>Complexity Analysis</b><br>
     * m = size of num1 | n = size of num2 <br><br>
     * <b>Time Complexity: </b> <i>O(m+n)</i><br>
     * We get the smallest element by comparing two values at p1 and p2,<br>
     * it takes O(1) to compare two elements and move the corresponding pointer to the right.<br>
     * We need to traverse half of the arrays before reaching the median element(s).<br>
     * <br>
     * <b>Space Complexity:</b> <i>O(1)</i><br>
     * We only maintained 2 variable/pointers.
     *
     */
    public double _4_findMedianSortedArray(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        boolean evenTotal = total % 2 == 0;
        double ret = 0.0;

        int reps;
        if (evenTotal) {
            reps = (total / 2) + 1;
        } else {
            reps = (total + 1) / 2;
        }

        int a = 0, b = 0;
        int curr = 0;
        for (int i = 0; i < reps; i++) {

            if (a < nums1.length && nums1[a] < nums2[b]) {
                curr = nums1[a];
                a++;
            } else {
                curr = nums2[b];
                b++;
            }

            if (evenTotal && i == reps - 2) {
                ret += curr;
            }
        }

        if (evenTotal) {
           return (ret + curr) / 2;
        } else {
            return curr;
        }

    }

    /**
     * <b>Problem 5: Longest Palindromic Substring</b>
     * <br><br>
     * Given a string {@code s}, return the longest palindromic substring in {@code s}.
     * <br><br>
     * <b>Example 1</b><br>
     * Input: s = "babad"<br>
     * Output: "bab"<br>
     * Explanation: "aba" is also a valid answer.
     * <br><br>
     * <b>Example 2</b><br>
     * Input: s = "cbbd"<br>
     * Output: "bb"<br>
     */
    public String _5_LongestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[] {0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = 1 + i;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }

    /**
     * <b>Problem 6: Zigzag Conversion</b>
     * <br><br>
     * Converts the given string into a zigzag pattern based on the specified number of rows,
     * and then reads the characters line by line to produce the final output string.
     *
     * <p>The zigzag pattern writes characters in a down-and-up fashion across the rows. For example,
     * given the input string {@code "PAYPALISHIRING"} and {@code numRows = 3}, the zigzag pattern is:
     *
     * <pre>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * </pre>
     *
     * Reading line by line gives the output: "PAHNAPLSIIGYIR".
     *
     * <p>This method performs that transformation and returns the converted string.
     *
     * <p><b>Example:</b>
     * <pre>
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * </pre>
     * <br>
     * <u><b>Notes</b></u><br>
     * <p>once you see it visually, you realise that you could make a 2d structure to store the chars.
     * For me, I went with a Hashmap that represented the row as a list of chars.<br>
     * So as I iterate through each character in the {@code str}, I'd keep a {@code boolean reverse} and an {@code int key} which represent the column.
     * I'd flip the reverse boolean when key is numRows and when key is 1.
     * Increment or decrement the key depending on the reverse boolean.
     * </p>
     * <br>
     * <u><b>Time and Space Complexity</b></u><br>
     * <i>Time Complexity:</i><br>
     * O(n) to go through str and O(n) to build the return string so <b>Time Complexity: O(n)</b>
     * <br><br>
     * <i>Space Complexity:</i><br>
     * Most about of values stored in the hashmap is n <- length of str<br>
     * hence; <b>Space Complexity: O(n)</b>
     */
    public String _6_ZigZagConversion(String str, int numRows) {
        HashMap<Integer, List<Character>> map = new HashMap<>();
        List<Character> temp;
        boolean reverse = false;
        int key  = 1;

        // TC: O(n) Space: O(n)
        for (int i = 0; i < str.length(); i++) {
            temp = map.get(key);
            if (temp == null)
                temp = new ArrayList<>();
            temp.add(str.charAt(i));
            map.put(key, temp);

            if (key == numRows)
                reverse = true; // reverse the key count
            else if (key == 1)
                reverse = false; // key count going forward

            if (reverse)
                key--;
            else
                key++;

        }

        // TC: O(n)
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
           List<Character> chars = map.get(i + 1);
           for (char c: chars ) {
               ret.append(c);
           }
        }

        return ret.toString();
    }

    /**
     * <b>Problem 7: Reverse Integer</b>\
     * <br><br>
     * <p>Given a signed 32-bit integer {@code x}, return {@code x} with its digits reversed.
     * If reversing {@code x} causes the value to go outside the signed 32-bit integer range [-2 <sup>31</sup>, 2<sup>31</sup> - 1], then return {@code 0}.
     * <br><br>
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     * <br><br>
     * <b><u>Notes</u></b><br>
     * The return value needs to be stored as a long so that the bits don't overflow while assigning the reverse value<br>
     * Storing the value as long will maintain the integrity of the value until the final check for in range is done; giving the correct answer
     * <br><br>
     * <b><u>Time & Space Complexity</u></b><br>
     * <i>Time Complexity:</i> {@code O(log x)} aka number of digits in integer {@code x}<br>
     * <i>Space Complexity:</i> {@code O(1)}
     */
    public int _7_reverseInteger(int x) {
        long ret = 0; // if this is int instead of long
        boolean neg = false;

        if (x < 0) {
            neg = true;
            x = x * -1;
        }

        while (x > 0) {
            ret = (ret * 10) + (x % 10); // then during this calculation the overflow can already happen silently
            x = x / 10;
        }

        if (neg) {
            ret = -ret;
        }

        if (ret < -Math.pow(2,31) || ret > Math.pow(2, 31) - 1) { // so this check fails everytime
            return 0;
        }

        return (int) ret;
    }

    /**
     * <b>Problem 8: String to Integer (atoi)</b>
     * <br><br>
     * Implements the {@code myAtoi(String s)} function that converts a given string into a 32-bit signed integer,
     * following the rules defined by the C/C++ {@code atoi} function.
     * <br><br>
     * <b><u>Algorithm Overview:</u></b><br>
     * <ul>
     *   <li>Ignore leading whitespace characters.</li>
     *   <li>Check for an optional '+' or '-' sign. Default is positive.</li>
     *   <li>Convert consecutive numeric characters into an integer.</li>
     *   <li>Stop parsing upon encountering a non-digit character.</li>
     *   <li>If the number exceeds 32-bit signed integer range [{@code -2^31}, {@code 2^31 - 1}], clamp to the nearest bound.</li>
     * </ul>
     * Parsing stops at the first invalid character after any optional whitespace and sign.
     * <br><br>
     * The value is parsed using a {@code long} to safely detect overflow before casting to {@code int}.
     * The 32-bit integer bounds are calculated via {@code Math.pow()} to avoid hardcoding or using constants.
     * <br><br>
     * <b><u>Examples:</u></b><br>
     * <ul>
     *   <li>{@code myAtoi("42")} → {@code 42}</li>
     *   <li>{@code myAtoi("   -042")} → {@code -42}</li>
     *   <li>{@code myAtoi("1337c0d3")} → {@code 1337}</li>
     *   <li>{@code myAtoi("0-1")} → {@code 0}</li>
     *   <li>{@code myAtoi("words and 987")} → {@code 0}</li>
     *   <li>{@code myAtoi("-91283472332")} → {@code -2147483648} (clamped)</li>
     * </ul>
     * <br>
     * <b><u>Time & Space Complexity:</u></b><br>
     * <i>Time Complexity:</i> {@code O(n)}, where {@code n} is the length of the input string<br>
     * <i>Space Complexity:</i> {@code O(1)} – constant space used for flags and accumulator
     *
     * @param s the input string to be converted to an integer
     * @return the parsed 32-bit signed integer, clamped to the range {@code [-2^31, 2^31 - 1]}
     */
    public int _8_myAtoi(String s) {
        boolean positive = true;
        boolean signAssigned = false;
        boolean digitsStarted = false;
        long ret = 0;

        // Do the math early so it's not done inside the loop
        double INT_MAX = Math.pow(2,31) -1;
        double INT_MIN = -Math.pow(2, 31);

        for (char c: s.toCharArray()) {
            if (c == ' ') {
                if (digitsStarted || signAssigned) break;

            } else
            if (c == '+') {
                if (digitsStarted || signAssigned) break;
                signAssigned = true;
                positive = true;

            } else
            if (c == '-') {
                if (digitsStarted || signAssigned) break;
                signAssigned = true;
                positive = false;

            } else
            if ('0' <= c && c <= '9') {
                digitsStarted = true;
                ret = (ret * 10) + (c - '0');

                //Strings can be too long so got to do the bound checks during conversion or else might overflow
                if (!positive && -ret < INT_MIN) return (int) INT_MIN ;
                if (positive &&   ret > INT_MAX) return (int) INT_MAX ;

            } else {
                break;
            }
        }

        if (!positive) ret = -ret;

        // redundant but better safe than sorry.
        if (ret < INT_MIN) return (int) INT_MIN ;
        if (ret > INT_MAX) return (int) INT_MAX ;

        // Going through the string once so time complexity should be O(n)
        // space complexity = O(1) // since we are just storing a few values

        return (int) ret;
    }

    /**
     * <b>Problem 9: Palindrome Number</b>
     * <br><br>
     * Given an integer {@code x}, return {@code true} if {@code x} is a <i>palindrome</i>, and {@code false} otherwise.
     */
    public boolean _9_isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x !=0 ) return false;

        int reversed = 0;

        while(x > reversed) {
            // Start adding digits from the back to a new value until the halfway point is crossed
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        return x == reversed ||         //even digits
                x == reversed / 10;     //odd digits
    }
}
