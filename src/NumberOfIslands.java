import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static char[][] grid =
//            {
//                    {'1', '1', '0', '0', '0'},
//                    {'1', '1', '0', '0', '0'},
//                    {'0', '0', '1', '0', '0'},
//                    {'0', '0', '0', '1', '1'}
//            };
            {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
    static int ROW;
    static int COL;
    static boolean[][] visited;
    static Pair[] directions = {
            new Pair(0, 1),
            new Pair(1, 0),
            new Pair(0, -1),
            new Pair(-1, 0)
    };


    public static void main(String[] args) {
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        ROW = grid.length;
        COL = grid[0].length;
        int answer = 0;

        visited = new boolean[ROW + 1][COL + 1];

        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (!visited[i + 1][j + 1] && grid[i][j] == '1') {
                    answer++;
                    bfs(i, j);
                }
        return answer;
    }

    private static void bfs(int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row + 1][col + 1] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.peek();
            queue.remove();
            for (Pair direction : directions) {
                int new_row = direction.getRow() + pair.getRow();
                int new_col = direction.getCol() + pair.getCol();

                if (inside(new_row, new_col) && !visited[new_row + 1][new_col + 1] && grid[new_row][new_col] == '1') {
                    visited[new_row + 1][new_col + 1] = true;
                    queue.add(new Pair(new_row, new_col));
                }
            }
        }
    }

    private static boolean inside(int row, int col) {
        return 0 <= row && row < ROW && 0 <= col && col < COL;
    }
}

class Pair {
    private final int row;
    private final int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
