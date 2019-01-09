#include <stdio.h>

void print_maxes(int n, int k) {
    int max_and = 0;
    int max_or = 0;
    int max_xor = 0;

    for (int a = 1; a <= n; a++) {
        for (int b = a + 1; b <= n; b++) {
            int and = a & b;
            if ((and > max_and) && (and < k)) {
                max_and = and;
            }

            int or = a | b;
            if ((or > max_or) && (or < k)) {
                max_or = or;
            }

            int xor = a ^ b;
            if ((xor > max_xor) && (xor < k)) {
                max_xor = xor;
            }
        }
    }

    printf("%d\n%d\n%d\n", max_and, max_or, max_xor);
}

int main(void) {
    int n, k;
    scanf("%d %d", &n, &k);
    print_maxes(n, k);
}
