/*
 * Solutions to all problems at https://codingbat.com/java/String-3
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class String3 {

/* countYZ ********************************************************************/

    /* Given a string, count the number of words ending in 'y' or 'z' -- so
     * the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in
     * "yellow" (not case sensitive). We'll say that a y or z is at the end of
     * a word if there is not an alphabetic letter immediately following it. */

    public int countYZ(String str) {
        str = str.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if ((currentChar != 'y' && currentChar != 'z')) {
                continue;
            }

            if (i == str.length() - 1
                    || !Character.isLetter(str.charAt(i + 1))) {
                count++;
            }
        }
        return count;
    }


/* withoutString **************************************************************/

    /* Given two strings, base and remove, return a version of the base string
     * where all instances of the remove string have been removed (not case
     * sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx"
     * leaves "x". */

    public String withoutString(String base, String remove) {
        int rLen = remove.length();
        int bLen = base.length();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < bLen) {
            if(!(i + rLen > bLen)
                    && base.substring(i, i + rLen).equalsIgnoreCase(remove)) {
                i += rLen;
                continue;
            }

            result.append(base.charAt(i));
            i++;
        }
        return result.toString();
    }


/* equalIsNot *****************************************************************/

    /* Given a string, return true if the number of appearances of "is"
     * anywhere in the string is equal to the number of appearances of "not"
     * anywhere in the string (case sensitive). */

    public boolean equalIsNot(String str) {
        int countIs = 0;
        int countNot = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith("is", i)) {
                countIs++;
            } else if (str.startsWith("not", i)) {
                countNot++;
            }
        }

        return countIs == countNot;
    }


/* gHappy *********************************************************************/

    /* We'll say that a lowercase 'g' in a string is "happy" if there is
     * another 'g' immediately to its left or right. Return true if all the
     * g's in the given string are happy. */

    public boolean gHappy(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'g') {
                continue;
            }

            if (i > 0 && str.charAt(i - 1) == 'g') {
                continue;
            }

            if (i < str.length() - 1 && str.charAt(i + 1) == 'g') {
                continue;
            }

            return false;
        }

        return true;
    }


/* countTriple ****************************************************************/

    /* We'll say that a "triple" in a string is a char appearing three times in
     * a row. Return the number of triples in the given string. The triples may
     * overlap. */

    public int countTriple(String str) {
        int count = 0;
        for (int i = 2; i < str.length(); i++) {
            char current = str.charAt(i);
            if (str.charAt(i - 2) == current && str.charAt(i - 1) == current) {
                count++;
            }
        }
        return count;
    }


/* sumDigits ******************************************************************/

    /* Given a string, return the sum of the digits 0-9 that appear in the
     * string, ignoring all other characters. Return 0 if there are no digits
     * in the string. */

    public int sumDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return sum;
    }


/* sameEnds *******************************************************************/

    /* Given a string, return the longest substring that appears at
     * both the beginning and end of the string without overlapping.
     * For example, sameEnds("abXab") is "ab". */

    public String sameEnds(String str) {
        int strLen = str.length();
        int middle = (strLen % 2 == 0) ? (strLen / 2) : (strLen / 2 + 1);
        for (int i = middle; i < strLen; i++) {
            String end = str.substring(i);
            if (str.startsWith(end)) {
                return end;
            }
        }
        return "";
    }


/* mirrorEnds *****************************************************************/

    /* Given a string, look for a mirror image (backwards) string at both the
     * beginning and end of the given string. In other words, zero or more
     * characters at the very begining of the given string, and at the very end
     * of the string in reverse order (possibly overlapping). For example, the
     * string "abXYZba" has the mirror end "ab". */

    public String mirrorEnds(String str) {
        int strLen = str.length();
        int i = 0;
        while (i < strLen) {
            if (str.charAt(i) != str.charAt(strLen - i - 1)) {
                break;
            }
            i++;
        }
        return str.substring(0, i);
    }


/* maxBlock *******************************************************************/

    /* Given a string, return the length of the largest "block" in the string.
     * A block is a run of adjacent chars that are the same. */

    public int maxBlock(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int runLength = 1;
        int maxRunLength = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                runLength++;
            } else {
                maxRunLength = Math.max(runLength, maxRunLength);
                runLength = 1;
            }
        }
        maxRunLength = Math.max(runLength, maxRunLength);

        return maxRunLength;
    }


/* sumNumbers *****************************************************************/

    /* Given a string, return the sum of the numbers appearing in the string,
     * ignoring all other characters. A number is a series of 1 or more digit
     * chars in a row. */

    public int sumNumbers(String str) {
        int sum = 0;
        int i = 0;
        while (i < str.length()) {
            // Advance index j to the end of the current number (if any)
            int j = i;
            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                j++;
            }

            // Add the number at indices [i, j), if one exists, to the sum
            if (j > i) {
                sum += Integer.parseInt(str.substring(i, j));
                i = j;
            } else {
                i++;
            }
        }
        return sum;
    }


/* notReplace *****************************************************************/

    /* Given a string, return a string where every appearance of the lowercase
     * word "is" has been replaced with "is not". The word "is" should not be
     * immediately preceeded or followed by a letter -- so for example the "is"
     * in "this" does not count. */

    public String notReplace(String str) {
        StringBuilder result = new StringBuilder();
        int strLen = str.length();

        for (int i = 0; i < strLen; i++){
            if (i > 0 && Character.isLetter(str.charAt(i - 1))
                    || i + 2 < strLen && Character.isLetter(str.charAt(i + 2))) {
                // Previous and/or next character (if any) is a letter
                result.append(str.charAt(i));
            } else if (i < strLen - 1 && str.substring(i, i + 2).equals("is")) {
                result.append("is not");
                i++;
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

}