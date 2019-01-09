#include <stdio.h>

int sum_of_digits(int n) {
    int sum = 0;
    while (n > 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%d", sum_of_digits(n));
}
