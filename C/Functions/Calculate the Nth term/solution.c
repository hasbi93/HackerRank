#include <stdio.h>

int find_nth_term(int n, int a, int b, int c) {
    switch (n) {
        case 1:
            return a;
        case 2:
            return b;
        case 3:
            return c;
    }

    int terms[n];
    terms[0] = a;
    terms[1] = b;
    terms[2] = c;

    for (int i = 3; i < n; i++) {
        terms[i] = terms[i - 1] + terms[i - 2] + terms[i - 3];
    }

    return terms[n - 1];
}

int main() {
    int n, a, b, c;
    scanf("%d %d %d %d", &n, &a, &b, &c);
    int result = find_nth_term(n, a, b, c);
    printf("%d", result);
}
