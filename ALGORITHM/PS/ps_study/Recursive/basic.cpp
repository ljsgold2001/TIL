//n부터 m까지의 범위중에서 r개를 뽑는다.(0)

//n,m,r이 3보다 크다 8번째 값을 구해라

#include <stdio.h>
#include <iostream>
int n,m,k;
int r =3;
int result[1000] ={0,};
int check[1000] ={0,}; //최대범위를 따라가야되는것
int answer[1000] ={0,};// 나올수있는 경우의수를 잡아라 // 공간복잡도는 1억미만이면 안터진다. 백만혹은 십만 문제따라서 내가
int rank =0;

void getResult(int x){
    if(x ==r){
        for(int i = 0; i<3; i++){
            if(i==0){
                answer[rank] = result[i]*100;
            }
            if(i ==1){
                answer[rank] = answer[rank] + result[i] *10;
            }
            if(i ==2){
                answer[rank] = answer[rank] + result[i];
            }
            
            //printf("%d",result[i]);

        }
        //printf("\n");
        ++rank;
    }
    else{

        for(int i =n; i<=m; i++){
            if(check[i]==0){
                result[x] =i;
                check[i] = 1;
                getResult(x+1);
                check[i] = 0;
            }
        }
    }

}

int main(){
    scanf("%d %d %d" , &n ,&m , &k);
    getResult(0);
    
    for (int i =0; i<rank; i++){
        if(answer[i] == k){
            printf("%d" , i+1);
        }
    }

    //printf("%d" , answer[7]);

}

