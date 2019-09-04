/**
 * 優先度と文字列の値をもつクラス
 * 何を基準にソートを行うかをここで記述
 */
class Value_Priority{
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
}