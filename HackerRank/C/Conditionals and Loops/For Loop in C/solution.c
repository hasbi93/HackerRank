#include <stdio.h>

void print_number(int n) {
    static const char *NUMS_AS_STRINGS[] = {"one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"};

    if (n <= 9) {
        printf("%s\n", NUMS_AS_STRINGS[n - 1]);
    } else if (n % 2 == 0) {
        printf("even\n");
    } else {
        printf("odd\n");
    }
}

int main() {
    int a, b;
    scanf("%d\n%d", &a, &b);
  	for (int n = a; n <= b; n++) {
        print_number(n);
    }
}
