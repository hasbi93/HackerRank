"""
Despite this being a tutorial on recursion, I couldn't resist throwing in a
functional programming implementation.
"""

from functools import reduce

def factorial_recursive(n):
    if n <= 1:
        return 1
    
    return n * factorial_recursive(n - 1)

def factorial_functional(n):
    return reduce(lambda x, y: x * y, range(1, n+1))

def main():
    n = int(input())
    print(factorial_recursive(n))

if __name__ == "__main__":
    main()
