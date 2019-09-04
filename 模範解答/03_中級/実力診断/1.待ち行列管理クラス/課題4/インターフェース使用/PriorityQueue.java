import java.util.ArrayList;
import java.util.Collections;

/**
 * 優先度によって値を取り出す順番を変更するPriorityキュークラス
 */
class PriorityQueue {
    // 値と優先度をフィールドにもつValue_Priorityクラスを格納するリストを生成。
    ArrayList<Value_Priority> list = new ArrayList<Value_Priority>();

    // コンストラクタ
    public PriorityQueue(){};

    //値を格納し優先度でソート
    public void push(String str,int priority) {
        //優先度と文字列を格納するクラスの生成
        Value_Priority val_pri = new Value_Priority(priority, str);

        list.add(val_pri);

        // リストの要素が2つ以上あるときにソートを行うよう以下の条件を記述
        if(list.size() > 1) {
			// 何を基準にソートを行うかは抽象クラスComparable<T>を継承したValue_Priorityクラスで記述
			Collections.sort(list);
        }
    }

    //値の出力
    public String pop() {
        String pop_str = " ";

        if(list.size() > 0) {
            pop_str = list.get(0).Getvalue();
            list.remove(0);
        }

        return pop_str;
    }
}