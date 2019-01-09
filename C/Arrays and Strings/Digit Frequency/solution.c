#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAXLINE 1000

void get_digit_freqs(char *string, int *digit_freqs) {
    char *c = string;
    while (*c != '\0') {
        if (isdigit(*c)) {
            digit_freqs[*c - '0'] += 1;
        }
        c++;
    }
}

int main(void) {
    char string[MAXLINE];
    fgets(string, MAXLINE, stdin);

    int *digit_freqs = (int *) calloc(10, sizeof(int));
    get_digit_freqs(string, digit_freqs);

    for (int i = 0; i < 10; i++) {
        printf("%d ", digit_freqs[i]);
    }
    printf("\n");
}
