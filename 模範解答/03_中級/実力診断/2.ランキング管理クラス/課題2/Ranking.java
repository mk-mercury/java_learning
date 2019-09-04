import java.util.*;

/**
 * ランキングを管理するクラス
 */
class Ranking {
    /** 得点と名前をフィールドに持つScoreクラスを格納しておくリスト */
    ArrayList<Score> _scorelist = new ArrayList<Score>();
    
    // コンストラクタ
    /**
     * ランキングを管理するクラス
     */
    public Ranking(){}
    
    /**
     * 得点と名前を格納するメソッド
     * @param point 得点
     * @param name 名前
     */
    public void EntryScore(int point, String name) {
        // 得点と名前を格納するScoreクラスをインスタンス化
        Score score = new Score(point,name);
        
        // スコアクラスをリストに格納
        _scorelist.add(score);
        
        // スコアを降順になるようにソート
        if(_scorelist.size() > 1) {
            Collections.sort(_scorelist, Comparator.reverseOrder());
        }
    }
    
    /**
     * ランキングを表示するメソッド
     */
    public void PrintRanking() {
        for(int i = 0; i < _scorelist.size(); i++) {
            System.out.println(String.valueOf(i+1) + "位:" + _scorelist.get(i).Getname() + " " + String.valueOf(_scorelist.get(i).Getpoint()));
        }
    }
}