/*
 * Solutions to all problems at https://codingbat.com/java/Array-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Array2 {

/* countEvens *****************************************************************/

    /* Return the number of even ints in the given array. */

    public int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }


/* bigDiff ********************************************************************/

    /* Given an array length 1 or more of ints, return the difference between
     * the largest and smallest values in the array. */

    public int bigDiff(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return Math.abs(min - max);
    }

/* centeredAverage ************************************************************/

    /* Return the "centered" average of an array of ints, which we'll say is
     * the mean average of the values, except ignoring the largest and
     * smallest values in the array. If there are multiple copies of the
     * smallest value, ignore just one copy, and likewise for the largest
     * value. Use int division to produce the final average. You may assume
     * that the array is length 3 or more. */

    public int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        return (sum - min - max) / (nums.length - 2);
    }


/* sum13 **********************************************************************/

    /* Return the sum of the numbers in the array, returning 0 for an empty
     * array. Except the number 13 is very unlucky, so it does not count and
     * numbers that come immediately after a 13 also do not count. */

    public int sum13(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
            } else {
                sum += nums[i];
            }
        }

        return sum;
    }


/* sum67 **********************************************************************/

    /* Return the sum of the numbers in the array, except ignore sections of
     * numbers starting with a 6 and extending to the next 7 (every 6 will be
     * followed by at least one 7). Return 0 for no numbers. */

    public int sum67(int[] nums) {
        boolean in67 = false; // True if between a 6 and the next 7 (inclusive)
        int sum = 0;

        for (int num : nums) {
            if (in67 && num == 7) {
                in67 = false;
            } else if (num == 6) {
                in67 = true;
            } else if (!in67) {
                sum += num;
            }
        }

        return sum;
    }


/* has22 **********************************************************************/

    /* Given an array of ints, return true if the array contains a 2
     * next to a 2 somewhere. */

    public boolean has22(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }
        }
        return false;
    }


/* lucky13 ********************************************************************/

    /* Given an array of ints, return true if the array contains no 1's
     * and no 3's. */

    public boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }


/* sum28 **********************************************************************/

    /* Given an array of ints, return true if the sum of all the 2's in the
     * array is exactly 8. */

    public boolean sum28(int[] nums) {
        int countTwos = 0;
        for (int num : nums) {
            if (num == 2) {
                countTwos++;
            }
            if (countTwos > 4) {
                return false;
            }
        }
        return countTwos == 4;
    }


/* more14 *********************************************************************/

    /* Given an array of ints, return true if the number of 1's is greater
     * than the number of 4's. */

    public boolean more14(int[] nums) {
        int countOnes = 0;
        int countFours = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            } else if (num == 4) {
                countFours++;
            }
        }
        return countOnes > countFours;
    }


/* fizzArray ******************************************************************/

    /* Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. The given n may be 0, in which case just return a length 0 array. */

    public int[] fizzArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }


/* only14 *********************************************************************/

    /* Given an array of ints, return true if every element is a 1 or a 4. */

    public boolean only14(int[] nums) {
        for (int num : nums) {
            if (num != 1 && num != 4) {
                return false;
            }
        }
        return true;
    }


/* fizzArray2 *****************************************************************/

    /* Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a length 0 array. */

    public String[] fizzArray2(int n) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = String.valueOf(i);
        }
        return result;
    }


/* no14 ***********************************************************************/

    /* Given an array of ints, return true if it contains no 1's or it
     * contains no 4's. */

    public boolean no14(int[] nums) {
        int countOnes = 0;
        int countFours = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            } else if (num == 4) {
                countFours++;
            }
        }
        return countOnes == 0 || countFours == 0;
    }


/* isEverywhere ***************************************************************/

    /* We'll say that a value is "everywhere" in an array if for every pair of
     * adjacent elements in the array, at least one of the pair is that value.
     * Return true if the given value is everywhere in the array. */

    public boolean isEverywhere(int[] nums, int val) {
        // Number of consecutive elements in 'nums' between occurences of 'val'
        int gapSize = 0;

        for (int num : nums) {
            if (num == val) {
                gapSize = 0;
            } else {
                gapSize++;
            }

            if (gapSize > 1) {
                return false;
            }
        }
        return true;
    }


/* either24 *******************************************************************/

    /* Given an array of ints, return true if the array contains a 2 next to a
     * 2 or a 4 next to a 4, but not both. */

    public boolean either24(int[] nums) {
        boolean adjacentTwos = false;
        boolean adjacentFours = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                adjacentTwos = true;
            } else if (nums[i] == 4 && nums[i + 1] == 4) {
                adjacentFours = true;
            }
        }

        return adjacentTwos ^ adjacentFours;
    }


/* matchUp ********************************************************************/

    /* Given arrays nums1 and nums2 of the same length, for every element in
     * nums1, consider the corresponding element in nums2 (at the same index).
     * Return the count of the number of times that the two elements differ by
     * 2 or less, but are not equal. */

    public int matchUp(int[] nums1, int[] nums2) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff <= 2 && diff != 0) {
                count++;
            }
        }
        return count;
    }


/* has77 **********************************************************************/

    /* Given an array of ints, return true if the array contains two 7's next
     * to each other, or there are two 7's separated by one element, such as
     * with {7, 1, 7}. */

    public boolean has77(int[] nums) {
        // Index of the '7' last seen in the array
        int lastSeven = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 7) {
                if (lastSeven != -1 && i - lastSeven <= 2) {
                    return true;
                }
                lastSeven = i;
            }
        }
        return false;
    }


/* has12 **********************************************************************/

    /* Given an array of ints, return true if there is a 1 in the array with a
     * 2 somewhere later in the array. */

    public boolean has12(int[] nums) {
        boolean foundOne = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                foundOne = true;
                continue;
            }

            if (foundOne && nums[i] == 2) {
                return true;
            }
        }
        return false;
    }


/* modThree *******************************************************************/

    /* Given an array of ints, return true if the array contains either 3 even
     * or 3 odd values all next to each other. */

    public boolean modThree(int[] nums) {
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
                oddCount = 0;
            } else {
                oddCount++;
                evenCount = 0;
            }

            if (evenCount == 3 || oddCount == 3) {
                return true;
            }
        }

        return false;
    }


/* haveThree ******************************************************************/

    /* Given an array of ints, return true if the value 3 appears in the array
     * exactly 3 times, and no 3's are next to each other. */

    public boolean haveThree(int[] nums) {
        int countThrees = 0;
        boolean lastThree = false; // True if last element seen was a 3.

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                if (lastThree) {
                    return false; // Adjacent 3's
                }
                countThrees++;
                lastThree = true;
            } else {
                lastThree = false;
            }
        }

        return countThrees == 3;
    }


/* twoTwo *********************************************************************/

    /* Given an array of ints, return true if every 2 that appears in the
     * array is next to another 2. */

    public boolean twoTwo(int[] nums) {
       for (int i = 0; i < nums.length; i++) {
          if (nums[i] != 2) {
             continue;
          }
          if (i > 0 && nums[i - 1] == 2) {
             continue;
          }
          if (i < (nums.length-1) && nums[i + 1] == 2) {
             continue;
          }
          return false;
       }
       return true;
    }


/* sameEnds *******************************************************************/

    /* Return true if the group of N numbers at the start and end of the array
     * are the same. For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are
     * the same for n=0 and n=2, and false for n=1 and n=3. You may assume
     * that n is in the range 0..nums.length inclusive. */

    public boolean sameEnds(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[nums.length - len + i]) {
                return false;
            }
        }
        return true;
    }


/* tripleUp *******************************************************************/

    /* Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25. */

    public boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i + 1] == nums[i] + 1
                    && nums[i + 2] == nums[i] + 2) {
                return true;
            }
        }
        return false;
    }


/* fizzArray3 *****************************************************************/

    /* Given start and end numbers, return a new array containing the sequence
     * of integers from start up to but not including end, so start=5 and
     * end=10 yields {5, 6, 7, 8, 9}. The end number will be greater or equal
     * to the start number. Note that a length-0 array is valid. */

    public int[] fizzArray3(int start, int end) {
        int[] result = new int[end - start];
        for (int i = 0, n = start; n < end; i++, n++) {
            result[i] = n;
        }
        return result;
    }


/* shiftLeft ******************************************************************/

    /* Return an array that is "left shifted" by one -- so {6, 2, 5, 3}
     * returns {2, 5, 3, 6}. You may modify and return the given array, or
     * return a new array. */

    public int[] shiftLeft(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int temp = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = temp;
        return nums;
    }


/* tenRun *********************************************************************/

    /* For each multiple of 10 in the given array, change all the
     * value following it to be that multiple of 10, until
     * encountering another multiple of 10. So {2, 10, 3, 4, 20, 5}
     * yields {2, 10, 10, 10, 20, 20}. */

    public int[] tenRun(int[] nums) {
        int currentMultiple = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                currentMultiple = nums[i];
            } else if (currentMultiple != -1) {
                nums[i] = currentMultiple;
            }
        }
        return nums;
    }


/* pre4 ***********************************************************************/

    /* Given a non-empty array of ints, return a new array containing the
     * elements from the original array that come before the first 4 in the
     * original array. The original array will contain at least one 4. Note
     * that it is valid in java to create an array of length 0. */

    public int[] pre4(int[] nums) {
        // Find the index of the first 4 in the array
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                endIndex = i;
                break;
            }
        }

        // Copy all elements before the index of the first four
        int[] result = new int[endIndex];
        for (int i = 0; i < endIndex; i++) {
            result[i] = nums[i];
        }
        return result;
}


/* post4 **********************************************************************/

    /* Given a non-empty array of ints, return a new array containing the
     * elements from the original array that come after the last 4 in the
     * original array. The original array will contain at least one 4.
     * Note that it is valid in java to create an array of length 0. */

    public int[] post4(int[] nums) {
        int startIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4) {
                startIndex = i + 1;
                break;
            }
        }

        int[] result = new int[nums.length - startIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i + startIndex];
        }
        return result;
    }


/* notAlone *******************************************************************/

    /* We'll say that an element in an array is "alone" if there are values
     * before and after it, and those values are different from it. Return a
     * version of the given array where every instance of the given value
     * which is alone is replaced by whichever value to its left or right is
     * larger. */

    public int[] notAlone(int[] nums, int val) {
        if (nums.length < 3) {
            return nums;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int before = nums[i - 1];
            int after = nums[i + 1];
            if (nums[i] == val && before != val && after != val) {
                nums[i] = Math.max(before, after);
            }
        }

        return nums;
    }


/* zeroFront ******************************************************************/

    /* Return an array that contains the exact same numbers as the given
     * array, but rearranged so that all the zeros are grouped at the start
     * of the array. The order of the non-zero numbers does not matter.
     * So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return
     * the given array or make a new array. */

    public int[] zeroFront(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                nums[right] = nums[left];
                nums[left] = 0;
                left++;
            }
        }
        return nums;
    }


/* withoutTen *****************************************************************/

    /* Return a version of the given array where all the 10's have been
     * removed. The remaining elements should shift left towards the start of
     * the array as needed, and the empty spaces a the end of the array should
     * be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return
     * the given array or make a new array. */

    public int[] withoutTen(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current != 10) {
                result[j] = current;
                j++;
            }
        }
        return result;
    }


/* zeroMax ********************************************************************/

    /* Return a version of the given array where each zero value in the array
     * is replaced by the largest odd value to the right of the zero in the
     * array. If there is no odd value to the right of the zero, leave the
     * zero as a zero. */

    /* This method assumes all non-negative elements in the input array. */
    public int[] zeroMax(int[] nums) {
        int largestOdd = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            if (current % 2 == 1 && current > largestOdd) {
                largestOdd = current;
            } else if (current == 0) {
                nums[i] = largestOdd;
            }
        }
        return nums;
    }


/* evenOdd ********************************************************************/

    /* Return an array that contains the exact same numbers as the given
     * array, but rearranged so that all the even numbers come before all the
     * odd numbers. Other than that, the numbers can be in any order. You may
     * modify and return the given array, or make a new array. */

    public int[] evenOdd(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int current = nums[right];
            if (current % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
        return nums;
    }


/* fizzBuzz *******************************************************************/

    /* This is slightly more difficult version of the famous FizzBuzz problem
     * which is sometimes given as a first problem for job interviews.
     * Consider the series of numbers beginning at start and running up to but
     * not including end, so for example start=1 and end=5 gives the series 1,
     * 2, 3, 4. Return a new String[] array containing the string form of
     * these numbers, except for multiples of 3, use "Fizz" instead of the
     * number, for multiples of 5 use "Buzz", and for multiples of both 3 and
     * 5 use "FizzBuzz". */

    public String[] fizzBuzz(int start, int end) {
        String[] result = new String[end - start];
        for (int n = start, i = 0; n < end; n++, i++) {
            String current = "";
            if (n % 3 == 0) {
                current += "Fizz";
            }
            if (n % 5 == 0) {
                current += "Buzz";
            }
            if (current.equals("")) {
                current += String.valueOf(n);
            }
            result[i] = current;
        }
        return result;
    }

}