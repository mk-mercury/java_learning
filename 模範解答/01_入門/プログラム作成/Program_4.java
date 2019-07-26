package introduction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program_4 {
	public static void main(String[] args) throws Exception {

		// 入力用クラス
		Scanner stdin = new Scanner(System.in);

		// カードの情報の定義
		String[] card = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// カードを引くための乱数生成用クラス
		Random random = new Random();

		// 自分の情報保持変数
		int myScore = 0;
		ArrayList<String> myCard = new ArrayList<String>();

		// ディーラーの情報保持変数
		int yourScore = 0;
		ArrayList<String> yourCard = new ArrayList<String>();

		// 初期手札（２枚づつ）を配る
		for (int i = 0; i < 2; i++) {
			// 配るカード番号(index)
			int no;

			// 自分のカードi枚目
			// 乱数生成 0~12
			no = random.nextInt(13);
			System.out.println("あなたに「" + card[no] + "」が配られました。");
			// 自分の手札リストに追加
			myCard.add(card[no]);

			// ディーラーのカードi枚目
			no = random.nextInt(13);
			System.out.println("ディーラーに「" + card[no] + "」が配られました。");
			yourCard.add(card[no]);
		}
		System.out.println();

		// スコアの計算
		myScore = GetScore(myCard);
		yourScore = GetScore(yourCard);

		// 初期手札のスコアの表示
		System.out.println("ディーラーの合計は" + yourScore + "です。");
		System.out.println("現在の合計は" + myScore + "です。\n");

		// 自分のカードを引きます 21未満の時
		while (myScore < 21) {
			System.out.println("もう一枚カードを引きますか？(Y/N)\n");

			// 文字列受け取り (Y/N)
			if (stdin.next().equals("Y")) { // 文字列が同じかどうかは == を使わずに equals を使う

				// カードを引く
				int no = random.nextInt(13);
				System.out.println("あなたに「" + card[no] + "」が配られました。");
				myCard.add(card[no]);

				// スコアの計算
				myScore = GetScore(myCard);
				System.out.println("現在の合計は" + myScore + "です。\n");

			} else {
				// Nが入力
				break;
			}
		}

		// ディーラーがカードを引く（17以下の場合）
		while (yourScore <= 17) {

			// カードを引く
			int no = random.nextInt(13);
			System.out.println("ディーラーに「" + card[no] + "」が配られました。");
			yourCard.add(card[no]);

			// スコアの計算
			yourScore = GetScore(yourCard);
			System.out.println("ディーラーの合計は" + yourScore + "です。\n");
		}

		// 数字が大きい方が勝ち
		// バースト判定
		if (myScore > 21) {
			myScore = -1;
		}

		if (yourScore > 21) {
			yourScore = -1;
		}

		// 勝敗判定
		// ※スコアが大きい方が勝ち！(バーストは-1に強制的に書き換えているから)
		if (myScore > yourScore) {
			System.out.println("あなたの勝ちです。");
		} else if (myScore == yourScore) {
			System.out.println("引き分けです。");
		} else {
			System.out.println("あなたの負けです。");
		}

		// 終了処理を行う
		stdin.close();
	}

	// スコアの計算　リストに対するスコアを返す
	// 引　数：card     手札のカードを入れた配列
	// 戻り値：int      cardの手札の場合の点数
	static int GetScore(ArrayList<String> card) {

		// スコアの保持用変数
		int score = 0;
		// Aの保持用変数
		int count = 0;

		// 手札の枚数分ループ for(int i=0;i<card.size();i++)
		for (String str : card) {
			// カードのスコアを計算する
			switch (str) {
			case "A":
				// Aの場合は、一旦、11として加算する
				score += 11;
				// 21を超えた場合に A を 1 として計算できるように枚数を数えておく
				count++;
				break;
			case "J":
			case "Q":
			case "K":
				score += 10;
				break;
			default:
				// "2"〜"9"の場合
				// parseInt() は引数に文字列を受け取り、それを数値で返すメソッド
				score += Integer.parseInt(str);
			}
		}

		// Aが手札にある場合は、Aを1として計算できるのでその場合の処理
		// スコアが21より大きい場合
		while (score > 21) {
			if (count > 0) {
				// 11として数えていたAを1として数えたいので、差を引く(11-1=10)
				score -= 10;
				// 所持している「A」１枚分を計算し直したので「A」の数を減らす
				count--;
			} else {
				// 所持しているAを全て1として数えても21を超えている場合
				break;
			}
		}

		// スコアを返す
		return score;
	}
}
