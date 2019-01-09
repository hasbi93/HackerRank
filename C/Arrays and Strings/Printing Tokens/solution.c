#include <stdio.h>
#include <stdlib.h>

#define MAXLINE 100

void print_tokens(char *str) {
    if (!str) {
        return;
    }

    char *c = str;
    while (*c != '\0') {
        if (*c == ' ') {
            putchar('\n');
        } else {
            putchar(*c);
        }
        c++;
    }
}

int main(void) {
    char *str = malloc((MAXLINE + 1) * sizeof(char));
    scanf("%[^\n]", str);
    print_tokens(str);
}
