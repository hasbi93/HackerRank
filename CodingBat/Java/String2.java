/*
 * Solutions to all problems at https://codingbat.com/java/String-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class String2 {

/* doubleChar *****************************************************************/

    /* Given a string, return a string where for every char in the original,
     * there are two chars. */

    public String doubleChar(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            result.append(c);
            result.append(c);
        }

        return result.toString();
    }


/* countHi ********************************************************************/

    /* Return the number of times that the string "hi" appears anywhere in the
     * given string. */

    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i <= str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                count++;
            }
        }
        return count;
    }


/* catDog *********************************************************************/

    /* Return true if the string "cat" and "dog" appear the same number of
     * times in the given string. */

    public boolean catDog(String str) {
        int catCount = 0;
        int dogCount = 0;

        for (int i = 0; i <= str.length() - 3; i++) {
            String substring = str.substring(i, i + 3);

            if (substring.equals("cat")) {
                catCount++;
            } else if (substring.equals("dog")) {
                dogCount++;
            }
        }
        return (catCount == dogCount);
    }


/* countCode ******************************************************************/

    /* Return the number of times that the string "code" appears anywhere in
     * the given string, except we'll accept any letter for the 'd', so "cope"
     * and "cooe" count. */

    /* String.matches(), which uses a regex, is easier and more efficient than
     * String.substring() and String.equals() for this problem, especially
     * given the "accept any letter for the 'd'" condition. */
    public int countCode(String str) {
        String pattern = "co.e";
        int patternLength = pattern.length();

        int count = 0;
        for (int i = 0; i <= str.length() - patternLength; i++) {
            if (str.substring(i, i + patternLength).matches(pattern)) {
               count++;
            }
        }
        return count;
    }


/* endOther *******************************************************************/

    /* Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences (in
     * other words, the computation should not be "case sensitive"). Note:
     * str.toLowerCase() returns the lowercase version of a string. */

    public boolean endOther(String a, String b) {
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();
        return (aLower.endsWith(bLower) || bLower.endsWith(aLower));
    }


/* xyzThere *******************************************************************/

    /* Return true if the given string contains an appearance of "xyz" where
     * the xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not. */

    public boolean xyzThere(String str) {
        if (str.startsWith("xyz")) {
            return true;
        }

        for (int i = 1; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("xyz") && str.charAt(i - 1) != '.') {
                return true;
            }
        }

        return false;
    }


/* bobThere *******************************************************************/

    /* Return true if the given string contains a "bob" string, but where the
     * middle 'o' char can be any char. */

    public boolean bobThere(String str) {
        return str.matches(".*b.b.*");
    }


/* xyBalance ******************************************************************/

    /* We'll say that a String is xy-balanced if for all the 'x' chars in the
     * string, there exists a 'y' char somewhere later in the string. So "xxy"
     * is balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
     * Return true if the given string is xy-balanced. */

    public boolean xyBalance(String str) {
        int lastX = str.lastIndexOf('x');

        if (lastX == -1) {
            return true;
        }

        return str.substring(lastX).contains("y");
    }


/* mixString ******************************************************************/

    /* Given two strings, a and b, create a bigger string made of the first
     * char of a, the first char of b, the second char of a, the second char
     * of b, and so on. Any leftover chars go at the end of the result. */

    public String mixString(String a, String b) {
        StringBuilder result = new StringBuilder(a.length() + b.length());

        int i;

        for (i = 0; i < a.length() && i < b.length(); i++) {
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }

        if (i < a.length()) {
            result.append(a.substring(i));
        } else if (i < b.length()) {
            result.append(b.substring(i));
        }

        return result.toString();
    }


/* repeatEnd ******************************************************************/

    /* Given a string and an int n, return a string made of n repetitions of
     * the last n characters of the string. You may assume that n is between 0
     * and the length of the string, inclusive. */

    public String repeatEnd(String str, int n) {
        String end = str.substring(str.length() - n);
        StringBuilder endRepeated = new StringBuilder();
        for (int i = 0; i < n; i++) {
            endRepeated.append(end);
        }
        return endRepeated.toString();
    }


/* repeatFront ****************************************************************/

    /* Given a string and an int n, return a string made of the first n
     * characters of the string, followed by the first n-1 characters of the
     * string, and so on. You may assume that n is between 0 and the length of
     * the string, inclusive (i.e. n >= 0 and n <= str.length()). */

    public String repeatFront(String str, int n) {
        StringBuilder front = new StringBuilder(str.substring(0, n));
        StringBuilder repeatedFront = new StringBuilder(front);

        for (int i = n - 1; i > 0; i--) {
            front.deleteCharAt(i);
            repeatedFront.append(front);
        }

        return repeatedFront.toString();
    }


/* repeatSeparator ************************************************************/

    /* Given two strings, word and a separator sep, return a big string made
     * of count occurrences of the word, separated by the separator string. */

    public String repeatSeparator(String word, String sep, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(word);
            if (i != count - 1) {
                repeated.append(sep);
            }
        }
        return repeated.toString();
    }


/* prefixAgain ****************************************************************/

    /* Given a string, consider the prefix string made of the first N chars of
     * the string. Does that prefix string appear somewhere else in the
     * string? Assume that the string is not empty and that N is in the range
     * 1..str.length(). */

    public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        return str.substring(n).contains(prefix);
    }


/* xyzMiddle ******************************************************************/

    /* Given a string, does "xyz" appear in the middle of the string? To
     * define middle, we'll say that the number of chars to the left and right
     * of the "xyz" must differ by at most one. This problem is harder than it
     * looks. */

    public boolean xyzMiddle(String str) {
        if (str.length() < 3) {
            return false;
        }

        int mid = str.length() / 2;

        // If string length is odd, 'xyz' must appear in the exact middle
        if (str.length() % 2 == 1) {
            return str.substring(mid - 1, mid + 2).equals("xyz");
        }

        // If string length is even, 'xyz' must appear in the middle 4 characters
        return str.substring(mid - 2, mid + 2).contains("xyz");
    }


/* getSandwich ****************************************************************/

    /* A sandwich is two pieces of bread with something in between. Return the
     * string that is between the first and last appearance of "bread" in the
     * given string, or return the empty string "" if there are not two pieces
     * of bread. */

    public String getSandwich(String str) {
        int start = str.indexOf("bread") + "bread".length();
        int end = str.lastIndexOf("bread") - 1;
        if (start <= end) {
            return str.substring(start, end + 1);
        } else {
            return "";
        }
    }


/* sameStarChar ***************************************************************/

    /* Returns true if for every '*' (star) in the string, if there are chars
     * both immediately before and after the star, they are the same. */

    public boolean sameStarChar(String str) {
        int starIndex = str.indexOf("*");
        while (starIndex != -1) {
            if (starIndex > 0 && starIndex < str.length() - 1
                    && str.charAt(starIndex - 1) != str.charAt(starIndex + 1)) {
                return false;
            }
            starIndex = str.indexOf("*", starIndex + 1);
        }
        return true;
    }


/* oneTwo *********************************************************************/

    /* Given a string, compute a new string by moving the first char to come
     * after the next two chars, so "abc" yields "bca". Repeat this process
     * for each subsequent group of 3 chars, so "abcdef" yields "bcaefd".
     * Ignore any group of fewer than 3 chars at the end. */

    public String oneTwo(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 2; i += 3) {
            result.append(str.substring(i + 1, i + 3));
            result.append(str.charAt(i));
        }
        return result.toString();
    }


/* zipZap *********************************************************************/

    /* Look for patterns like "zip" and "zap" in the string -- length-3,
     * starting with 'z' and ending with 'p'. Return a string where for all
     * such words, the middle letter is gone, so "zipXzap" yields "zpXzp". */

    public String zipZap(String str) {
        StringBuilder result = new StringBuilder(str);
        for (int i = 0; i < result.length() - 2; i++) {
            if (result.charAt(i) == 'z' && result.charAt(i + 2) == 'p') {
                result.deleteCharAt(i + 1);
                i++;
            }
        }
        return result.toString();
    }


/* starOut ********************************************************************/

    /* Return a version of the given string, where for every star (*) in the
     * string the star and the chars immediately to its left and right are
     * gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad". */

    public String starOut(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                continue;
            }
            if (i > 0 && str.charAt(i - 1) == '*') {
                continue;
            }
            if (i < str.length() - 1 && str.charAt(i + 1) == '*') {
                continue;
            }

            result.append(str.charAt(i));
        }

        return result.toString();
    }


/* plusOut ********************************************************************/

    /* Given a string and a non-empty word string, return a version of
     * the original String where all chars have been replaced by pluses
     * ("+"), except for appearances of the word string which are
     * preserved unchanged. */

    public String plusOut(String str, String word) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            if (str.startsWith(word, i)) {
                result.append(word);
                i += word.length();
            } else {
                result.append('+');
                i += 1;
            }
        }
        return result.toString();
    }


/* wordEnds *******************************************************************/

    /* Given a string and a non-empty word string, return a string made of
     * each char just before and just after every appearance of the word in
     * the string. Ignore cases where there is no char before or after the
     * word, and a char may be included twice if it is between two words. */

    public String wordEnds(String str, String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= str.length() - word.length(); i++) {
            String substring = str.substring(i, i + word.length());
            if (substring.equals(word)) {
                if (i > 0) {
                    result.append(str.charAt(i - 1));
                }
                if (i < str.length() - word.length()) {
                    result.append(str.charAt(i + word.length()));
                }
            }
        }
        return result.toString();
    }

}