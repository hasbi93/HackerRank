"""
HackerRank doesn't mention it, but Bubble Sort is a O(n^2) sorting algorithm,
which is generally pretty bad.
"""

n = int(input())
a = list(map(int, input().strip().split(' ')))

total_swaps = 0
for _ in range(n):
    swaps = 0
    for i in range(n - 1):
        if a[i] > a[i+1]:
            a[i], a[i+1] = a[i+1], a[i]
            swaps += 1
    if swaps:
        total_swaps += swaps
    else:
        break

print("Array is sorted in {} swaps.".format(total_swaps))
print("First Element: {}".format(a[0]))
print("Last Element: {}".format(a[-1]))
