#include <stdio.h>

#define MAX_LEN 100

int main() {
    char ch;
    char word[MAX_LEN];
    char sentence[MAX_LEN];
    
    ch = fgetc(stdin);
    getchar(); // Skip the newline
    fgets(word, MAX_LEN, stdin);
    fgets(sentence, MAX_LEN, stdin);
    
    fprintf(stdout, "%c\n", ch);
    fputs(word, stdout);
    fputs(sentence, stdout);
}