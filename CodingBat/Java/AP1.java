/*
 * Solutions to all problems at https://codingbat.com/java/AP-1
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class AP1 {

/* scoresIncreasing ***********************************************************/

    /* Given an array of scores, return true if each score is equal or greater
     * than the one before. The array will be length 2 or more. */

    public boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i + 1] < scores[i]) {
                return false;
            }
        }
        return true;
    }


/* scores100 ******************************************************************/

    /* Given an array of scores, return true if there are scores of 100 next to
     * each other in the array. The array length will be at least 2. */

    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100) {
                if (scores[i + 1] == 100) {
                    return true;
                } else {
                    i++; // The next score isn't 100, so skip it
                }
            }
        }
        return false;
    }

/* scoresClump ****************************************************************/

    /* Given an array of scores sorted in increasing order, return true if the
     * array contains 3 adjacent scores that differ from each other by at most
     * 2, such as with {3, 4, 5} or {3, 5, 5}. */

    public boolean scoresClump(int[] scores) {
        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i + 2] - scores[i] <= 2) {
                return true;
            }
        }
        return false;
    }


/* scoresAverage **************************************************************/

    /* Given an array of scores, compute the int average of the first half and
     * the second half, and return whichever is larger. We'll say that the
     * second half begins at index length/2. The array length will be at least
     * 2. To practice decomposition, write a separate helper method int
     * average(int[] scores, int start, int end) { which computes the average
     * of the elements between indexes start..end. Call your helper method
     * twice to implement scoresAverage(). */

    private int average(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += scores[i];
        }
        return sum / (end - start + 1);
    }

    public int scoresAverage(int[] scores) {
        int middle = scores.length / 2;
        int firstHalfAverage = average(scores, 0, middle - 1);
        int secondHalfAverage = average(scores, middle, scores.length - 1);

        return Math.max(firstHalfAverage, secondHalfAverage);
    }


/* wordsCount *****************************************************************/

    /* Given an array of strings, return the count of the number of strings
     * with the given length. */

    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }


/* wordsFront *****************************************************************/

    /* Given an array of strings, return a new array containing the first N
     * strings. N will be in the range 1..length. */

    /* You could, of course, do this with a loop. */
    public String[] wordsFront(String[] words, int n) {
        return Arrays.copyOf(words, n);
    }


/* wordsWithoutList ***********************************************************/

    /* Given an array of strings, return a new List (e.g. an ArrayList) where
     * all the strings of the given length are omitted. See wordsWithout()
     * below which is more difficult because it uses arrays. */

    public List wordsWithoutList(String[] words, int len) {
        List result = new ArrayList();

        for (String word : words) {
            if (word.length() != len) {
                result.add(word);
            }
        }

        return result;
    }


/* hasOne *********************************************************************/

    /* Given a positive int n, return true if it contains a 1 digit. */

    public boolean hasOne(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }


/* dividesSelf ****************************************************************/

    /* We'll say that a positive int divides itself if every digit in the
     * number divides into the number evenly. So for example 128 divides
     * itself since 1, 2, and 8 all divide into 128 evenly. We'll say that 0
     * does not divide into anything evenly, so no number with a 0 digit
     * divides itself. */

    public boolean dividesSelf(int n) {
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }


/* copyEvens ******************************************************************/

    /* Given an array of positive ints, return a new array of length "count"
     * containing the first even numbers from the original array. The original
     * array will contain at least "count" even numbers. */

    public int[] copyEvens(int[] nums, int count) {
        int[] result = new int[count];
        int numAdded = 0;
        for (int i = 0; i < nums.length && numAdded < count; i++) {
            if (nums[i] % 2 == 0) {
                result[numAdded] = nums[i];
                numAdded++;
            }
        }
        return result;
    }


/* copyEndy *******************************************************************/

    /* We'll say that a positive int n is "endy" if it is in the range 0..10
     * or 90..100 (inclusive). Given an array of positive ints, return a new
     * array of length "count" containing the first endy numbers from the
     * original array. Decompose out a separate isEndy(int n) method to test
     * if a number is endy. The original array will contain at least "count"
     * endy numbers. */

    private boolean isEndy(int n) {
        return (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
    }

    public int[] copyEndy(int[] nums, int count) {
        int[] result = new int[count];
        int numAdded = 0;
        for (int i = 0; i < nums.length && numAdded < count; i++) {
            if (isEndy(nums[i])) {
                result[numAdded] = nums[i];
                numAdded++;
            }
        }
        return result;
    }


/* matchUp ********************************************************************/

    /* Given 2 arrays that are the same length containing strings, compare the
     * 1st string in one array to the 1st string in the other array, the 2nd
     * to the 2nd and so on. Count the number of times that the 2 strings are
     * non-empty and start with the same char. The strings may be any length,
     * including 0. */

    public int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 0 && b[i].length() > 0
                    && a[i].charAt(0) == b[i].charAt(0)) {
                count++;
            }
        }
        return count;
    }


/* scoreUp ********************************************************************/

    /* The "key" array is an array containing the correct answers to an exam,
     * like {"a", "a", "b", "b"}. the "answers" array contains a student's
     * answers, with "?" representing a question left blank. The two arrays
     * are not empty and are the same length. Return the score for this array
     * of answers, giving +4 for each correct answer, -1 for each incorrect
     * answer, and +0 for each blank answer. */

    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals(key[i])) {
                score += 4;
            } else if (!answers[i].equals("?")) {
                score -= 1;
            }
        }
        return score;
    }


/* wordsWithout ***************************************************************/

    /* Given an array of strings, return a new array without the strings that
     * are equal to the target string. One approach is to count the
     * occurrences of the target string, make a new array of the correct
     * length, and then copy over the correct strings. */

    /* This solution only loops over the array of strings once, making it
     * somewhat more efficient at the cost of extra space for the ArrayList. */
    public String[] wordsWithout(String[] words, String target) {
        // Stores the indices of the strings to keep in the result
        ArrayList<Integer> keepIndices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target)) {
                keepIndices.add(i);
            }
        }

        String[] result = new String[keepIndices.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = words[keepIndices.get(i)];
        }
        return result;
    }


/* scoresSpecial **************************************************************/

    /* Given two arrays, A and B, of non-negative int scores. A "special"
     * score is one which is a multiple of 10, such as 40 or 90. Return the
     * sum of largest special score in A and the largest special score in B.
     * To practice decomposition, write a separate helper method which finds
     * the largest special score in an array. */

    private int largestSpecialScore(int[] arr) {
        int largest = 0;
        for (int num : arr) {
            if (num % 10 == 0 && num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    public int scoresSpecial(int[] a, int[] b) {
        return largestSpecialScore(a) + largestSpecialScore(b);
    }


/* sumHeights *****************************************************************/

    /* We have an array of heights, representing the altitude along a walking
     * trail. Given start/end indexes into the array, return the sum of the
     * changes for a walk beginning at the start index and ending at the end
     * index. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4
     * yields a sum of 1 + 5 = 6. The start end end index will both be valid
     * indexes into the array with start <= end. */

    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += Math.abs(heights[i] - heights[i + 1]);
        }
        return sum;
    }


/* sumHeights2 ****************************************************************/

    /* We have an array of heights, representing the altitude along a walking
     * trail. Given start/end indexes into the array, return the sum of the
     * changes for a walk beginning at the start index and ending at the end
     * index, however increases in height count double. For example, with the
     * heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7.
     * The start end end index will both be valid indexes into the array with
     * start <= end. */

    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            int diff = Math.abs(heights[i + 1] - heights[i]);
            if (heights[i + 1] > heights[i]) {
                sum += 2 * diff;
            } else {
                sum += diff;
            }
        }
        return sum;
    }


/* bigHeights *****************************************************************/

    /* We have an array of heights, representing the altitude along a walking
     * trail. Given start/end indexes into the array, return the number of
     * "big" steps for a walk starting at the start index and ending at the
     * end index. We'll say that step is big if it is 5 or more up or down.
     * The start end end index will both be valid indexes into the array with
     * start <= end. */

    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i] - heights[i + 1]) >= 5) {
                count++;
            }
        }
        return count;
    }


/* userCompare ****************************************************************/

    /* We have data for two users, A and B, each with a String name and an int
     * id. The goal is to order the users such as for sorting. Return -1 if A
     * comes before B, 1 if A comes after B, and 0 if they are the same. Order
     * first by the string names, and then by the id numbers if the names are
     * the same. */

    public int userCompare(String aName, int aId, String bName, int bId) {
        int nameComp = aName.compareTo(bName);
        if (nameComp < 0) {
            return -1;
        } else if (nameComp > 0) {
            return 1;
        }

        if (aId < bId) {
            return -1;
        } else if (aId > bId) {
            return 1;
        } else {
           return 0;
        }
    }


/* mergeTwo *******************************************************************/

    /* Start with two arrays of strings, A and B, each with its elements in
     * alphabetical order and without duplicates. Return a new array containing
     * the first N elements from the two arrays. The result array should be in
     * alphabetical order and without duplicates. A and B will both have a
     * length which is N or more. The best "linear" solution makes a single
     * pass over A and B, taking advantage of the fact that they are in
     * alphabetical order, copying elements directly to the new array. */

    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] result = new String[n];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < n; i++) {
            int strComp = a[aIndex].compareTo(b[bIndex]);
            if (strComp < 0) {
                result[i] = a[aIndex];
                aIndex++;
            } else if (strComp > 0) {
                result[i] = b[bIndex];
                bIndex++;
            } else {
                result[i] = a[aIndex];
                aIndex++;
                bIndex++;
            }
        }
        return result;
    }


/* commonTwo ******************************************************************/

    /* Start with two arrays of strings, a and b, each in alphabetical order,
     * possibly with duplicates. Return the count of the number of strings
     * which appear in both arrays. The best "linear" solution makes a single
     * pass over both arrays, taking advantage of the fact that they are in
     * alphabetical order. */

    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        Set<String> counted = new HashSet<>(); // Avoid counting duplicates
        int i = 0; // Index into a
        int j = 0; // Index into b
        while (i < a.length && j < b.length) {
            int strComp = a[i].compareTo(b[j]);
            if (strComp == 0) {
                if (!counted.contains(a[i])) {
                    count++;
                    counted.add(a[i]);
                }
                i++;
                j++;
            } else if (strComp < 0) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }

}