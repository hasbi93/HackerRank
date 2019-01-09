#include <stdio.h>

int main(void) {
    int aInt;
    int bInt;
    
    float aFloat;
    float bFloat;
    
    scanf("%d %d", &aInt,   &bInt);
    scanf("%f %f", &aFloat, &bFloat);
    
    printf("%d %d\n",     aInt   + bInt,   aInt   - bInt);
    printf("%.1f %.1f\n", aFloat + bFloat, aFloat - bFloat);
}