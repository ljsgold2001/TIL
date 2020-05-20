#include<stdio.h>
#include<iostream>
#include<queue>

using namespace std;
int m;
int n;
int h;

struct p {
    int x;
    int y;
    int z;

};

p p1;

queue <p> q;
const int dx[] = {-1, 1, 0, 0, 0, 0};
const int dy[] = {0, 0, -1, 1, 0, 0};
const int dz[] = {0, 0, 0, 0, -1, 1};




int map[101][101][101] = {0,};
int visited[101][101][101] = {0,};


void bfs(){
    while(!q.empty()){
        int now_x = q.front().x;
        int now_y = q.front().y;
        int now_z = q.front().z;

        q.pop();

        for (int i =0; i<6; i++){
            int next_x = now_x + dx[i];
            int next_y = now_y + dy[i];
            int next_z = now_z + dz[i];

            if (next_x<0 || next_y<0|| next_z<0|| next_x>=h ||next_y>=n||next_z>=m|| map[next_x][next_y][next_z] ==-1||visited[next_x][next_y][next_z] ==1)continue;
                p1.x = next_x;
                p1.y = next_y;
                p1.z = next_z;

                q.push(p1);
                map[next_x][next_y][next_z] = map[now_x][now_y][now_z] +1;
                visited[next_x][next_y][next_z] = 1;

        }
    }
}


int main(){
    int max =0;
    scanf("%d %d %d",&m, &n, &h);
    for (int i =0; i<h; i++){
        for(int j =0; j <n; j++){
            for(int k=0; k<m; k++){
                scanf("%d" , &map[i][j][k]);//1= 익은 토마토 , 0 = 익지 않은 토마토 , -1 = 토마토가 없음
                if (map[i][j][k] == 1 ){
                    p1.x = i;
                    p1.y = j;
                    p1.z = k;
                    q.push(p1);

                    visited[i][j][k] = 1;
                } 
            }
        }
    }
    bfs();

    // for (int i =0; i<h; i++){
    //     for(int j =0; j <n; j++){
    //         for(int k=0; k<m; k++){
    //             printf("%d" , map[i][j][k]);
    //         }
    //         printf("\n");
    //     }
    //     printf("\n");
        
    // }
    for (int i=0; i<h; i++) {
        for (int j=0; j<n; j++) {
            for (int k=0; k<m; k++) {   
                // Not all tomato ripened.
                if (map[i][j][k] == 0) {
                    printf("-1\n");
                    return 0;
                }
                // Max value is answer.
                if (max < map[i][j][k]) max = map[i][j][k];
            }
        }
    }
    
    printf("%d\n", max-1);
    return 0;



}