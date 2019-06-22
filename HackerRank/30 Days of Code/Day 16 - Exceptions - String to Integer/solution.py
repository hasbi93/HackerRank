"""
You should really use an else block to print the converted integer,
but HackerRank won't let you for this challenge. Oh well.
"""

S = input().strip()

try:
    print(int(S))
except ValueError:
    print("Bad String")
