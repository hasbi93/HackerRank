#include <stdio.h>

void print_number(int n) {
    char *NUMS_AS_STRINGS[] = {"one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine"};

    if (n > 9) {
        printf("Greater than 9\n");
    } else {
        printf("%s\n", NUMS_AS_STRINGS[n - 1]);
    }
}

int main() {
    int n;
    scanf("%d", &n);
    print_number(n);
}
