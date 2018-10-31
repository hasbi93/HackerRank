def print_multiples(n, k):
    """Prints the first k multiples of n."""
    for i in range(1, k + 1):
        print("{} x {} = {}".format(n, i, n*i))

n = int(input())
print_multiples(n, 10)