//Issue no #155

import java.util.*;

public class PlanetKingdoms {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // Number of planets
        int m = s.nextInt(); // Number of teleporters

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read teleporters and build the adjacency list
        for (int i = 0; i < m; i++) {
            int a = s.nextInt() - 1; // Adjust for 0-based indexing
            int b = s.nextInt() - 1; // Adjust for 0-based indexing
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        sc.close();

        boolean[] visited = new boolean[n];
        int[] kingdoms = new int[n];
        int currentKingdom = 1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Explore the current planet and its kingdom
                explorePlanet(adj, i, visited, kingdoms, currentKingdom);
                currentKingdom++;
            }
        }

        // Count the number of kingdoms
        int numKingdoms = currentKingdom - 1;

        // Output the result
        System.out.println(numKingdoms);
        for (int i = 0; i < n; i++) {
            System.out.print(kingdoms[i] + " ");
        }
    }

    // Depth-First Search to explore planets and assign kingdoms
    private static void explorePlanet(List<List<Integer>> adj, int planet, boolean[] visited, int[] kingdoms, int currentKingdom) {
        visited[planet] = true;
        kingdoms[planet] = currentKingdom;

        for (int neighbor : adj.get(planet)) {
            if (!visited[neighbor]) {
                explorePlanet(adj, neighbor, visited, kingdoms, currentKingdom);
            }
        }
    }
}
