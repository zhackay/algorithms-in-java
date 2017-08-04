package cheat.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2178
 */
public class ShortestDistanceMaze {
    int[][] map;
    Boolean[][] check;
    int[][] dist;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int n;
    private static int m;

    public ShortestDistanceMaze(int[][] map) {
        this.map = map;

        n = map.length;
        m = (n > 0) ? map[0].length : 0;

        check = new Boolean[n][m];
        dist = new int[n][m];
    }

    @Data @AllArgsConstructor
    class Cell {
        int i;
        int j;
    }

    public int getShortestDistance() {
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(0, 0));
        check[0][0] = true;
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            Cell cur = q.remove();
            int x = cur.getI();
            int y = cur.getJ();

            for (int k=0; k<4; k++) {
                int nx = x + dx[k]; // next x
                int ny = y + dy[k]; // next y
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (check[nx][ny] == false && map[nx][ny] == 1) {
                        q.add(new Cell(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }

        int shortestDistance = dist[n-1][m-1];
        System.out.println(shortestDistance);

        return shortestDistance;
    }
}
