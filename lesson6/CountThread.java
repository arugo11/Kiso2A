/**
 * カウンターに対して1万回の加算を行うスレッドクラス
 * @author AL23088 嶋中雄大
 * @file   CountThread.java
 */
class CountThread extends Thread {
    Counter counter;
    
    /**
     * コンストラクタ
     * @param counter カウンターオブジェクト
     */
    CountThread(Counter counter) {
        this.counter = counter;
    }
    
    /**
     * スレッドの実行内容
     * カウンターのcountUpメソッドを1万回callする
     */
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.countUp();
        }
    }
}