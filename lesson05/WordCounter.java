import java.util.*;

/**
 * 単語の出現回数をカウントするクラス
 */
class WordCounter {
    /**
     * 単語に出現回数を対応付ける写像
     */
    Map<String, Integer> countMap;

    /**
     * コンストラクタ：カウンタの初期化
     */
    public WordCounter() {
        countMap = new HashMap<String, Integer>();
    }

    /**
     * 単語の出現情報を1回分追加
     * 
     * @param word カウントする単語
     */
    public void add(String word) {
        Integer count = countMap.get(word);
        if (count != null) { // マップに登録済み（最低1回は出現済み）の場合は
            int newCount = count.intValue() + 1; // 記録されている回数をインクリメント
            countMap.put(word, newCount); // マップに上書き登録する
        } else { // 今まで出現していない単語の場合は
            countMap.put(word, 1); // マップに出現回数1を登録
        }
    }

    /**
     * 単語の出現回数を返す
     * 
     * @param word 検索する単語
     * @return 単語の出現回数
     */
    public int getNumber(String word) {
        Integer count = countMap.get(word);
        if (count != null) {
            return count.intValue();
        } else {
            return 0;
        }
    }

    /**
     * 出現した単語のリストを作って返す
     * 
     * @return 出現した単語のリスト
     */
    public List<String> getWordList() {
        return new ArrayList<String>(countMap.keySet());
    }

    /**
     * 出現回数順にオブジェクトをソートしたリストを作って返す
     * 
     * @return 出現回数の降順でソートされた単語のリスト
     */
    public List<String> getSortedWordList() {
        List<String> wordList = getWordList();
        Collections.sort(wordList, new Comparator<String>() {
            public int compare(String word1, String word2) { // 比較基準の定義
                return countMap.get(word2) - countMap.get(word1);
            }
        });
        return wordList;
    }
}