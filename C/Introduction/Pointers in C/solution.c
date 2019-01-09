#include <stdio.h>
#include <stdlib.h>

void update(int *a, int *b) {
    int sum = *a + *b;
    int absDiff = abs(*a - * b);
    *a = sum;
    *b = absDiff;
}

int main(void) {
    int a;
    int b;
    scanf("%d %d", &a, &b);
    update(&a, &b);
    printf("%d\n%d", a, b);
}
