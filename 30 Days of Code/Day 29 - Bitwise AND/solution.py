"""
For some good explanations of this solution, see the Discussion tab on
HackerRank. It's best explained in steps with several examples.
"""

test_cases = int(input().strip())
for _ in range(test_cases):
    n, k = [int(x) for x in input().split()]
    result = (k - 1) if (((k - 1) | k) <= n) else (k - 2)
    print(result)
