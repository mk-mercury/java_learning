import java.util.*;

// 課題2

public class Main {
    public static void main(String[] args) throws Exception {
        
        // ランキングクラスの初期化
        Ranking ranking = new Ranking();
        
        // スコアと名前を格納
        ranking.EntryScore(300, "name300");
        ranking.EntryScore(100, "name100");
        ranking.EntryScore(400, "name400");
        ranking.EntryScore(200, "name200");
        
        // 表示
        ranking.PrintRanking();
        
    }
}
