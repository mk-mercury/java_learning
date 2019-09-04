import java.util.*;

// 課題1

/**
 * ランキングを管理するクラス
 */
class Ranking {
    /** 得点を格納しておくリスト */
    ArrayList<Integer> _scorelist = new ArrayList<Integer>();
    
    /**
     * ランキングを管理するクラス
     */
    public Ranking(){}
    
    /**
     * 得点と名前を格納するメソッド
     * @param point 得点
     */
    public void EntryScore(int point) {
        // スコアクラスをリストに格納
        _scorelist.add(point);
        
        // スコアを降順になるようにソート
        // Collections.reverseOrder()で降順、何も指定しなければ昇順
        // ソートするなら比較するものがないといけないのでリストのサイズが1以上としている
        if(_scorelist.size() > 1) {
            Collections.sort(_scorelist, Collections.reverseOrder());
        }
    }
    
    /**
     * ランキングを表示するメソッド
     */
    public void PrintRanking() {
        for(int i = 0; i < _scorelist.size(); i++) {
            System.out.println(String.valueOf(i+1) + "位:" + String.valueOf(_scorelist.get(i)));
        }
    }
}