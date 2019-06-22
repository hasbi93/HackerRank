/*
 * Solutions to all problems at https://codingbat.com/java/Functional-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Functional2 {

/* noNeg **********************************************************************/

    /* Given a list of integers, return a list of the integers, omitting any
     * that are less than 0. */

    public List<Integer> noNeg(List<Integer> nums) {
        nums.removeIf(n -> n < 0);
        return nums;
    }


/* no9 ************************************************************************/

    /* Given a list of non-negative integers, return a list of those numbers
     * except omitting any that end with 9. (Note: % by 10) */

    public List<Integer> no9(List<Integer> nums) {
        nums.removeIf(n -> n % 10 == 9);
        return nums;
    }


/* noTeen  ********************************************************************/

    /* Given a list of integers, return a list of those numbers, omitting any
     * that are between 13 and 19 inclusive. */

    public List<Integer> noTeen(List<Integer> nums) {
        nums.removeIf(n -> 13 <= n && n <= 19);
        return nums;
    }


/* noZ ************************************************************************/

    /* Given a list of strings, return a list of the strings, omitting any
     * string that contains a "z". (Note: the str.contains(x) method returns a
     * boolean) */

    public List<String> noZ(List<String> strings) {
        strings.removeIf(str -> str.contains("z"));
        return strings;
    }


/* noLong *********************************************************************/

    /* Given a list of strings, return a list of the strings, omitting any
     * string length 4 or more. */

    public List<String> noLong(List<String> strings) {
        strings.removeIf(str -> str.length() >= 4);
        return strings;
    }


/* no34 ***********************************************************************/

    /* Given a list of strings, return a list of the strings, omitting any
     * string length 3 or 4. */

    public List<String> no34(List<String> strings) {
        strings.removeIf(str -> str.length() == 3 || str.length() == 4);
        return strings;
    }


/* noYY ***********************************************************************/

    /* Given a list of strings, return a list where each string has "y" added
     * at its end, omitting any resulting strings that contain "yy" as a
     * substring anywhere. */

    public List<String> noYY(List<String> strings) {
        strings.replaceAll(str -> str + "y");
        strings.removeIf(str -> str.contains("yy"));
        return strings;
    }


/* two2 ***********************************************************************/

    /* Given a list of non-negative integers, return a list of those numbers
     * multiplied by 2, omitting any of the resulting numbers that end in 2. */

    public List<Integer> two2(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        nums.removeIf(n -> n % 10 == 2);
        return nums;
    }


/* square56 *******************************************************************/

    /* Given a list of integers, return a list of those numbers squared and
     * the product added to 10, omitting any of the resulting numbers that end
     * in 5 or 6. */

    public List<Integer> square56(List<Integer> nums) {
        nums.replaceAll(n -> (n * n) + 10);
        nums.removeIf(n -> n % 10 == 5 || n % 10 == 6);
        return nums;
    }

}