/*
 * Solutions to all problems at https://codingbat.com/java/Array-3
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Array3 {

/* maxSpan ********************************************************************/

    /* Consider the leftmost and righmost appearances of some value in an
     * array. We'll say that the "span" is the number of elements between the
     * two inclusive. A single value has a span of 1. Returns the largest span
     * found in the given array. (Efficiency is not a priority.) */

    /* This could also be done less efficiently with two for loops. */
    public int maxSpan(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // Maps distinct elements in nums to the first index they occur at
        Map<Integer, Integer> firstIndex = new HashMap<>();

        int maxSpan = 1;
        for (int i = 0; i < nums.length; i++) {
            if (firstIndex.containsKey(nums[i])) {
                int span = i - firstIndex.get(nums[i]) + 1;
                if (span > maxSpan) {
                    maxSpan = span;
                }
            } else {
                firstIndex.put(nums[i], i);
            }
        }
        return maxSpan;
    }


/* fix34 **********************************************************************/

    /* Return an array that contains exactly the same numbers as the given
     * array, but rearranged so that every 3 is immediately followed by a 4. Do
     * not move the 3's, but every other number may move. The array contains
     * the same number of 3's and 4's, every 3 has a number after it that is
     * not a 3, and a 3 appears in the array before any 4. */

    public int[] fix34(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = 4;
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[j] == 4) nums[j] = temp;
                }
            }
        }
        return nums;
    }


/* fix45 **********************************************************************/

    /* (This is a slightly harder version of the fix34 problem.) Return an
     * array that contains exactly the same numbers as the given array, but
     * rearranged so that every 4 is immediately followed by a 5. Do not move
     * the 4's, but every other number may move. The array contains the same
     * number of 4's and 5's, and every 4 has a number after it that is not a
     * 4. In this version, 5's may appear anywhere in the original array. */

    public int[] fix45(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4 && nums[i + 1] != 5) {
                while (nums[j] != 5 || (j > 0 && nums[j - 1] == 4)) {
                    j++;
                }
                nums[j] = nums[i + 1];
                nums[i + 1] = 5;
            }
        }
        return nums;
    }


/* canBalance *****************************************************************/

    /* Given a non-empty array, return true if there is a place to split the
     * array so that the sum of the numbers on one side is equal to the sum of
     * the numbers on the other side. */

    public boolean canBalance(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int j = 0; j < nums.length; j++) {
            leftSum += nums[j];
            rightSum -= nums[j];

            if (leftSum == rightSum) {
                return true;
            }
        }

        return false;
    }


/* linearIn *******************************************************************/

    /* Given two arrays of ints sorted in increasing order, outer and inner,
     * return true if all of the numbers in inner appear in outer. The best
     * solution makes only a single "linear" pass of both arrays, taking
     * advantage of the fact that both arrays are already in sorted order. */

    public boolean linearIn(int[] outer, int[] inner) {
        if (inner.length == 0) {
            return true;
        }

        int j = 0;
        for (int i = 0; i < outer.length; i++) {
            if (outer[i] == inner[j]) {
                j++;
            } else if (outer[i] > inner[j]) {
                return false;
            }

            if (j == inner.length) {
                return true;
            }
        }
        return false;
    }


/* squareUp *******************************************************************/

    /* Given n>=0, create an array length n*n with the following pattern, shown
     * here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show
     * the 3 groups). */

    public int[] squareUp(int n) {
        int[] result = new int[n * n];

        if (n == 0) {
            return result;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int index = r * n + c;
                if (r + c < n - 1) {
                    result[index] = 0;
                } else {
                    result[index] = n - c;
                }
            }
        }

        return result;
    }


/* seriesUp *******************************************************************/

    /* Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,
     * ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the
     * length of the array will be 1 + 2 + 3 ... + n, which is known to sum to
     * exactly n*(n + 1)/2. */

    public int[] seriesUp(int n) {
        int length = n * (n + 1) / 2;
        int[] result = new int[length];

        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[index++] = j;
            }
        }

        return result;
    }


/* maxMirror ******************************************************************/

    /* We'll say that a "mirror" section in an array is a group of contiguous
     * elements such that somewhere in the array, the same group appears in
     * reverse order. For example, the largest mirror section in {1, 2, 3, 8,
     * 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the
     * largest mirror section found in the given array. */

    public int maxMirror(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = nums.length - 1;
                    j >= 0 && i + count < nums.length; j--) {
                if (nums[i + count] == nums[j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }


/* countClumps ****************************************************************/

    /* Say that a "clump" in an array is a series of 2 or more adjacent
     * elements of the same value. Return the number of clumps in the
     * given array. */

    public int countClumps(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int clumpCount = 0;
        int currClumpSize = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currClumpSize++;
            } else {
                if (currClumpSize >= 2) {
                    clumpCount++;
                }
                currClumpSize = 1;
            }
        }

        return (currClumpSize >= 2) ? (clumpCount + 1) : (clumpCount);
    }

}