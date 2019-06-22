"""
Note that Python lists are efficient as stacks, but not as queues. Also note
that this is not a memory-efficient way to check for palindromes; you could
just check the first half of the string against the second half in-place.

Yet again, HackerRank forces camelCase methods that should be snake_case. And
an unused import. And a lot of unusual code styling.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
import sys
#------------------------------ end locked code -------------------------------#
################################################################################

import collections

class Solution:
    """Encapsulates a stack and a queue."""

    def __init__(self):
        self.queue = collections.deque()
        self.stack = list()

    def pushCharacter(self, ch):
        self.stack.append(ch)

    def enqueueCharacter(self, ch):
        self.queue.append(ch)

    def popCharacter(self):
        return self.stack.pop()

    def dequeueCharacter(self):
        return self.queue.popleft()


################################################################################
#----------------------------- begin locked code ------------------------------#
# read the string s
s=input()
#Create the Solution class object
obj=Solution()

l=len(s)
# push/enqueue all the characters of string s to stack
for i in range(l):
    obj.pushCharacter(s[i])
    obj.enqueueCharacter(s[i])

isPalindrome=True
'''
pop the top character from stack
dequeue the first character from queue
compare both the characters
'''
for i in range(l // 2):
    if obj.popCharacter()!=obj.dequeueCharacter():
        isPalindrome=False
        break
#finally print whether string s is palindrome or not.
if isPalindrome:
    print("The word, "+s+", is a palindrome.")
else:
    print("The word, "+s+", is not a palindrome.")
#------------------------------ end locked code -------------------------------#
################################################################################
