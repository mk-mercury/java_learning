import java.util.*;

// 課題1

public class Main {
    public static void main(String[] args) throws Exception {
        
        // ランキングクラスの初期化�
        Ranking ranking = new Ranking();
        
        // スコアをランキングクラスに格納�
        ranking.EntryScore(300);
        ranking.EntryScore(100);
        ranking.EntryScore(400);
        ranking.EntryScore(200);
        
        // 表示
        ranking.PrintRanking();
    }
}