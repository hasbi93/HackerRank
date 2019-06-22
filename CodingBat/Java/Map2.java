/*
 * Solutions to all problems at https://codingbat.com/java/Map-2
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Map2 {

/* word0 **********************************************************************/

    /* Given an array of strings, return a Map<String, Integer> containing
     * a key for every different string in the array, always with the value 0.
     * For example the string "hello" makes the pair "hello":0. */

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, 0);
        }
        return map;
    }


/* wordLen ********************************************************************/

    /* Given an array of strings, return a Map<String, Integer> containing a
     * key for every different string in the array, and the value is that
     * string's length. */

    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, str.length());
        }
        return map;
    }


/* pairs **********************************************************************/

    /* Given an array of non-empty strings, create and return a Map<String,
     * String> as follows: for each string add its first character as a key
     * with its last character as the value. */

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(str.substring(0, 1), str.substring(str.length() - 1));
        }
        return map;
    }


/* wordCount ******************************************************************/

    /* The classic word-count algorithm: given an array of strings, return a
     * Map<String, Integer> with a key for each different string, with the
     * value the number of times that string appears in the array. */

    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.merge(str, 1, Integer::sum);
        }
        return map;
    }


/* firstChar ******************************************************************/

    /* Given an array of non-empty strings, return a Map<String, String> with
     * a key for every different first character seen, with the value of all
     * the strings starting with that character appended together in the order
     * they appear in the array. */

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            String firstChar = str.substring(0, 1);
            map.merge(firstChar, str, String::concat);
        }
        return map;
    }


/* wordAppend *****************************************************************/

    /* Loop over the given array of strings to build a result string like
     * this: when a string appears the 2nd, 4th, 6th, etc. time in the array,
     * append the string to the result. Return the empty string if no string
     * appears a 2nd time. */

    public String wordAppend(String[] strings) {
        Map<String, Integer> stringFreqs = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            stringFreqs.merge(str, 1, Integer::sum);
            if (stringFreqs.get(str) % 2 == 0) {
                result.append(str);
            }
        }
        return result.toString();
    }


/* wordMultiple ***************************************************************/

    /* Given an array of strings, return a Map<String, Boolean> where each
     * different string is a key and its value is true if that string appears
     * 2 or more times in the array. */

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.containsKey(str));
        }
        return map;
    }


/* allSwap ********************************************************************/

    /* We'll say that 2 strings "match" if they are non-empty and their first
     * chars are the same. Loop over and then return the given array of
     * non-empty strings as follows: if a string matches an earlier string in
     * the array, swap the 2 strings in the array. When a position in the
     * array has been swapped, it no longer matches anything. Using a map,
     * this can be solved making just one pass over the array. More difficult
     * than it looks. */

    public String[] allSwap(String[] strings) {
        // Maps the first character in a string to the index in the array
        // where the string beginning with that character occurs
        Map<Character, Integer> charIndices = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            Character firstChar = strings[i].charAt(0);

            if (charIndices.containsKey(firstChar)) {
                int matchIndex = charIndices.get(firstChar);
                String temp = strings[matchIndex];
                strings[matchIndex] = strings[i];
                strings[i] = temp;
                charIndices.remove(firstChar);
            } else {
                charIndices.put(firstChar, i);
            }
        }

        return strings;
    }


/* firstSwap ******************************************************************/

    /* We'll say that 2 strings "match" if they are non-empty and their first
     * chars are the same. Loop over and then return the given array of
     * non-empty strings as follows: if a string matches an earlier string in
     * the array, swap the 2 strings in the array. A particular first char can
     * only cause 1 swap, so once a char has caused a swap, its later swaps
     * are disabled. Using a map, this can be solved making just one pass over
     * the array. More difficult than it looks. */

    /* Basically the same as the previous exercise. Alternatively, could
     * maintain a set of characters that have been swapped, instead of encoding
     * that with a special value in the map. */
    public String[] firstSwap(String[] strings) {
        // Maps the first character in a string to the index in the array where
        // the string beginning with that character occurs, or maps to -1 if
        // strings beginning with that character have already been swapped
        Map<Character, Integer> charIndices = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            Character firstChar = strings[i].charAt(0);

            if (charIndices.containsKey(firstChar)) {
                int matchIndex = charIndices.get(firstChar);
                if (matchIndex == -1) {
                    continue; // char has previously been swapped
                }
                String temp = strings[matchIndex];
                strings[matchIndex] = strings[i];
                strings[i] = temp;
                charIndices.put(firstChar, -1); // mark char as previously swapped
            } else {
                charIndices.put(firstChar, i);
            }
        }

        return strings;
    }

}