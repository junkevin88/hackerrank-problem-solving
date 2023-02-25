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

class Result {

    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isEndOfWord = false;
        }

    }

    static class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = current.children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    current.children.put(c, node);
                }
                current = node;
                if (current.isEndOfWord) {
                    return false;
                }
            }
            current.isEndOfWord = true;
            return true;
        }
    }


    public static void noPrefix(List<String> words) {
        // Write your code here
        Trie trie = new Trie();
        for (String word : words) {
            if (!trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");


    }

}

public class NoPrefixSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}

