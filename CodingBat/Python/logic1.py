'''
Solutions to all problems at https://codingbat.com/python/Logic-1
'''

# cigar_party ##################################################################

'''
When squirrels get together for a party, they like to have cigars. A squirrel
party is successful when the number of cigars is between 40 and 60, inclusive.
Unless it is the weekend, in which case there is no upper bound on the number
of cigars. Return True if the party with the given values is successful,
or False otherwise.
'''

def cigar_party(cigars, is_weekend):
    return (40 <= cigars <= 60) or (is_weekend and cigars >= 40)


# date_fashion #################################################################

'''
You and your date are trying to get a table at a restaurant. The parameter
"you" is the stylishness of your clothes, in the range 0..10, and "date" is
the stylishness of your date's clothes. The result getting the table is
encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very
stylish, 8 or more, then the result is 2 (yes). With the exception that if
either of you has style of 2 or less, then the result is 0 (no). Otherwise
the result is 1 (maybe).
'''

def date_fashion(you, date):
    if you <= 2 or date <=2:
        return 0
    if you >= 8 or date >= 8:
        return 2
    return 1


# squirrel_play ################################################################

'''
The squirrels in Palo Alto spend most of the day playing. In particular, they
play if the temperature is between 60 and 90 (inclusive). Unless it is summer,
then the upper limit is 100 instead of 90. Given an int temperature and a
boolean is_summer, return True if the squirrels play and False otherwise.
'''

def squirrel_play(temp, is_summer):
    return (60 <= temp <= 90) or (is_summer and 60 <= temp <= 100)


# caught_speeding ##############################################################

'''
You are driving a little too fast, and a police officer stops you. Write code to
compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big
ticket. If speed is 60 or less, the result is 0. If speed is between 61 and 80
inclusive, the result is 1. If speed is 81 or more, the result is 2. Unless it
is your birthday -- on that day, your speed can be 5 higher in all cases.
'''

def caught_speeding(speed, is_birthday):
    bonus = 5
    none_max = 60 + (bonus if is_birthday else 0)
    small_max = 80 + (bonus if is_birthday else 0)

    if speed <= none_max:
        return 0
    if speed <= small_max:
        return 1
    return 2


# sorta_sum ####################################################################

'''
Given 2 ints, a and b, return their sum. However, sums in the range 10..19
inclusive, are forbidden, so in that case just return 20.
'''

def sorta_sum(a, b):
    sum = a + b
    return sum if (not 10 <= sum <= 19) else 20


# alarm_clock ##################################################################

'''
Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a
boolean indicating if we are on vacation, return a string of the form "7:00"
indicating when the alarm clock should ring. Weekdays, the alarm should be
"7:00" and on the weekend it should be "10:00". Unless we are on vacation --
then on weekdays it should be "10:00" and weekends it should be "off".
'''

def alarm_clock(day, vacation):
    is_weekday = 1 <= day <= 5
    if vacation:
        if is_weekday:
            return "10:00"
        return "off"
    else:
        if is_weekday:
            return "7:00"
        return "10:00"


# love6 ########################################################################

'''
The number 6 is a truly great number. Given two int values, a and b, return
True if either one is 6. Or if their sum or difference is 6. Note: the function
abs(num) computes the absolute value of a number.
'''

def love6(a, b):
    sum = a + b
    diff = abs(a - b)
    return a == 6 or b == 6 or sum == 6 or diff == 6


# in1to10 ######################################################################

'''
Given a number n, return True if n is in the range 1..10, inclusive. Unless
outside_mode is True, in which case return True if the number is less or equal
to 1, or greater or equal to 10.
'''

def in1to10(n, outside_mode):
    if outside_mode:
        return n <= 1 or n >= 10
    return 1 <= n <= 10


# near_ten #####################################################################

'''
Given a non-negative number "num", return True if num is within 2 of a multiple
of 10. Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2.
'''

def near_ten(num):
    rem = num % 10
    return rem <= 2 or rem >= 8
