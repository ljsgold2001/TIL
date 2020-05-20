#include <stdio.h>
#include <iostream>

int n;
void getResult( int x){
    if(x=1){
        printf("1")
    }
    else{
        getResult(x-1);
        printf("%d" , x);
        getResult(x-1);
    }

}



int main(){
    scanf("%d" , n);
    getResult(n);

}