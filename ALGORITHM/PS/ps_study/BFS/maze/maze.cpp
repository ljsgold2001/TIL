#include <iostream>
#include <queue>
#include <stdio.h>


using namespace std;
int n =0;
int m =0;
int map[101][101] = {0,};
int visited[101][101] = {0,};
int dx[4] = {-1,1,0,0};
int dy[4] = {0,0,1,-1};

struct p  {
    int x;
    int y;

};

queue <p>  q;

void bfs(){
    //bfs 처음 실행시 큐에 삽입해주는 곳
    p p1;
    p1.x =0;
    p1.y =0;
    q.push(p1);
    visited[0][0] =1;

    while(!q.empty()){
        //큐에서 현재값을 넣어주고 팝
        int now_x = q.front().x;
        int now_y = q.front().y;
        q.pop();

        //pop 한 것들에 대해서 동서남북을 규정해주고
        for(int i =0; i<4; i++){
            int next_x = now_x + dx[i];
            int next_y = now_y + dy[i];
            if(next_x <0 || next_y <0|| next_x >=n || next_y >=m|| visited[next_x][next_y] ==1 ||map[next_x][next_y] ==-1)
            continue; // 이러한 조건이 아닐경우에만 밑에를 실행한다.
            
            //큐에 넣고 map 바꿔주고 visited 바꿔주고
            p1.x = next_x;
            p1.y = next_y;
            q.push(p1);

            map[next_x][next_y] = map[now_x][now_y] + 1 ;
            visited[next_x][next_y] =1;

        }

    }

}


int main() {
scanf("%d %d", &n, &m);

for(int i=0; i<n; i++){
    for(int j=0; j<m; j++){
    scanf("%1d", &map[i][j]);
    if (map[i][j] ==0)map[i][j] = -1;
    if (map[i][j] ==1)map[i][j] = 0;

    }
}
bfs();

// for(int i=0; i<n; i++){
//     for(int j=0; j<m; j++){
//     printf("%d   ", map[i][j]);
//     }
//     printf("\n");
// }
printf("%d" , map[n-1][m-1]+1);

}