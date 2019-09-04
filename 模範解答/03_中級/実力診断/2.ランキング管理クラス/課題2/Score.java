import java.util.*;


/**
 * 得点と名前をもつScoreクラス
 */
class Score implements Comparable<Score> {
   
    /** 得点 */ 
    private int _point;
    /** 名前 */
    private String _name;
    
    // コンストラクタ
    /**
     * 得点と名前をもつScoreクラス
     * @param point 得点
     * @param name 名前
     */
    public Score(int point, String name) {
        this._point = point;
        this._name = name;
    }
    
    // getter
    /**
     * 得点
     * @return 得点
     */
    public int Getpoint() {
        return this._point;
    }
    
    /**
     * 名前
     * @return 名前
     */
    public String Getname() {
        return this._name;
    }
    
    // setter
    /**
     * 得点
     * @param point 得点
     */
    public void Setpoint(int point) {
        this._point = point;
    }
    
    /**
     * 名前
     * @param name 名前
     */
    public void Setname(String name) {
        this._name = name;
    }
    
    /**
     * 比較を行うメソッド
     * @param score 比較対象
     * 得点の比較を行う
     */
    @Override
    public int compareTo(Score score) {
        //このインスタンスが、compareToの引数として渡されたObjectより大きい(後ろに並ぶ)なら正の値、
        //このインスタンスが、compareToの引数として渡されたObjectより小さい(前に並ぶ)なら負の値を返す。
        //同じなら、0を返せばよい。
        if(this._point < score.Getpoint()){ 
          return -1; 
        }else if(this._point > score.Getpoint()){
          return 1;
        }else{
          return 0;
        }
    }
    
}