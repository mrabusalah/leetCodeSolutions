import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean[] visited;
    static List<Integer>[] graph;
    static int n, tc;

    public static void main(String[] args) throws IOException {
        n = scanner.nextInt();
        tc = scanner.nextInt();

        graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < tc; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a - 1].add(b);
            graph[b - 1].add(a);
        }

        visited = new boolean[n + 1];
        dfs(1);
        System.out.println(countComponents());
    }

    private static void dfs(int node) {
        Stack<Integer> stack = new Stack<>();

        stack.add(node);
        visited[node] = true;

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            List<Integer> integers = graph[pop - 1];
            for (Integer integer : integers) {
                if (!visited[integer]) {
                    dfs(integer);
                }
            }
        }
    }

    private static int countComponents() {
        int count = 1;
        for (int i = 1; i <= n; i++)
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        return --count;
    }
}
