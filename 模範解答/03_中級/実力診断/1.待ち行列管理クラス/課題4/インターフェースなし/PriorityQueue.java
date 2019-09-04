import java.util.ArrayList;

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

    }

    //値の出力
    public String pop() {

    	// 優先度を格納する変数
    	int max = 0;
    	// 優先度が一番高いものがListの何番目かを格納する変数
    	int index = 0;
    	// 何回目のループかを格納する変数
		int counter =  0;

    	for (Value_Priority valuePriority : list)
    	{
    		//優先度が高いものがListの何番目に入っているか検索する
    		if(max < valuePriority.Getpriority())
    		{
    			max = valuePriority.Getpriority();
    			index = counter;
    		}

    		counter++;
    	}

    	// 優先度が一番高い値を取得する
    	Value_Priority popView = list.get(index);
    	// 取得したものをリストから削除する
    	list.remove(index);

    	return popView.Getvalue();
    }
}