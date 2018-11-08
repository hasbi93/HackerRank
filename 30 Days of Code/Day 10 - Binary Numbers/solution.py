"""
An alternative solution that makes full use of built-in functions:
print(max(len(length) for length in bin(n)[2:].split('0')))

The solution below is much more low-level and "do it yourself".
"""

from collections import deque

def to_binary(n):
    """Convert a decimal number to a binary string."""
    d = deque()
    while n > 0:
        d.appendleft(n % 2)
        n = n // 2
    return ''.join(map(str, d))

def count_consecutive(string, target_ch):
    """Count the max consecutive character occurences in the string."""
    count = 0
    max_count = 0
    for ch in string:
        if ch == target_ch:
            count += 1
        elif count > 0:
            max_count = max(count, max_count)
            count = 0
    max_count = max(count, max_count)
    return max_count

def main():
    n = int(input())
    print(count_consecutive(to_binary(n), "1"))

if __name__ == "__main__":
    main()
