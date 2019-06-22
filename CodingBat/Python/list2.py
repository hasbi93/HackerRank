'''
Solutions to all problems at https://codingbat.com/python/List-2
'''

# count_evens ##################################################################

'''
Return the number of even ints in the given array. Note: the % "mod" operator
computes the remainder, e.g. 5 % 2 is 1.
'''

def count_evens(nums):
    count = 0
    for num in nums:
        if num % 2 == 0:
            count += 1
    return count


# big_diff #####################################################################

'''
Given an array length 1 or more of ints, return the difference between the
largest and smallest values in the array. Note: the built-in min(v1, v2)
and max(v1, v2) functions return the smaller or larger of two values.
'''

def big_diff(nums):
    return max(nums) - min(nums)


# centered_average #############################################################

'''
Return the "centered" average of an array of ints, which we'll say is the mean
average of the values, except ignoring the largest and smallest values in the
array. If there are multiple copies of the smallest value, ignore just one copy,
and likewise for the largest value. Use int division to produce the final
average. You may assume that the array is length 3 or more.
'''

def centered_average(nums):
    """This solution only makes one pass through the list, whereas calling
    min(), max(), and sum() would each add another pass."""
    max_num = float('-inf')
    min_num = float('inf')
    sum = 0
    for num in nums:
        if num > max_num:
            max_num = num
        if num < min_num:
            min_num = num
        sum += num
    sum -= (max_num + min_num)
    return sum / (len(nums) - 2)


# sum13 ########################################################################

'''
Return the sum of the numbers in the array, returning 0 for an empty array.
Except the number 13 is very unlucky, so it does not count and numbers that
come immediately after a 13 also do not count.
'''

def sum13(nums):
    sum = 0
    for i, num in enumerate(nums):
        if num != 13:
            if i == 0 or nums[i - 1] != 13:
                sum += num
    return sum


# sum67 ########################################################################

'''
Return the sum of the numbers in the array, except ignore sections of numbers
starting with a 6 and extending to the next 7 (every 6 will be followed by at
least one 7). Return 0 for no numbers.
'''

def skip67(i, nums):
    """Given i such that nums[i] == 6, returns min j such that nums[j] == 7."""
    j = i
    while nums[j] != 7:
        j += 1
    return j


def sum67(nums):
    sum = 0
    i = 0
    while i < len(nums):
        if nums[i] == 6:
            i = skip67(i, nums)
        else:
            sum += nums[i]
        i += 1
    return sum


# has22 ########################################################################

'''
Given an array of ints, return True if the array contains a 2 next to a 2 somewhere.
'''

def has22(nums):
    for i in range(1, len(nums)):
        if nums[i - 1] == 2 and nums[i] == 2:
            return True
    return False
