"""
An alternative solution is simply print(*reversed(input().split()))
The solution below provides more practice manipulating lists.
"""

def reverse_list(L):
    for i in range(len(L) // 2):
        L[i], L[-(i+1)] = L[-(i+1)], L[i]

n = int(input()) # Don't really need this...

input_list = list(map(int, input().split()))
reverse_list(input_list)
print(*input_list)