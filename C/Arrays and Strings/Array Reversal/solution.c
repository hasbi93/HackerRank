#include <stdio.h>
#include <stdlib.h>

void reverse(int arr[], int len) {
    int i = 0;
    int j = len - 1;
    for (int i = 0, j = len - 1; i < j; i++, j--) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

int main(void) {
    int n;
    scanf("%d", &n);

    int *arr = (int *) malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", arr + i);
    }

    reverse(arr, n);
    for (int i = 0; i < n; i++) {
        printf("%d ", *(arr + i));
    }
    printf("\n");
}
