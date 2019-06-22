'''
Solutions to all problems at https://codingbat.com/python/Logic-2
'''

# make_bricks ##################################################################

'''
We want to make a row of bricks that is goal inches long. We have a number of
small bricks (1 inch each) and big bricks (5 inches each). Return True if it is
possible to make the goal by choosing from the given bricks. This is a little
harder than it looks and can be done without any loops.
'''

def make_bricks(small, big, goal):
  # Enough total inches to make the goal length?
  if goal > small + big * 5:
      return False

  # Enough small bricks to equal the remainder of the goal length divided by 5?
  return goal % 5 <= small


# lone_sum #####################################################################

'''
Given 3 int values, a b c, return their sum. However, if one of the values is
the same as another of the values, it does not count towards the sum.
'''

def lone_sum(*nums):
    """This function is generalized to accept an arbitrary number of inputs."""
    num_freqs = {}
    for n in nums:
        if n in num_freqs:
            num_freqs[n] = num_freqs[n] + 1
        else:
            num_freqs[n] = 1

    sum = 0
    for n, f in num_freqs.items():
        if f == 1:
            sum += n
    return sum


# lucky_sum ####################################################################

'''
Given 3 int values, a b c, return their sum. However, if one of the values is
13 then it does not count towards the sum and values to its right do not count.
So for example, if b is 13, then both b and c do not count.
'''

def lucky_sum(*nums):
    """This function is generalized to accept an arbitrary number of inputs."""
    sum = 0
    for n in nums:
        if n == 13:
            break
        sum += n
    return sum


# no_teen_sum ##################################################################

'''
Given 3 int values, a b c, return their sum. However, if any of the values is a
teen -- in the range 13..19 inclusive -- then that value counts as 0, except 15
and 16 do not count as a teens.
'''

def fix_teen(n):
    if (13 <= n <= 19) and not (15 <= n <= 16):
        return 0
    return n

def no_teen_sum(*nums):
    """This function is generalized to accept an arbitrary number of inputs."""
    sum = 0
    for n in nums:
        sum += fix_teen(n)
    return sum


# round_sum ####################################################################

'''
For this problem, we'll round an int value up to the next multiple of 10 if its
rightmost digit is 5 or more, so 15 rounds up to 20. Alternately, round down to
the previous multiple of 10 if its rightmost digit is less than 5, so 12 rounds
down to 10. Given 3 ints, a b c, return the sum of their rounded values.
'''

def round10(n):
    mod = n % 10
    n -= mod
    if mod >= 5:
        n += 10
    return n

def round_sum(*nums):
    """This function is generalized to accept an arbitrary number of inputs."""
    sum = 0
    for num in nums:
        sum += round10(num)
    return sum


# close_far ####################################################################

'''
Given three ints, a b c, return True if one of b or c is "close" (differing from
a by at most 1), while the other is "far", differing from both other values by
2 or more. Note: abs(num) computes the absolute value of a number.
'''

def is_far(val, x, y):
    """Return True if val is at least 2 away from both x and y."""
    return abs(val - x) >= 2 and abs(val - y) >= 2

def is_close(x, y):
    """Return True if x and y differ by at most 1."""
    return abs(x - y) <= 1

def close_far(a, b, c):
    return (is_close(a, b) and is_far(c, a, b)
        or is_close(a, c) and is_far(b, a, c))


# make_chocolate ###############################################################

'''
We want make a package of goal kilos of chocolate. We have small bars
(1 kilo each) and big bars (5 kilos each). Return the number of small
bars to use, assuming we always use big bars before small bars.
Return -1 if it can't be done.
'''

def make_chocolate(small, big, goal):
    rem = goal % 5

    # Not enough total or small bars to reach 'goal'
    if small + big * 5 < goal or small < rem:
        return -1

    # Enough big bars to reach 'goal' (and also 'goal - rem')
    if big * 5 >= goal:
        return rem

    # Enough bars to reach 'goal', but have to use more than 'rem' small bars
    return goal - big * 5
