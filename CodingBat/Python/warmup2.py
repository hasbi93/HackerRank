'''
Solutions to all problems at https://codingbat.com/python/Warmup-2
'''

# string_times #################################################################

'''
Given a string and a non-negative int n, return a larger string that is n
copies of the original string.
'''

def string_times(str, n):
    return n * str


# front_times ##################################################################

'''
Given a string and a non-negative int n, we'll say that the front of the string
is the first 3 chars, or whatever is there if the string is less than length 3.
Return n copies of the front;
'''

def front_times(str, n):
    return n * str[:3]


# string_bits  #################################################################

'''
Given a string, return a new string made of every other char starting with the
first, so "Hello" yields "Hlo".
'''

def string_bits(str):
    return str[::2]


# string_splosion ##############################################################

'''
Given a non-empty string like "Code" return a string like "CCoCodCode".
'''

def string_splosion(str):
    result = [str[:n] for n in range(len(str) + 1)]
    return ''.join(result)


# last2 ########################################################################

'''
Given a string, return the count of the number of times that a substring length
2 appears in the string and also as the last 2 chars of the string, so "hixxxhi"
yields 1 (we won't count the end substring).
'''

def last2(str):
    substring = str[-2:]
    count = 0
    substring_start = 0
    while True:
        substring_start = str.find(substring, substring_start)
        if substring_start == -1:
            break
        else:
            count += 1
            substring_start += 1
    return count - 1 # Subtract the last instance of the substring


# array_count9  ################################################################

'''
Given an array of ints, return the number of 9's in the array.
'''

def array_count9(nums):
    return nums.count(9)


# array_front9 #################################################################

'''
Given an array of ints, return True if one of the first 4 elements in the array
is a 9. The array length may be less than 4.
'''

def array_front9(nums):
    end = min(len(nums), 4)
    for i in range(end):
        if nums[i] == 9:
            return True
    return False


# array123 #####################################################################

'''
Given an array of ints, return True if the sequence of numbers 1, 2, 3 appears
in the array somewhere.
'''

def array123(nums):
    '''This is a little inefficient, since it makes copies of subarrays.'''
    seq = [1, 2, 3]
    for i in range(len(nums) - len(seq) + 1):
        if nums[i : i+len(seq)] == seq:
            return True
    return False


# string_match  ################################################################

'''
Given 2 strings, a and b, return the number of the positions where they contain
the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the
"xx", "aa", and "az" substrings appear in the same place in both strings.
'''

def string_match(a, b):
    shorter_len = min(len(a), len(b))
    count = 0
    for i in range(shorter_len - 1):
        if a[i : i+2] == b[i : i+2]:
            count += 1
    return count
