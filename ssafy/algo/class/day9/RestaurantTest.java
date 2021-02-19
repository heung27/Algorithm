import java.util.Scanner;
// https://www.acmicpc.net/problem/3109
// 백준 빵집
public class RestaurantTest {

static int R,C,cnt=0;
static char[][] map;
static boolean[][] v;
public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();
    map = new char[R][C];
    v = new boolean[R][C];
    
    for(int i=0; i<R; ++i) {
        map[i] = sc.next().toCharArray();
    }
    cnt = 0;
    for (int i = 0; i < R; i++) {
//            v[i][0] = true; //생략은 가능 어차피 오른쪽으로만 감
            dfs(i,0);
        }
        System.out.println(cnt);
    }

static int[] dr = {-1,0,1}; //순서가 중요함 대각선위, 오른쪽, 대각선 아래
private static boolean dfs(int r, int c) {
    if(c==C-1) {
        cnt++;
        return true;
    }
    int nr,nc = c+1;
    for(int d=0; d<3; ++d) {
        nr = r + dr[d];
        if( nr<0 || nr>=R ) {
            continue;
        }
//            if(nr<0 || nr>=R || nc<0 || nc>=C ) {
//                continue;
//            }
            if(v[nr][nc]) { // 파이프가 놓였거나, 놓아봤는데 실패함
                continue;
            }
            if(map[nr][nc] =='x') continue;

            v[nr][nc] = true;
            if(dfs(nr,nc)) { // 이미 마지막까지 갔다가 온 결과 성공했으니 재귀 호출 안함
                return true;
            }
//            백트래킹 복구하는것인데
//            이것은 이미 가봤으면 끝
//            visited[nr][nc] = false;
        }
//        갈수 없음을 판단한 false
        return false;
    }

}