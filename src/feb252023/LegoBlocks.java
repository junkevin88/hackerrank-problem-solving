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

class ResultLegoBlocks {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        // Write your code here

        int mod = 1000000007;

        List<Integer> singleCombo = new ArrayList<>(Arrays.asList(1, 2, 4, 8));

        for (int i = 4; i < m; i++) {
            int sum = IntStream.range(i - 4, i).map(singleCombo::get).sum();
            singleCombo.add(sum % mod);
        }

        List<Integer> totalCombo = singleCombo.stream().map(row -> (int) Math.pow(row, n) % mod).collect(Collectors.toList());

        List<Integer> validCombo = new ArrayList<>(Arrays.asList(1));

        for (int i = 1; i < m; i++) {
            int invalidCombo = IntStream.range(0, i).map(j -> totalCombo.get(j) * validCombo.get(i - 1 - j)).sum() % mod;
            validCombo.add((totalCombo.get(i) - invalidCombo + mod) % mod);
        }

        return validCombo.get(m - 1);

    }

}

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = ResultLegoBlocks.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

