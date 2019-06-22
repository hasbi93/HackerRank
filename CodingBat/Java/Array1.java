/*
 * Solutions to all problems at https://codingbat.com/java/Array-1
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Array1 {

/* firstLast6 *****************************************************************/

    /* Given an array of ints, return true if 6 appears as either the first or
     * last element in the array. The array will be length 1 or more. */

    public boolean firstLast6(int[] nums) {
        return (nums[0] == 6 || nums[nums.length - 1] == 6);
    }


/* sameFirstLast **************************************************************/

    /* Given an array of ints, return true if the array is length 1 or more,
     * and the first element and the last element are equal. */

    public boolean sameFirstLast(int[] nums) {
        if (nums.length < 1) {
            return false;
        } else {
            return (nums[0] == nums[nums.length - 1]);
        }
    }


/* makePi *********************************************************************/

    /* Return an int array length 3 containing the first 3 digits of pi,
     * {3, 1, 4}. */

    public int[] makePi() {
        return new int[] {3, 1, 4};
    }


/* commonEnd ******************************************************************/

    /* Given 2 arrays of ints, a and b, return true if they have the same
     * first element or they have the same last element. Both arrays will
     * be length 1 or more. */

    public boolean commonEnd(int[] a, int[] b) {
        return (a[0] == b[0] || a[a.length - 1] == b[b.length - 1]);
    }


/* sum3 ***********************************************************************/

    /* Given an array of ints length 3, return the sum of all the elements. */

    public int sum3(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }


/* rotateLeft3 ****************************************************************/

    /* Given an array of ints length 3, return an array with the elements
     * "rotated left" so {1, 2, 3} yields {2, 3, 1}. */

    /* This method is generalized to rotate any int array any amount. */
    public int[] rotateLeft3(int[] nums) {
        int rotationFactor = 1;
        int[] rotated = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated[i] = nums[(i + rotationFactor) % nums.length];
        }
        return rotated;
    }


/* reverse3 *******************************************************************/

    /* Given an array of ints length 3, return a new array with the elements in
     * reverse order, so {1, 2, 3} becomes {3, 2, 1}. */

    /* This method is generalized to reverse any size of int array. */
    public int[] reverse3(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[nums.length - 1 - i] = nums[i];
        }
        return result;
    }


/* maxEnd3 ********************************************************************/

    /* Given an array of ints length 3, figure out which is larger, the first
     * or last element in the array, and set all the other elements to be that
     * value. Return the changed array. */

    /* This method is generalized to any size of int array. */
    public int[] maxEnd3(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];
        int largerEnd = first > last ? first : last;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = largerEnd;
        }
        return nums;
    }


/* sum2 ***********************************************************************/

    /* Given an array of ints, return the sum of the first 2 elements in the
     * array. If the array length is less than 2, just sum up the elements that
     * exist, returning 0 if the array is length 0. */

    public int sum2(int[] nums) {
        int end = nums.length >= 2 ? 2 : nums.length;
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }


/* middleWay ******************************************************************/

    /* Given 2 int arrays, a and b, each length 3, return a new array length 2
     * containing their middle elements. */

    public int[] middleWay(int[] a, int[] b) {
        int length = 3;
        int middleIndex = length / 2;
        return new int[] { a[middleIndex], b[middleIndex] };
    }


/* makeEnds *******************************************************************/

    /* Given an array of ints, return a new array length 2 containing the first
     * and last elements from the original array. The original array will be
     * length 1 or more. */

    public int[] makeEnds(int[] nums) {
        return new int[] { nums[0], nums[nums.length - 1] };
    }


/* has23 **********************************************************************/

    /* Given an int array length 2, return true if it contains a 2 or a 3. */

    public boolean has23(int[] nums) {
        for (int num : nums) {
            if (num == 2 || num == 3) {
                return true;
            }
        }
        return false;
    }


/* no23 ***********************************************************************/

    /* Given an int array length 2, return true if it does not contain
     * a 2 or 3. */

    public boolean no23(int[] nums) {
        for (int num : nums) {
            if (num == 2 || num == 3) {
                return false;
            }
        }
        return true;
    }


/* makeLast *******************************************************************/

    /* Given an int array, return a new array with double the length where its
     * last element is the same as the original array, and all the other
     * elements are 0. The original array will be length 1 or more. */

    public int[] makeLast(int[] nums) {
        int[] newArray = new int[nums.length * 2];
        newArray[nums.length * 2 - 1] = nums[nums.length - 1];
        return newArray;
    }


/* double23 *******************************************************************/

    /* Given an int array, return true if the array contains 2 twice, or 3
     * twice. The array will be length 0, 1, or 2. */

    /* This method could be generalized in a number of ways, but here, we've
     * just stuck to the very limiting problem definition. */
    public boolean double23(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        return (nums[0] == 2 && nums[1] == 2)
            || (nums[0] == 3 && nums[1] == 3);
    }


/* fix23 **********************************************************************/

    /* Given an int array length 3, if there is a 2 in the array immediately
     * followed by a 3, set the 3 element to 0. Return the changed array. */

    public int[] fix23(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 3) {
                nums[i + 1] = 0;
            }
        }
        return nums;
    }


/* start1 *********************************************************************/

    /* Start with 2 int arrays, a and b, of any length. Return how many of the
     * arrays have 1 as their first element.*/

    /* Returns 1 if `arr` starts with `val, or 0 otherwise. */
    private int startsWith(int[] arr, int val) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] == val ? 1 : 0;
        }
    }

    public int start1(int[] a, int[] b) {
        return startsWith(a, 1) + startsWith(b, 1);
    }


/* biggerTwo ******************************************************************/

    /* Start with 2 int arrays, a and b, each length 2. Consider the sum of
     * the values in each array. Return the array which has the largest sum.
     * In event of a tie, return a. */

    /* Helper method. */
    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public int[] biggerTwo(int[] a, int[] b) {
        return sum(a) >= sum(b) ? a : b;
    }


/* makeMiddle *****************************************************************/

    /* Given an array of ints of even length, return a new array length 2
     * containing the middle two elements from the original array. The original
     * array will be length 2 or more. */

    public int[] makeMiddle(int[] nums) {
        int lowerMiddle = nums.length / 2 - 1;
        int upperMiddle = lowerMiddle + 1;
        return new int[] { nums[lowerMiddle], nums[upperMiddle] };
    }


/* plusTwo ********************************************************************/

    /* Given 2 int arrays, each length 2, return a new array length 4
     * containing all their elements. */

    /* The CodingBat environment complains if you use System.arraycopy()/ */
    public int[] plusTwo(int[] a, int[] b) {
        return new int[] { a[0], a[1], b[0], b[1] };
    }


/* swapEnds *******************************************************************/

    /* Given an array of ints, swap the first and last elements in the array.
     * Return the modified array. The array length will be at least 1. */

    public int[] swapEnds(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;

        return nums;
    }


/* midThree *******************************************************************/

    /* Given an array of ints of odd length, return a new array length 3
     * containing the elements from the middle of the array. The array length
     * will be at least 3. */

    public int[] midThree(int[] nums) {
        int mid = nums.length / 2;
        return new int[] { nums[mid - 1], nums[mid], nums[mid + 1]};
    }


/* maxTriple ******************************************************************/

    /* Given an array of ints of odd length, look at the first, last, and
     * middle values in the array and return the largest. The array length will
     * be a least 1. */

    public int maxTriple(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int middle = nums[nums.length / 2];
        int last = nums[nums.length - 1];
        return Math.max(first, Math.max(middle, last));
    }


/* frontPiece *****************************************************************/

    /* Given an int array of any length, return a new array of its first 2
     * elements. If the array is smaller than length 2, use whatever elements
     * are present. */

    public int[] frontPiece(int[] nums) {
        int frontLength = 2;

        if (nums.length < frontLength) {
            return nums;
        }

        int[] result = new int[frontLength];
        for (int i = 0; i < frontLength; i++) {
            result[i] = nums[i];
        }
        return result;
    }


/* unlucky1 *******************************************************************/

    /* We'll say that a 1 immediately followed by a 3 in an array is an
     * "unlucky" 1. Return true if the given array contains an unlucky 1 in the
     * first 2 or last 2 positions in the array. */

    private boolean isUnlucky(int[] nums, int index) {
        return (nums[index] == 1 && nums[index + 1] == 3);
    }

    public boolean unlucky1(int[] nums) {
        for (int i = 0; i < 2 && i < nums.length - 1; i++) {
            if (isUnlucky(nums, i)) {
                return true;
            }
        }

        for (int i = nums.length - 2; i < nums.length - 1 && i > 0; i++) {
            if (isUnlucky(nums, i)) {
                return true;
            }
        }

        return false;
    }


/* make2 **********************************************************************/

    /* Given 2 int arrays, a and b, return a new array length 2 containing, as
     * much as will fit, the elements from a followed by the elements from b.
     * The arrays may be any length, including 0, but there will be 2 or more
     * elements available between the 2 arrays. */

    public int[] make2(int[] a, int[] b) {
        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < a.length && count < 2; i++, count++) {
            result[count] = a[i];
        }
        for (int j = 0; j < b.length && count < 2; j++, count++) {
            result[count] = b[j];
        }
            return result;
        }


/* front11 ********************************************************************/

    /* Given 2 int arrays, a and b, of any length, return a new array with
     * the first element of each array. If either array is length 0, ignore
     * that array. */

    public int[] front11(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();

        if (a.length > 0) {
            result.add(a[0]);
        }
        if (b.length > 0) {
            result.add(b[0]);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}