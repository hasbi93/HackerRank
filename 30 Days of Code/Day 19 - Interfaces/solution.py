"""
This solution is O(n^1/2) time; for each divisor d less than the square root
of n, we know the corresponding divisor greater than the root is (n / d).
Care must be taken for the special case where the square root divides n.

The O(n) solution is very similar and somewhat cleaner.
"""

################################################################################
#----------------------------- begin locked code ------------------------------#
class AdvancedArithmetic(object):
    def divisorSum(n):
        raise NotImplementedError
#------------------------------ end locked code -------------------------------#
################################################################################

from math import sqrt # Should normally go at top of file.

class Calculator(AdvancedArithmetic):

    @staticmethod
    def divisorSum(n):
        """Return the sum of all divisors of n."""
        sqrt_n = int(sqrt(n))

        # Make a list of tuples of divisors of n.
        divisors = [(d, n//d) for d in range(1, sqrt_n + 1) if n % d == 0]

        # Flatten the list and sum it.
        divisors = [d for pair in divisors for d in pair]
        divisor_sum = sum(divisors)

        # May have counted the square root twice, if it divides n.
        if sqrt_n ** 2 == n:
            divisor_sum -= sqrt_n
        return divisor_sum


################################################################################
#----------------------------- begin locked code ------------------------------#

n = int(input())
my_calculator = Calculator()
s = my_calculator.divisorSum(n)
print("I implemented: " + type(my_calculator).__bases__[0].__name__)
print(s)
#------------------------------ end locked code -------------------------------#
################################################################################
