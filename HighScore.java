import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Custom {
    int from;
    int to;
    int weight;

    public Custom(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = (int) 1e17;
        int min = (int) -1e17;

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Custom> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            weight *= -1;
            edges.add(new Custom(from, to, weight));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, max);
        dist[1] = 0;

        // Bellman-Ford Algorithm
        for (int i = 0; i < n; i++) {
            for (Custom e : edges) {
                int u = e.from;
                int v = e.to;
                int w = e.weight;
                if (dist[u] == max) {
                    continue;
                }
                dist[v] = Math.min(dist[v], dist[u] + w);
                dist[v] = Math.max(dist[v], min);
            }
        }

        for (int i = 0; i < n; i++) {
            for (Custom e : edges) {
                int u = e.from;
                int v = e.to;
                int w = e.weight;
                if (dist[u] == max) {
                    continue;
                }
                dist[v] = Math.max(dist[v],min);
                if (dist[v] > dist[u] + w) {
                    dist[v] = min;
                }
            }
        }

        if (dist[n] == min || dist[n] == max) {
            System.out.println(-1);
        } else {
            System.out.println(-1 * dist[n]);
        }
    }
}
