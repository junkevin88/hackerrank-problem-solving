package feb252023;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<String> stack = new Stack<>();
        String s = "";
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                String w = sc.next();
                stack.push(s);
                s += w;
            } else if (type == 2) {
                int k = sc.nextInt();
                stack.push(s);
                s = s.substring(0, s.length() - k);
            } else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k - 1));
            } else {
                s = stack.pop();
            }
        }

    }
}