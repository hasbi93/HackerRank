test_cases = int(input())

for i in range(test_cases):
    input_string = input()
    evens = input_string[::2]
    odds = input_string[1::2]
    print(evens, odds)