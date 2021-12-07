import java.util.*;

public class BFS {
    static int tc;
    static List<Integer>[] graph;
    static int gSize;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        gSize = scanner.nextInt();
        for (int i = 0; i < gSize; i++) {
            graph[i] = new ArrayList<>();
        }

        tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a - 1].add(b);
            graph[b - 1].add(a);
        }
        visited = new boolean[gSize + 1];
        bfs(0);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            Integer removed = queue.remove();
            for (Integer integer : graph[removed - 1])
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
        }
    }
}
