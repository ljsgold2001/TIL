#include<stdio.h>
#include<iostream>
#include<queue>

using namespace std;
int map[26][26] = {0,};
int visited[26][26] = {0,};
int n;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

struct p {
    int x;
    int y;
};

queue <p> q;

p p1;

void bfs(){
    while(!q.empty()){
        int now_x = q.front().x;
        int now_y = q.front().y;
        q.pop();

        for (int i =0; i<4; i++){
            int next_x = now_x + dx[i];
            int next_y = now_y + dy[i];

            if(next_x<0 || next_x >=n ||next_y <0 || next_y>=n ||map[next_x][next_y]==0 || visited[next_x][next_y]==1)continue;
            p1.x = next_x;
            p1.y = next_y;
            q.push(p1);
            
            map[next_x][next_y] = map[now_x][now_y] +1;
            visited[next_x][next_y] =1 ;
            
        }


    }
}

int main(){
    scanf("%d" , &n);
    for( int i =0; i<n ; i++){
        for( int j = 0; j<n; j++){
            scanf("%1d" ,&map[i][j]);
            if(map[i][j] ==1 && visited[i][j] ==0){
                p1.x = i;
                p1.y = j;
                q.push(p1);
                visited[i][j] =1;

                bfs();
            }
        }
    }

    printf("\n");

    for( int i =0; i<n ; i++){
        for( int j = 0; j<n; j++){
            printf("%d" , map[i][j]);
        }

        printf("\n");
    }
}
