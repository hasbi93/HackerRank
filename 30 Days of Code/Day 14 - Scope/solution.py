"""
Once again, HackerRank doesn't follow PEP 8 naming guidelines here...
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class Difference:
    def __init__(self, a):
        self.__elements = a
#------------------------------ end locked code -------------------------------#
################################################################################

    def computeDifference(self):
        maxElement = max(self.__elements)
        minElement = min(self.__elements)
        self.maximumDifference = abs(maxElement - minElement)

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