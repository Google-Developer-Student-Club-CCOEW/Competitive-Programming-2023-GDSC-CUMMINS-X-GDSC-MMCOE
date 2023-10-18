//issue 153
import java.util.*;
 
public class RoundTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of cities
        int m = sc.nextInt(); // Number of roads
 
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
 
        // Read roads and build the adjacency list
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1; // Adjust for 0-based indexing
            int b = sc.nextInt() - 1; // Adjust for 0-based indexing
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
 
        sc.close();
 
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int startCity = -1;
 
        // Find a valid starting city
        for (int i = 0; i < n; i++) {
            if (!visited[i] && adj.get(i).size() > 1) {
                startCity = i;
                break;
            }
        }
 
        if (startCity == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
 
        // Construct the round trip
        path.add(startCity);
        visited[startCity] = true;
 
        int currentCity = startCity;
        while (true) {
            int nextCity = -1;
            for (int neighbor : adj.get(currentCity)) {
                if (!visited[neighbor]) {
                    nextCity = neighbor;
                    break;
                }
            }
 
            if (nextCity == -1) {
                // No unvisited neighbor found, check if we can return to the start
                if (adj.get(currentCity).contains(startCity)) {
                    path.add(startCity);
                    break;
                } else {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
 
            path.add(nextCity);
            visited[nextCity] = true;
            currentCity = nextCity;
        }
 
        // Output the round trip
        System.out.println(path.size());
        for (int city : path) {
            System.out.print((city + 1) + " "); // Adjust for 1-based indexing
        }
    }
}
