package feb252023;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class ResultBreadthFirstSearchShortestReach {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0) - 1).add(edge.get(1) - 1);
            adj.get(edge.get(1) - 1).add(edge.get(0) - 1);
        }

        // Create visited array
        boolean[] visited = new boolean[n];

        // Create distance array
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        // Create queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s - 1);
        visited[s - 1] = true;
        distance[s - 1] = 0;

        // BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbour : adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    distance[neighbour] = distance[curr] + 6;
                    queue.add(neighbour);
                }
            }
        }


        // Create result list
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != s - 1) {
                result.add(distance[i]);
            }
        }

        return result;


    }

}
public class BreadthFirstSearchShortestReach {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = ResultBreadthFirstSearchShortestReach.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

