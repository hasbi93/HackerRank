import java.util.Map;
import java.util.HashMap;

/*
 * Solutions to all problems at https://codingbat.com/java/Logic-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Logic2 {

/* makeBricks *****************************************************************/

    /* We want to make a row of bricks that is goal inches long. We have a
     * number of small bricks (1 inch each) and big bricks (5 inches each).
     * Return true if it is possible to make the goal by choosing from the
     * given bricks. This is a little harder than it looks and can be done
     * without any loops. */

    public boolean makeBricks(int small, int big, int goal) {
        // Enough total inches to make the goal length?
        if (small + big * 5 < goal) {
            return false;
        }

        // Enough small bricks to equal the remainder of
        // the goal length divided by 5?
        return goal % 5 <= small;
    }


/* loneSum ********************************************************************/

    /* Given 3 int values, a b c, return their sum. However, if one of the
     * values is the same as another of the values, it does not count towards
     * the sum. */

    /* This method is generalized to accept an arbitrary number of ints. */
    public int loneSum(int... nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            if (frequencies.containsKey(num)) {
                frequencies.put(num, frequencies.get(num) + 1);
            } else {
                frequencies.put(num, 1);
            }
        }

        int sum = 0;
        for (int num : nums) {
            if (frequencies.get(num) == 1) {
                sum += num;
            }
        }
        return sum;
    }


/* luckySum *******************************************************************/

    /* Given 3 int values, a b c, return their sum. However, if one of the
     * values is 13 then it does not count towards the sum and values to its
     * right do not count. So for example, if b is 13, then both b and c do not
     * count. */

    /* This method is generalized to accept an arbitrary number of ints. */
    public int luckySum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            if (num == 13) {
                break;
            } else {
                sum += num;
            }
        }
        return sum;
    }


/* noTeenSum ******************************************************************/

    /* Given 3 int values, a b c, return their sum. However, if any of the
     * values is a teen -- in the range 13..19 inclusive -- then that value
     * counts as 0, except 15 and 16 do not count as a teens. */

    public int fixTeen(int n) {
        if ((n >= 13 && n <=19) && (n != 15 && n != 16)) {
            return 0;
        } else {
            return n;
        }
    }

    public int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }


/* roundSum *******************************************************************/

    /* For this problem, we'll round an int value up to the next multiple of 10
     * if its rightmost digit is 5 or more, so 15 rounds up to 20. Alternately,
     * round down to the previous multiple of 10 if its rightmost digit is less
     * than 5, so 12 rounds down to 10. Given 3 ints, a b c, return the sum of
     * their rounded values. To avoid code repetition, write a separate helper
     * "public int round10(int num) {" and call it 3 times. Write the helper
     * entirely below and at the same indent level as roundSum().*/

    public int round10(int num) {
        int rem = num % 10;
        if (rem >= 5) {
            return num + 10 - rem;
        } else {
            return num - rem;
        }
    }

    /* This method is generalized to accept an arbitrary number of ints. */
    public int roundSum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += round10(num);
        }
        return sum;
    }


/* closeFar *******************************************************************/

    /* Given three ints, a b c, return true if one of b or c is "close"
     * (differing from a by at most 1), while the other is "far", differing
     * from both other values by 2 or more. */

    /* Returns true if val differs from x by at most 1. */
    private boolean isClose(int val, int x) {
        return Math.abs(val - x) <= 1;
    }

    /* Returns true if val differs from both x and y by at least 2. */
    private boolean isFar(int val, int x, int y) {
        return Math.abs(val - x) >= 2 && Math.abs(val - y) >= 2;
    }

    public boolean closeFar(int a, int b, int c) {
        return (isClose(a, b) && isFar(c, a, b))
            || (isClose(a, c) && isFar(b, a, c));
    }


/* blackjack ******************************************************************/

    /* Given 2 int values greater than 0, return whichever value is nearest to
     * 21 without going over. Return 0 if they both go over. */

    public int blackjack(int a, int b) {
        if (a > 21 && b > 21) {
            return 0;
        } else if (a > 21) {
            return b;
        } else if (b > 21) {
            return a;
        } else {
            return Math.max(a, b);
        }
    }


/* evenlySpaced ***************************************************************/

    /* Given three ints, a b c, one of them is small, one is medium and one is
     * large. Return true if the three values are evenly spaced, so the
     * difference between small and medium is the same as the difference
     * between medium and large. */

    public boolean evenlySpaced(int a, int b, int c) {
        int small = Math.min(a, Math.min(b, c));
        int large = Math.max(a, Math.max(b, c));
        int medium = (a + b + c) - (large + small);

        return ((large - medium) == (medium - small));
    }


/* makeChocolate **************************************************************/

    /* We want make a package of goal kilos of chocolate. We have small bars
     * (1 kilo each) and big bars (5 kilos each). Return the number of small
     * bars to use, assuming we always use big bars before small bars.
     * Return -1 if it can't be done. */

    public int makeChocolate(int small, int big, int goal) {
        int rem = goal % 5;

        /* Not enough total bars to reach 'goal', or not enough small bars */
        if (small + big * 5 < goal || small < rem) {
            return -1;
        }

        /* Enough big bars to reach 'goal - rem', so return 'rem' small bars */
        if (big * 5 >= goal - rem) {
            return rem;
        }

        /* Enough total bars, but have to use more than 'rem' small bars */
        return goal - big * 5;
    }

}