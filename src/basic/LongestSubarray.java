package basic;
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



class Results {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestSubarray(List<Integer> arr) {
        // Write your code here
        int end = 1, st = 0, mx = 1;
        Map<Integer, Integer> mp = new HashMap<>();
        if (!mp.containsKey(arr.get(st)))
            mp.put(arr.get(st), 0);
        mp.put(arr.get(st), mp.get(arr.get(st)) + 1);
        while (end < arr.size()) {
            // here we are trying to check the i. Condition
            if (Math.abs(arr.get(end) - arr.get(end - 1))
                    == 0
                    || Math.abs(arr.get(end) - arr.get(end - 1))
                    == 1) {
                if (!mp.containsKey(arr.get(end)))
                    mp.put(arr.get(end), 0);
                mp.put(arr.get(end),
                        mp.get(arr.get(end)) + 1);
            }
            else {
                // if the i.condition is not satisfy it mean
                // current pos(starting Subarray) will not
                // be candidate for max len . skip it .
                mp.clear();
                mp.put(arr.get(end), 1);
                st = end;
            }
            if (mp.size() == 2)
                mx = Math.max(mx, end - st + 1);
            end++;
        }
        return mx;



    }

    public class LongestSubarray {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Results.longestSubarray(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}