package feb232023;

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



class ResultTruckTour {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here

        int n = petrolpumps.size();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            petrol[i] = petrolpumps.get(i).get(0);
            distance[i] = petrolpumps.get(i).get(1);
        }
        int start = 0;
        int end = 1;
        int curr_petrol = petrol[start] - distance[start];
        while (start != end || curr_petrol < 0) {
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0) {
                    return -1;
                }
            }
            curr_petrol += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;

    }

}

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultTruckTour.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

