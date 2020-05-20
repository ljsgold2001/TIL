#include <stdio.h>
#include <iostream>
#include <queue>

int t ,m , n,k;
int x,y;
int map[51][51] = {0,};
int visited[51][51] = {0,};

int main(){
    scanf("%d" , &t);
    for (int i = 0; i<t ; i++){
        scanf("%d %d %d",  &m, &n ,&k );
        for( int j =0; j<k; j++){
            scanf("%d %d", &x,&y);
            map[x][y] =1;

            
        }
    }

    for(int i = 0 ; i< n; i++){
        for (int j = 0; j<m; j++){
            
            printf("%d" , map[i][j]);
        }
        printf("\n");
    }
}

