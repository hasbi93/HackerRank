'''
Solutions to all problems at https://codingbat.com/python/String-2
'''

# double_char ##################################################################

'''
Given a string, return a string where for every char in the original, there are
two chars.
'''

def double_char(str):
    return ''.join([x * 2 for x in str])


# count_hi #####################################################################

'''
Return the number of times that the string "hi" appears anywhere in the given
string.
'''

def count_hi(str):
    return str.count("hi")


# cat_dog ######################################################################

'''
Return True if the string "cat" and "dog" appear the same number of times in
the given string.
'''

def cat_dog(str):
    return str.count("cat") == str.count("dog")


# count_code ###################################################################

'''
Return the number of times that the string "code" appears anywhere in the given
string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.
'''

def count_code(str):
    count = 0
    for i in range(len(str) - 3):
        if str[i:i+2] == "co" and str[i+3] == "e":
            count += 1
    return count


# end_other ####################################################################

'''
Given two strings, return True if either of the strings appears at the very end
of the other string, ignoring upper/lower case differences (in other words, the
computation should not be "case sensitive"). Note: s.lower() returns the l
owercase version of a string.
'''

def end_other(a, b):
    return a.lower().endswith(b.lower()) or b.lower().endswith(a.lower())


# xyz_there ####################################################################

'''
Return True if the given string contains an appearance of "xyz" where the xyz is
not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
'''

def xyz_there(str):
    return "xyz" in str.replace(".xyz", "")
