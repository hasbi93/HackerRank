"""
This solution filters out even inputs (which, besides 2, are never prime), and
only checks odd divisors for odd inputs. This is still O(n^1/2).
"""

import math

def is_prime(n):
    """Returns True if and only if the given integer is prime."""
    if n <= 1:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False

    sqrt_n = int(math.sqrt(n))
    for d in range(3, sqrt_n + 1, 2):
        if n % d == 0:
            return False
    return True

def main():
    test_cases = int(input())
    for _ in range(test_cases):
        n = int(input())
        print("Prime" if is_prime(n) else "Not prime")

if __name__ == "__main__":
    main()
