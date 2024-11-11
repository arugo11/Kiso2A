import java.io.*;
import java.util.*;

/**
 * マルコフ連鎖による文生成を行うクラス
 */
public class Markov {
    /** 生成する文の単語数 */
    private static final int SENTENCE_LENGTH = 10;
    /** 生成する文の数 */
    private static final int NUM_SENTENCES = 10;
    /** 単語の遷移関係を保持するマップ */
    private Map<String, WordCounter2> transitionMap;
    /** 単語の出現回数を記録するカウンター */
    private WordCounter wordFrequency;

    /**
     * コンストラクタ
     */
    public Markov() {
        transitionMap = new HashMap<>();
        wordFrequency = new WordCounter();
    }

    /**
     * 単語を正規
     * @param word 正規化する単語
     * @return 正規化された単語
     */
    private String normalizeWord(String word) {
        return word.toLowerCase()
                  .replaceAll("[.!,?\"';:()/\\[\\]{}]", "")
                  .trim();
    }

    /**
     * テキストファイルを読み込んで遷移関係の構築
     * @param filename 入力ファイル名
     * @throws IOException ファイル読み込みエラー
     */
    public void buildTransitions(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String prevWord = null;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    
                    String normalizedWord = normalizeWord(word);
                    if (normalizedWord.isEmpty()) continue;

                    // 単語の出現回数をカウント
                    wordFrequency.add(normalizedWord);

                    // 前の単語が存在する場合、遷移関係を記録
                    if (prevWord != null) {
                        WordCounter2 counter = transitionMap.computeIfAbsent(
                            prevWord, k -> new WordCounter2());
                        counter.add(normalizedWord);
                    }
                    
                    prevWord = normalizedWord;
                }
            }
        }
    }

    /**
     * 最も出現頻度の高い単語を取得
     * @return 最頻出単語
     */
    private String getMostFrequentWord() {
        List<String> words = wordFrequency.getSortedWordList();
        return words.isEmpty() ? null : words.get(0);
    }

    /**
     *
     * 文を生成する
     * @return 生成された文
     */
    private List<String> generateSentence() {
        List<String> sentence = new ArrayList<>();
        String currentWord = getMostFrequentWord();
        
        sentence.add(currentWord);
        
        for (int i = 1; i < SENTENCE_LENGTH; i++) {
            WordCounter2 counter = transitionMap.get(currentWord);
            if (counter == null) break;
            
            String nextWord = counter.selectNextWord();
            if (nextWord == null) break;
            
            sentence.add(nextWord);
            currentWord = nextWord;
        }
        
        return sentence;
    }

    /**
     * メイン
     */
    public static void main(String[] args) {
        try {
            Markov markov = new Markov();
            markov.buildTransitions("alice.txt");

            // 指定回数の文を生成
            for (int i = 0; i < NUM_SENTENCES; i++) {
                List<String> sentence = markov.generateSentence();
                System.out.println(String.join(" ", sentence));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}