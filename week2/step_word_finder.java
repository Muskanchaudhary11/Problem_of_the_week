import java.util.*;

public class StepWordsFinder {
    
    // Helper: build frequency map
    private static int[] buildFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Check if dictWord is a valid step word for inputWord
    private static boolean isStepWord(String input, String dictWord) {
        if (dictWord.length() != input.length() + 1) return false;

        int[] inputFreq = buildFreq(input);
        int[] dictFreq = buildFreq(dictWord);

        int extra = 0; // count how many extra chars are in dictWord
        for (int i = 0; i < 26; i++) {
            if (dictFreq[i] < inputFreq[i]) return false; // missing letters
            extra += dictFreq[i] - inputFreq[i];
        }

        return extra == 1; // must be exactly one extra character
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputWord = sc.nextLine().trim();
        int N = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> dict = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dict.add(sc.nextLine().trim());
        }

        List<String> result = new ArrayList<>();
        for (String word : dict) {
            if (isStepWord(inputWord, word)) {
                result.add(word);
            }
        }

        Collections.sort(result);
        for (String word : result) {
            System.out.println(word);
        }

        sc.close();
    }
}

/*
Complexity:
-------------
Time:  O(N * K)   (N = dictionary size, K = max word length ≤ 15)
Space: O(26) ~ O(1) for frequency arrays per check
*/
