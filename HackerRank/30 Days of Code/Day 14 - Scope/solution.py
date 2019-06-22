"""
Once again, HackerRank forces users to use camelCase where snake_case is 
conventional.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class Difference:
    def __init__(self, a):
        self.__elements = a
#------------------------------ end locked code -------------------------------#
################################################################################

    def computeDifference(self):
        max_element = max(self.__elements)
        min_element = min(self.__elements)
        self.maximumDifference = abs(max_element - min_element)

################################################################################
#----------------------------- begin locked code ------------------------------#
# End of Difference class

_ = input()
a = [int(e) for e in input().split(' ')]

d = Difference(a)
d.computeDifference()

print(d.maximumDifference)
#------------------------------ end locked code -------------------------------#
################################################################################
