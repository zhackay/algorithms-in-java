package cheat.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * 단지 번호 붙히기
 *
 * https://www.acmicpc.net/problem/2667
 */
public class DistrictNumber{

    void dfs(int[][] a) {
        int d[][] = new int[a.length][a[0].length];

        if (a.length <= 1) {
            d[0][0] = a[0][0];
            return;
        }

        int cnt = 0;
        for (int i=0;i<a.length;i++) {
            for (int j=0;j<a[0].length; j++) {
                bfs(a, d, i, j, ++cnt);
            }
        }

        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> houses = new HashMap<>();
        // 출력 첫째줄에는 총 단지수, 그 다음은 각 단지내 집의 수를 오름차순으로
        for (int i=0;i<d.length;i++) {
            for (int j=0;j<d[0].length; j++) {
                if (d[i][j] > max) max = d[i][j];
                if (d[i][j] > 0) {
                    int curCount = houses.getOrDefault(d[i][j], -1);
                    if (curCount == -1)
                        houses.put(d[i][j], 1);
                    else
                        houses.put(d[i][j], curCount++);
                }
            }
        }

        houses.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(k -> System.out.println(k.getValue()));

    }

    @Data @AllArgsConstructor
    class Cell {
        int i;
        int j;

        public Boolean isHouse(int[][] a) {
            return getValue(a) == 1;
        }

        public int getValue(int[][] a) {
            return a[i][j];
        }

        public void setValue(int[][] a, int val) {
            a[i][j] = val;
        }
    }

    private void bfs(int a[][], int d[][], int i, int j, int count) {
        Queue<Cell> q = new LinkedList<>();
        Cell house = new Cell(i, j);

        if (house.getValue(a) == 1)
            q.add(house);

        while (!q.isEmpty()) {
            Cell x = q.remove();

            if (x.isHouse(a)) {
                x.setValue(d, count);
                int row = x.getI();
                int col = x.getJ();

                if (col < a[0].length-1)
                    q.add(new Cell(row, col+1));
                if (col > 0)
                    q.add(new Cell(row, col-1));
                if (row < a.length -1)
                    q.add(new Cell(row+1, col));
                if (row > 0)
                    q.add(new Cell(row-1, col));
            }
        }
    }
}
