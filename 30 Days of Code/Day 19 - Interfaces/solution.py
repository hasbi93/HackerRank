"""
This solution is O(n) time; it could be reduced to O(n^1/2) by only checking
divisors up to the square root of n. For each divisor d less than the root, we
know the corresponding divisor greater than the root is (n / d). Care must be
taken for the special case where the square root is an integer.

I've opted for the cleaner O(n) solution below, with an easy list comprehension.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class AdvancedArithmetic(object):
    def divisorSum(n):
        raise NotImplementedError
#------------------------------ end locked code -------------------------------#
################################################################################

class Calculator(AdvancedArithmetic):
    def divisorSum(self, n):
        divisors = [x for x in range(1, sqrt_n + 1) if n % x == 0]
        return sum(divisors)

################################################################################
#----------------------------- begin locked code ------------------------------#

n = int(input())
my_calculator = Calculator()
s = my_calculator.divisorSum(n)
print("I implemented: " + type(my_calculator).__bases__[0].__name__)
print(s)
#------------------------------ end locked code -------------------------------#
################################################################################