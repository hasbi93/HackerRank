import java.util.Arrays;

/*
 * Solutions to all problems at https://codingbat.com/java/Warmup-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Warmup2 {

/* stringTimes ****************************************************************/

    /* Given a string and a non-negative int n, return a larger string that is
     * n copies of the original string. */

    public String stringTimes(String str, int n) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(str);
        }

        return result.toString();
    }


/* frontTimes *****************************************************************/

    /* Given a string and a non-negative int n, we'll say that the front of the
     * string is the first 3 chars, or whatever is there if the string is less
     * than length 3. Return n copies of the front. */

    public String frontTimes(String str, int n) {
        String front;

        if (str.length() < 3) {
            front = str;
        } else {
            front = str.substring(0, 3);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(front);
        }
        return result.toString();
    }


/* countXX ********************************************************************/

    /* Count the number of "xx" in the given string. We'll say that overlapping
     * is allowed, so "xxx" contains 2 "xx". */

    int countXX(String str) {
        if (str.length() < 2) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i <= str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals("xx")) {
                count++;
            }
        }
        return count;
    }


/* doubleX ********************************************************************/

    /* Given a string, return true if the first instance of "x" in the string
     * is immediately followed by another "x". */

    boolean doubleX(String str) {
        if (str.length() < 2) {
            return false;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'x') {
                return (str.charAt(i + 1) == 'x');
            }
        }

        return false;
    }


/* stringBits *****************************************************************/

    /* Given a string, return a new string made of every other char starting
     * with the first, so "Hello" yields "Hlo". */

    public String stringBits(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }


/* stringSplosion *************************************************************/

    /* Given a non-empty string like "Code" return a string like "CCoCodCode" */

    public String stringSplosion(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= str.length(); i++) {
            result.append(str.substring(0, i));
        }
        return result.toString();
    }


/* last2 **********************************************************************/

    /* Given a string, return the count of the number of times that a substring
     * length 2 appears in the string and also as the last 2 chars of the
     * string, so "hixxxhi" yields 1 (we won't count the end substring). */

    public int last2(String str) {
        if (str.length() < 2) {
            return 0;
        }

        String last2 = str.substring(str.length() - 2);

        int count = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals(last2)) {
                count++;
            }
        }

        return count;
    }


/* arrayCount9 ****************************************************************/

    /* Given an array of ints, return the number of 9's in the array. */

    public int arrayCount9(int[] nums) {
        int count = 0;

        for (int i : nums) {
            if (i == 9) {
                count++;
            }
        }

        return count;
    }


/* arrayFront9 ****************************************************************/

    /* Given an array of ints, return true if one of the first 4 elements in
     * the array is a 9. The array length may be less than 4. */

    public boolean arrayFront9(int[] nums) {
        for (int i = 0; i < 4 && i < nums.length; i++) {
            if (nums[i] == 9) {
                return true;
            }
        }
        return false;
    }


/* array123 *******************************************************************/

    /* Given an array of ints, return true if the sequence of numbers 1, 2, 3
     * appears in the array somewhere. */

    // Don't forget to import java.util.Arrays, or use the full name.
    public boolean array123(int[] nums) {
        int[] sequence = new int[] {1, 2, 3};

        if (nums.length < sequence.length) {
            return false;
        }

        for (int i = 0; i <= nums.length - sequence.length; i++) {
            int[] subarray = Arrays.copyOfRange(nums, i, i + sequence.length);

            if (Arrays.equals(subarray, sequence)) {
                return true;
            }
        }

        return false;
    }


/* stringMatch ****************************************************************/

    /* Given 2 strings, a and b, return the number of the positions where they
     * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
     * since the "xx", "aa", and "az" substrings appear in the same place in
     * both strings. */

    public int stringMatch(String a, String b) {

        int substringLength = 2;

        if (a.length() < substringLength || b.length() < substringLength) {
            return 0;
        }

        int count = 0;
        int endIndex = ((a.length() < b.length())
                ? (a.length() - substringLength)
                : (b.length() - substringLength));

        for (int i = 0; i <= endIndex; i++) {
            String aSub = a.substring(i, i + substringLength);
            String bSub = b.substring(i, i + substringLength);

            if (aSub.equals(bSub)) {
                count++;
            }
        }

        return count;
    }


/* stringX ********************************************************************/

    /* Given a string, return a version where all the "x" have been removed.
     * Except an "x" at the very start or end should not be removed. */

    public String stringX(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        }

        StringBuilder result = new StringBuilder();

        result.append(str.charAt(0));
        for (int i = 1; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch != 'x') {
                result.append(ch);
            }
        }
        result.append(str.charAt(str.length() - 1));

        return result.toString();
    }


/* altPairs *******************************************************************/

    /* Given a string, return a string made of the chars at indexes
     * 0,1, 4,5, 8,9 ... so "kittens" yields "kien". */

    public String altPairs(String str) {
        int substringSize = 2;
        int skipSize = 2;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i += skipSize * 2) {
            for (int j = 0; j < substringSize && i + j < str.length(); j++) {
                result.append(str.charAt(i + j));
            }
        }
        return result.toString();
    }


/* stringYak ******************************************************************/

    /* Suppose the string "yak" is unlucky. Given a string, return a version
     * where all the "yak" are removed, but the "a" can be any char. The "yak"
     * strings will not overlap. */

    // Array/string traversals are getting old...let's just use a regex instead
    public String stringYak(String str) {
        return str.replaceAll("y.k", "");
    }


/* array667 *******************************************************************/

    /* Given an array of ints, return the number of times that two 6's are next
     * to each other in the array. Also count instances where the second "6" is
     * actually a 7. */

    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7)) {
                count++;
            }
        }
        return count;
    }


/* noTriples ******************************************************************/

    /* Given an array of ints, we'll say that a triple is a value appearing
     * 3 times in a row in the array. Return true if the array does not contain
     * any triples. */

    public boolean noTriples(int[] nums) {
        if (nums == null || nums.length < 3) {
            return true;
        }

        int previous = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous) {
                count++;
            } else {
                count = 1;
            }

            if (count == 3) {
                return false;
            }

            previous = nums[i];
        }

        return true;
    }


/* has271 *********************************************************************/

    /* Given an array of ints, return true if it contains a 2, 7, 1 pattern:
     * a value, followed by the value plus 5, followed by the value minus 1.
     * Additionally the 271 counts even if the "1" differs by 2 or less from
     * the correct value. */

    public boolean has271(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int second = nums[i + 1];

            if (second == first + 5) {
                int third = nums[i + 2];

                if (Math.abs(third - (first - 1)) <= 2) {
                    return true;
                }
            }
        }

        return false;
    }

}