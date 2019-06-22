/*
 * Solutions to all problems at https://codingbat.com/java/Functional-1
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Functional1 {

/* doubling *******************************************************************/

    /* Given a list of integers, return a list where each integer is
     * multiplied by 2. */

    public List<Integer> doubling(List<Integer> nums) {
        nums.replaceAll(n -> n * 2);
        return nums;
    }


/* square *********************************************************************/

    /* Given a list of integers, return a list where each integer is
     * multiplied with itself. */

    public List<Integer> square(List<Integer> nums) {
        nums.replaceAll(n -> n * n);
        return nums;
    }


/* addStar ********************************************************************/

    /* Given a list of strings, return a list where each string has "*" added
     * at its end. */

    public List<String> addStar(List<String> strings) {
        strings.replaceAll(str -> str + "*");
        return strings;
    }


/* copies3 ********************************************************************/

    /* Given a list of strings, return a list where each string is replaced by
     * 3 copies of the string concatenated together. */

    public List<String> copies3(List<String> strings) {
        strings.replaceAll(str -> str + str + str);
        return strings;
    }


/* moreY **********************************************************************/

    /* Given a list of strings, return a list where each string has "y" added
     * at its start and end. */

    public List<String> moreY(List<String> strings) {
        strings.replaceAll(str -> "y" + str + "y");
        return strings;
    }


/* math1 **********************************************************************/

    /* Given a list of integers, return a list where each integer is added to
     * 1 and the result is multiplied by 10. */

    public List<Integer> math1(List<Integer> nums) {
        nums.replaceAll(n -> (n + 1) * 10);
        return nums;
    }


/* rightDigit *****************************************************************/

    /* Given a list of non-negative integers, return an integer list of the
     * rightmost digits. (Note: use %) */

    public List<Integer> rightDigit(List<Integer> nums) {
        nums.replaceAll(n -> n % 10);
        return nums;
    }


/* lower **********************************************************************/

    /* Given a list of strings, return a list where each string is converted
     * to lower case (Note: String toLowerCase() method). */

    public List<String> lower(List<String> strings) {
        strings.replaceAll(String::toLowerCase);
        return strings;
    }


/* noX ************************************************************************/

    /* Given a list of strings, return a list where each string has all its "x" removed. */

    public List<String> noX(List<String> strings) {
        strings.replaceAll(str -> str.replaceAll("x", ""));
        return strings;
    }

}