/**
 * 優先度と文字列の値をもつクラス
 * 何を基準にソートを行うかをここで記述
 */


// インターフェース（Comparable<T>）を実装する事でソートを簡単に行えるようにしている
class Value_Priority implements Comparable<Value_Priority> {
    /** 優先度 */
    private int _priority;
    /** 文字列の値 */
    private String _value;

    // コンストラクタ
    public Value_Priority(int pri, String val) {
        _priority = pri;
        _value = val;
    }

    // getter
    public int Getpriority() {
        return _priority;
    }

    // getter
    public String Getvalue() {
        return _value;
    }

    // setter
    public void Setpriority(int pri) {
        _priority = pri;
    }

    // setter
    public void Setvalue(String val) {
        _value = val;
    }

    // ここで優先度を基準にソートを行うことを記述
    // Comparableを継承しているためこのメソッドの記述がないとエラーになる
    public int compareTo(Value_Priority value_priority) {

		//このインスタンスが、compareToの引数として渡されたObjectより小さい(前に並ぶ)なら正の値、
		//このインスタンスが、compareToの引数として渡されたObjectより大きい(後ろに並ぶ)なら負の値を返す。
		//同じなら、0を返す
		if(this._priority > value_priority.Getpriority()){
			return -1;
		}else if(this._priority < value_priority.Getpriority()){
			return 1;
		}else{
			return 0;
		}
  }
}