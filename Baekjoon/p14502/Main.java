package p14502;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    static int[][] originalMap;
    static int n, m;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        originalMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0); //3개의 벽을 세울 수 있는 모든 경우 수 => DFS
        //C(K, 3) = K(K-1)(K-2)/6, 최악의 경우 k = n * m 일 수 있다. 따라서 C(n x m, 3)만큼 BFS를 호출한다.

        bw.write(String.valueOf(maxSafeZone));

        bw.flush();

        br.close();
        bw.close();


    }

    static void dfs(int wallCnt) {
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++) { //완전탐색
            for (int j = 0; j < m; j++) {
                if(originalMap[i][j] == 0) {
                    originalMap[i][j] = 1; //벽을 세운다. (백트래킹)
                    dfs(wallCnt + 1);
                    originalMap[i][j] = 0; //벽을 지운다. (백트래킹)
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(originalMap[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }


        int[][] copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            copyMap[i] = originalMap[i].clone();
        }


        while(!q.isEmpty()) { //BFS - 바이러스 퍼트림 => O(V+E)
            Node node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(copyMap[nx][ny] == 0) {
                    q.add(new Node(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        calculateSafeZone(copyMap); //이중 for문 - 안전 영역(0)의 넓이를 계산한다. => O(n^2),


    }

    private static void calculateSafeZone(int[][] copyMap) {
        //안전 영역의 최댓값을 갱신한다.

        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        maxSafeZone = Math.max(maxSafeZone, safeZone);

    }

}

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
