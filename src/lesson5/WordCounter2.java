import java.util.*;

/**
 * WordCounterを拡張、マルコフ連鎖のための機能を追加
 */
class WordCounter2 extends WordCounter {
    /**
     * 単語の総出現回数
     */
    private int totalCount;

    /**
     * コンストラクタ
     */
    public WordCounter2() {
        super();
        totalCount = 0;
    }

    /**
     * 単語を追加
     * @param word 追加する単語
     */
    @Override
    public void add(String word) {
        super.add(word);
        totalCount++;
    }

    /**
     * 出現確率に基づいて次の単語を選択
     * @return 選択された単語
     */
    public String selectNextWord() {
        if (totalCount == 0) {
            return null;
        }

        Random random = new Random();
        int value = random.nextInt(totalCount) + 1;
        int sum = 0;

        // 累積確率に基づいて単語を選択
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            sum += entry.getValue();
            if (value <= sum) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 総出現回数を取得する
     * @return 総出現回数
     */
    public int getTotalCount() {
        return totalCount;
    }
}