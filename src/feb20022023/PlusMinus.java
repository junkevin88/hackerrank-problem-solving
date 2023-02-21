package feb20022023;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                positive++;
            } else if (arr.get(i) < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println((double) positive / arr.size());
        System.out.println((double) negative / arr.size());
        System.out.println((double) zero / arr.size());

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}

