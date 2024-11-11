package my_util;
import java.util.*;

/**
 * リストの生成、反転、最大値の取得、総和の計算をする
 */
public class ListUtil {
    /**
     * 指定された範囲の連続する整数からなるリストを生成する。
     * 
     * @param start 開始
     * @param end 終了
     * @return startからendまでの連続した整数を要素とするリスト
     */
    public static List<Integer> makeIntList(int start, int end) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * 1から指定された値までの連続する整数からなるリストを生成する。
     * @param n 終了
     * @return 1からnまでの連続した整数を要素とするリスト
     */
    public static List<Integer> makeIntList(int n) {
        return makeIntList(1, n);
    }

    /**
     * 与えられたリストの内容を反転した新しいリストを生成する。
     * 
     * @param list 反転対象のリスト
     * @return 要素が反転された新しいリスト
     */
    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    /**
     * リストの要素の中から最大値を求める。
     * 
     * @param list 対象のリスト
     * @return リスト内の最大値
     */
    public static int max(List<Integer> list) {
        int maxValue = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue) {
                maxValue = list.get(i);
            }
        }
        return maxValue;
    }

    /**
     * リストの全要素の総和を計算する。
     * 
     * @param list 対象のリスト
     * @return リスト内の全要素の合計値
     */
    public static int sum(List<Integer> list) {
        int total = 0;
        for (Integer value : list) {
            total += value;
        }
        return total;
    }
}