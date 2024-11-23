/**
 * カウンターを管理するクラス
 * 複数スレッドからの同期的なアクセスに対応
 * @author AL23088 嶋中雄大
 * @file   Counter.java
 */
class Counter {
    int count = 0;
    synchronized void countUp() {
        count += 1;
    }
    /**
     * 現在のカウント値を取得
     * @return 現在のカウント値
     */
    int getCount() {
        return count;
    }
}