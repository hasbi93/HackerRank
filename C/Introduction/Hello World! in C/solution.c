#include <stdio.h>

#define BUFFER_SIZE 100

int main(void) {
    char s[BUFFER_SIZE];
    fgets(s, BUFFER_SIZE, stdin);
    printf("Hello, World!\n%s\n", s);       
}