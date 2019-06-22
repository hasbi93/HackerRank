/*
 * Solutions to all problems at https://codingbat.com/java/Recursion-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Recursion2 {

/* groupSum *******************************************************************/

    /* Given an array of ints, is it possible to choose a group of some of the
    * ints, such that the group sums to the given target? This is a classic
    * backtracking recursion problem. Once you understand the recursive
    * backtracking strategy in this problem, you can use the same pattern for
    * many problems to search a space of choices. Rather than looking at the
    * whole array, our convention is to consider the part of the array
    * starting at index start and continuing to the end of the array. The
    * caller can specify the whole array simply by passing start as 0. No
    * loops are needed -- the recursive calls progress down the array. */

    public boolean groupSum(int start, int[] nums, int target) {
        if (target == 0) {
            return true;
        }

        if (start >= nums.length) {
            return false;
        }

        return groupSum(start + 1, nums, target - nums[start])
            || groupSum(start + 1, nums, target);
    }


/* groupSum6 ******************************************************************/

    /* Given an array of ints, is it possible to choose a group of some of the
     * ints, beginning at the start index, such that the group sums to the
     * given target? However, with the additional constraint that all 6's must
     * be chosen. (No loops needed.) */

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        if (nums[start] == 6) {
            return groupSum6(start + 1, nums, target - 6);
        } else {
            return groupSum6(start + 1, nums, target - nums[start])
                || groupSum6(start + 1, nums, target);
        }
    }


/* groupNoAdj *****************************************************************/

    /* Given an array of ints, is it possible to choose a group of some of the
     * ints, such that the group sums to the given target with this additional
     * constraint: If a value in the array is chosen to be in the group, the
     * value immediately following it in the array must not be chosen. (No
     * loops needed.) */

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        return groupNoAdj(start + 2, nums, target - nums[start])
            || groupNoAdj(start + 1, nums, target);
    }


/* groupSum5 ******************************************************************/

    /* Given an array of ints, is it possible to choose a group of some of the
     * ints, such that the group sums to the given target with these
     * additional constraints: all multiples of 5 in the array must be
     * included in the group. If the value immediately following a multiple of
     * 5 is 1, it must not be chosen. (No loops needed.) */

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        if (nums[start] % 5 == 0) {
            int jump = 1; // 2 if the next element must be skipped; 1 if not
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                jump = 2;
            }
            return groupSum5(start + jump, nums, target - nums[start]);
        } else {
            return groupSum5(start + 1, nums, target - nums[start])
                || groupSum5(start + 1, nums, target);
        }
    }


/* groupSumClump **************************************************************/

    /* Given an array of ints, is it possible to choose a group of some of the
     * ints, such that the group sums to the given target, with this
     * additional constraint: if there are numbers in the array that are
     * adjacent and the identical value, they must either all be chosen, or
     * none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2},
     * either all three 2's in the middle must be chosen or not, all as a
     * group. (one loop can be used to find the extent of the identical
     * values). */

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        int jump = 1;
        while (start + jump < nums.length
                && nums[start + jump] == nums[start]) {
            jump++;
        }

        return groupSumClump(start + jump, nums, target - nums[start] * jump)
            || groupSumClump(start + jump, nums, target);
    }


/* splitArray *****************************************************************/

    /* Given an array of ints, is it possible to divide the ints into two
     * groups, so that the sums of the two groups are the same. Every int must
     * be in one group or the other. Write a recursive helper method that
     * takes whatever arguments you like, and make the initial call to your
     * recursive helper from splitArray(). (No loops needed.) */

    private boolean splitArrayRecursive(int index, int[] nums,
            int sum1, int sum2) {
        if (index == nums.length) {
            return sum1 == sum2;
        }

        return splitArrayRecursive(index + 1, nums, sum1 + nums[index], sum2)
            || splitArrayRecursive(index + 1, nums, sum1, sum2 + nums[index]);
    }

    public boolean splitArray(int[] nums) {
        return splitArrayRecursive(0, nums, 0, 0);
    }


/* splitOdd10 *****************************************************************/

    /* Given an array of ints, is it possible to divide the ints into two
     * groups, so that the sum of one group is a multiple of 10, and the sum
     * of the other group is odd. Every int must be in one group or the other.
     * Write a recursive helper method that takes whatever arguments you like,
     * and make the initial call to your recursive helper from splitOdd10().
     * (No loops needed.) */

    private boolean splitOdd10Recursive(int index, int[] nums,
            int sum1, int sum2) {
        if (index == nums.length) {
            return sum1 % 10 == 0 && sum2 % 2 == 1
                || sum2 % 10 == 0 && sum1 % 2 == 1;
        }

        return splitOdd10Recursive(index + 1, nums, sum1 + nums[index], sum2)
            || splitOdd10Recursive(index + 1, nums, sum1, sum2 + nums[index]);
    }

    public boolean splitOdd10(int[] nums) {
        return splitOdd10Recursive(0, nums, 0, 0);
    }


/* split53 ********************************************************************/

    /* Given an array of ints, is it possible to divide the ints into two
     * groups, so that the sum of the two groups is the same, with these
     * constraints: all the values that are multiple of 5 must be in one
     * group, and all the values that are a multiple of 3 (and not a multiple
     * of 5) must be in the other. (No loops needed.) */

    /* If num[index] is a multiple of 5, it is added to mult5; if num[index] is
     * a multiple of 3 (and not of 5), it is added to mult3; otherwise, it is
     * added to each of mult5 and mult3, in separate recursive calls. */
    private boolean split53Recursive(int index, int[] nums,
            int mult5, int mult3) {
        if (index == nums.length) {
            return mult5 == mult3;
        }

        if (nums[index] % 5 == 0) {
            return split53Recursive(index + 1, nums,
                mult5 + nums[index], mult3);
        } else if (nums[index] % 3 == 0) {
            return split53Recursive(index + 1, nums,
                mult5, mult3 + nums[index]);
        } else {
            return (split53Recursive(index + 1, nums,
                    mult5 + nums[index], mult3))
                || (split53Recursive(index + 1, nums,
                    mult5, mult3 + nums[index]));
        }
    }

    public boolean split53(int[] nums) {
        return split53Recursive(0, nums, 0, 0);
    }

}