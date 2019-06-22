#include <stdio.h>
#include <stdlib.h>

#define MAX(a, b) (a > b ? a : b)

int main(void) {
    int n;
    scanf("%d", &n);

    for (int r = -n + 1; r < n; r++) {
        for (int c = -n + 1; c < n; c++) {
            printf("%d ", MAX(abs(r), abs(c)) + 1);
        }
        printf("\n");
    }
}
