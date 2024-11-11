import java.io.*;
import java.util.*;

/**
 * テキストファイル内の単語出現回数をカウントするプログラム
 */
class Test05C {
    /**
     * 単語を正規化する（小文字化し、記号を除去する）
     * @param word 正規化する単語
     * @return 正規化された単語
     */
    private static String normalizeWord(String word) {
        // 小文字に変換し、記号を除去
        return word.toLowerCase()
                  .replaceAll("[.!,?\"';:()/\\[\\]{}]", "")
                  .trim();
    }

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        try (BufferedReader br = new BufferedReader(
                new FileReader("alice.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                // 行を単語に分割
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // 空の単語をスキップ
                    if (word.isEmpty()) {
                        continue;
                    }
                    
                    // 単語を正規化して追加
                    String normalizedWord = normalizeWord(word);
                    if (!normalizedWord.isEmpty()) {
                        counter.add(normalizedWord);
                    }
                }
            }

            // 出現回数でソートされた単語リストを取得
            List<String> wordList = counter.getSortedWordList();
            
            // 上位20単語までを出力
            int limit = Math.min(20, wordList.size());
            for (int i = 0; i < limit; i++) {
                String word = wordList.get(i);
                System.out.printf("%4d\t%s%n", 
                    counter.getNumber(word), word);
            }

        } catch (IOException e) {
            System.err.println("ファイル読み込みエラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}