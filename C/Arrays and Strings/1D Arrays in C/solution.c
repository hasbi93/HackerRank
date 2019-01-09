#include <stdio.h>
#include <stdlib.h>

int sum(int *arr, int length) {
    int sum = 0;
    for (int i = 0; i < length; i++) {
        sum += arr[i];
    }
    return sum;
}

int main(void) {
    int n;
    scanf("%d", &n);

    int *arr = (int *) malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    printf("%d\n", sum(arr, n));
    free(arr);
}
