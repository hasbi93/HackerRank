def print_multiples(n, k):
    """Print the first k multiples of n."""
    for i in range(1, k + 1):
        print("{} x {} = {}".format(n, i, n*i))

def main():
    n = int(input())
    print_multiples(n, 10)

if __name__ == "__main__":
    main()
