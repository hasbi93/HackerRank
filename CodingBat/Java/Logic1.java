/*
 * Solutions to all problems at https://codingbat.com/java/Logic-1
 *
 * This class generally contains one method per exercise; however, some may
 * have helper methods as appropriate.
 */

class Logic1 {

/* cigarParty *****************************************************************/

    /* When squirrels get together for a party, they like to have cigars. A
     * squirrel party is successful when the number of cigars is between 40
     * and 60, inclusive. Unless it is the weekend, in which case there is no
     * upper bound on the number of cigars. Return true if the party with the
     * given values is successful, or false otherwise. */

    public boolean cigarParty(int cigars, boolean isWeekend) {
        return (isWeekend && cigars >= 40) || (cigars >= 40 && cigars <= 60);
    }


/* dateFashion ****************************************************************/

    /* You and your date are trying to get a table at a restaurant. The
     * parameter "you" is the stylishness of your clothes, in the range 0..10,
     * and "date" is the stylishness of your date's clothes. The result getting
     * the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If
     * either of you is very stylish, 8 or more, then the result is 2 (yes).
     * With the exception that if either of you has style of 2 or less, then
     * the result is 0 (no). Otherwise the result is 1 (maybe). */

    public int dateFashion(int you, int date) {
        if (you <= 2 || date <= 2) {
            return 0;
        } else if (you < 8 && date < 8) {
            return 1;
        } else {
            return 2;
        }
    }


/* squirrelPlay ***************************************************************/

    /* The squirrels in Palo Alto spend most of the day playing. In particular,
     * they play if the temperature is between 60 and 90 (inclusive). Unless it
     * is summer, then the upper limit is 100 instead of 90. Given an int
     * temperature and a boolean isSummer, return true if the squirrels play
     * and false otherwise. */

    public boolean squirrelPlay(int temp, boolean isSummer) {
        return (temp >= 60) && (temp <= 90 || isSummer && temp <= 100);
    }


/* caughtSpeeding *************************************************************/

    /* You are driving a little too fast, and a police officer stops you. Write
     * code to compute the result, encoded as an int value: 0=no ticket,
     * 1=small ticket, 2=big ticket. If speed is 60 or less, the result is 0.
     * If speed is between 61 and 80 inclusive, the result is 1. If speed is 81
     * or more, the result is 2. Unless it is your birthday -- on that day,
     * your speed can be 5 higher in all cases. */

    public int caughtSpeeding(int speed, boolean isBirthday) {
        int bonus = isBirthday ? 5 : 0;
        int noTicketMax = 60 + bonus;
        int smallTicketMax = 80 + bonus;

        if (speed <= noTicketMax) {
            return 0;
        } else if (speed <= smallTicketMax) {
            return 1;
        } else {
            return 2;
        }
    }


/* sortaSum *******************************************************************/

    /* Given 2 ints, a and b, return their sum. However, sums in the range
     * 10..19 inclusive, are forbidden, so in that case just return 20. */

    public int sortaSum(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 19) {
            return 20;
        } else {
            return sum;
        }
    }


/* alarmClock *****************************************************************/

    /* Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a
     * boolean indicating if we are on vacation, return a string of the form
     * "7:00" indicating when the alarm clock should ring. Weekdays, the alarm
     * should be "7:00" and on the weekend it should be "10:00". Unless we are
     * on vacation -- then on weekdays it should be "10:00" and weekends it
     * should be "off". */

    public String alarmClock(int day, boolean vacation) {
        if (day == 0 || day == 6) {
            return (vacation ? "off" : "10:00");
        } else {
            return (vacation ? "10:00" : "7:00");
        }
    }


/* love6 **********************************************************************/

    /* The number 6 is a truly great number. Given two int values, a and b,
     * return true if either one is 6. Or if their sum or difference is 6. */

    public boolean love6(int a, int b) {
        return (a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6);
    }


/* in1To10 ********************************************************************/

    /* Given a number n, return true if n is in the range 1..10, inclusive.
     * Unless outsideMode is true, in which case return true if the number is
     * less or equal to 1, or greater or equal to 10. */

    public boolean in1To10(int n, boolean outsideMode) {
        return (outsideMode ? (n <= 1 || n >= 10)
                            : (n >= 1 && n <= 10));
    }


/* specialEleven **************************************************************/

    /* We'll say a number is special if it is a multiple of 11 or if it is one
     * more than a multiple of 11. Return true if the given non-negative number
     * is special. */

    public boolean specialEleven(int n) {
        int remainder = n % 11;
        return (remainder <= 1);
    }


/* more20 *********************************************************************/

    /* Return true if the given non-negative number is 1 or 2 more than a
     * multiple of 20. See also: Introduction to Mod */

    public boolean more20(int n) {
        int remainder = n % 20;
        return (remainder == 1 || remainder == 2);
    }


/* old35 **********************************************************************/

    /* Return true if the given non-negative number is a multiple of 3 or 5,
     * but not both. */

    public boolean old35(int n) {
        return (n % 3 == 0) ^ (n % 5 == 0);
    }


/* less20 *********************************************************************/

    /* Return true if the given non-negative number is 1 or 2 less than a
     * multiple of 20. So for example 38 and 39 return true, but 40 returns
     * false. */

    public boolean less20(int n) {
        int remainder = n % 20;
        return remainder >= 18;
    }


/* nearTen ********************************************************************/

    /* Given a non-negative number "num", return true if num is within 2 of a
     * multiple of 10.  */

    public boolean nearTen(int num) {
        return num % 10 <= 2 || num % 10 >= 8;
    }


/* teenSum ********************************************************************/

    /* Given 2 ints, a and b, return their sum. However, "teen" values in the
     * range 13..19 inclusive, are extra lucky. So if either value is a teen,
     * just return 19. */

    private boolean isTeen(int n) {
        return n >= 13 && n <= 19;
    }

    public int teenSum(int a, int b) {
        if (isTeen(a) || isTeen(b)) {
            return 19;
        } else {
            return a + b;
        }
    }


/* answerCell *****************************************************************/

    /* Your cell phone rings. Return true if you should answer it. Normally you
     * answer, except in the morning you only answer if it is your mom calling.
     * In all cases, if you are asleep, you do not answer. */

    public boolean answerCell(boolean isMorning,
            boolean isMom, boolean isAsleep) {
        if (isAsleep) {
              return false;
        } else if (isMorning && !isMom) {
                return false;
        } else {
              return true;
        }
    }


/* teaParty *******************************************************************/

    /* We are having a party with amounts of tea and candy. Return the int
     * outcome of the party encoded as 0=bad, 1=good, or 2=great. A party is
     * good (1) if both tea and candy are at least 5. However, if either tea or
     * candy is at least double the amount of the other one, the party is great
     * (2). However, in all cases, if either tea or candy is less than 5, the
     * party is always bad (0). */

    public int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) {
            return 0;
        }

        if (tea < candy * 2 && candy < tea * 2)
        {
            return 1;
        }

        return 2;
    }


/* fizzString *****************************************************************/

    /* Given a string str, if the string starts with "f" return "Fizz". If the
     * string ends with "b" return "Buzz". If both the "f" and "b" conditions
     * are true, return "FizzBuzz". In all other cases, return the string
     * unchanged. */

    public String fizzString(String str) {
        String result = "";

        if (str.charAt(0) == 'f') {
            result += "Fizz";
        }

        if (str.charAt(str.length() - 1) == 'b') {
            result += "Buzz";
        }

        if (result.length() == 0) {
            return str;
        }

        return result;
    }


/* fizzString2 ****************************************************************/

    /* Given an int n, return the string form of the number followed by "!". So
    * the int 6 yields "6!". Except if the number is divisible by 3 use "Fizz"
    * instead of the number, and if the number is divisible by 5 use "Buzz",
    * and if divisible by both 3 and 5, use "FizzBuzz". Note: the % "mod"
    * operator computes the remainder after division, so 23 % 10 yields 3. What
    * will the remainder be when one number divides evenly into another? */

    public String fizzString2(int n) {
        String result = "";
        if (n % 3 == 0) {
            result += "Fizz";
        }
        if (n % 5 == 0) {
            result += "Buzz";
        }
        if (result.equals("")) {
            result += n;
        }
        return result + "!";
    }


/* twoAsOne *******************************************************************/

    /* Given three ints, a b c, return true if it is possible to add two of the
     * ints to get the third. */

    public boolean twoAsOne(int a, int b, int c) {
        return a + b == c || a + c == b || b + c == a;
    }


/* inOrder ********************************************************************/

    /* Given three ints, a b c, return true if b is greater than a, and c is
     * greater than b. However, with the exception that if "bOk" is true, b
     * does not need to be greater than a. */

    public boolean inOrder(int a, int b, int c, boolean bOk) {
        if (bOk) {
            return b < c;
        } else {
            return a < b && b < c;
        }
    }


/* inOrderEqual ***************************************************************/

    /* Given three ints, a b c, return true if they are in strict increasing
     * order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7. However, with
     * the exception that if "equalOk" is true, equality is allowed, such as 5
     * 5 7 or 5 5 5. */

    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        if (equalOk) {
            return a <= b && b <= c;
        } else {
            return a < b && b < c;
        }
    }


/* lastDigit ******************************************************************/

    /* Given three ints, a b c, return true if two or more of them have the
     * same rightmost digit. The ints are non-negative. Note: the % "mod"
     * operator computes the remainder, e.g. 17 % 10 is 7. */

    public boolean lastDigit(int a, int b, int c) {
        int aDigit = a % 10;
        int bDigit = b % 10;
        int cDigit = c % 10;

        return aDigit == bDigit || aDigit == cDigit || bDigit == cDigit;
    }


/* lessBy10 *******************************************************************/

    /* Given three ints, a b c, return true if one of them is 10 or more less
     * than one of the others. */

    private boolean checkDiff10(int x, int y) {
        return Math.abs(x - y) >= 10;
    }

    public boolean lessBy10(int a, int b, int c) {
        return checkDiff10(a, b) || checkDiff10(b, c) || checkDiff10(a, c);
    }


/* withoutDoubles *************************************************************/

    /* Return the sum of two 6-sided dice rolls, each in the range 1..6.
     * However, if noDoubles is true, if the two dice show the same value,
     * increment one die to the next value, wrapping around to 1 if its value
     * was 6. */

    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
        if (noDoubles && die1 == die2) {
            die1 = die1 % 6 + 1;
        }

        return die1 + die2;
    }


/* maxMod5 ********************************************************************/

    /* Given two int values, return whichever value is larger. However if the
     * two values have the same remainder when divided by 5, then the return
     * the smaller value. However, in all cases, if the two values are the
     * same, return 0. */

    public int maxMod5(int a, int b) {
        if (a == b) {
            return 0;
        } else if (a % 5 == b % 5) {
            return Math.min(a, b);
        } else {
            return Math.max(a, b);
        }
    }


/* redTicket ******************************************************************/

    /* You have a red lottery ticket showing ints a, b, and c, each of which is
     * 0, 1, or 2. If they are all the value 2, the result is 10. Otherwise if
     * they are all the same, the result is 5. Otherwise so long as both b and
     * c are different from a, the result is 1. Otherwise the result is 0. */

    public int redTicket(int a, int b, int c) {
        if (a == 2 && b == 2 && c == 2) {
            return 10;
        } else if (a == b && b == c) {
            return 5;
        } else if (a != b && a != c) {
            return 1;
        } else {
            return 0;
        }
    }


/* greenTicket ****************************************************************/

    /* You have a green lottery ticket, with ints a, b, and c on it. If the
     * numbers are all different from each other, the result is 0. If all of
     * the numbers are the same, the result is 20. If two of the numbers are
     * the same, the result is 10. */

    public int greenTicket(int a, int b, int c) {
        if (a == b && b == c) {
            return 20;
        } else if (a == b || b == c || a == c) {
            return 10;
        } else {
            return 0;
        }
    }


/* blueTicket *****************************************************************/

    /* You have a blue lottery ticket, with ints a, b, and c on it. This makes
     * three pairs, which we'll call ab, bc, and ac. Consider the sum of the
     * numbers in each pair. If any pair sums to exactly 10, the result is 10.
     * Otherwise if the ab sum is exactly 10 more than either bc or ac sums,
     * the result is 5. Otherwise the result is 0. */

    public int blueTicket(int a, int b, int c) {
        int ab = a + b;
        int bc = b + c;
        int ac = a + c;

        if (ab == 10 || bc == 10 || ac == 10) {
            return 10;
        } else if (ab == bc + 10 || ab == ac + 10) {
            return 5;
        } else {
            return 0;
        }
    }


/* shareDigit *****************************************************************/

    /* Given two ints, each in the range 10..99, return true if there is a
     * digit that appears in both numbers, such as the 2 in 12 and 23. */

    private int getOnes(int n) {
        return n % 10;
    }

    private int getTens(int n) {
        return n / 10;
    }

    public boolean shareDigit(int a, int b) {
        int a1 = getTens(a);
        int a2 = getOnes(a);
        int b1 = getTens(b);
        int b2 = getOnes(b);

        return a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2;
    }


/* sumLimit *******************************************************************/

    /* Given 2 non-negative ints, a and b, return their sum, so long as the sum
     * has the same number of digits as a. If the sum has more digits than a,
     * just return a without b. */

    private int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }

    public int sumLimit(int a, int b) {
        int sum = a + b;
        if (countDigits(sum) == countDigits(a)) {
            return sum;
        } else {
            return a;
        }
    }

}