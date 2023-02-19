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



class Result1 {

    /*
     * Complete the 'possibleChanges' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY usernames as parameter.
     */

    public static List<String> possibleChanges(List<String> usernames) {
        // Write your code here

        List<String> ans = new ArrayList<>();
        for (String username : usernames) {
            boolean changed = false;
            for (int j = 0; j < username.length() - 1; j++) {
                if (username.charAt(j) > username.charAt(j+1)) {
                    ans.add("YES");
                    changed = true;
                    break;
                }
            }
            if (!changed) {
                ans.add("NO");
            }
        }
        return ans;
    }

}

public class UsernamesChanges {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int usernamesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> usernames = IntStream.range(0, usernamesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result1.possibleChanges(usernames);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
