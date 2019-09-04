package introduction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program_4 {

	public static void main(String[] args) throws Exception {

		// キーボード入力の準備をする
		Scanner stdin = new Scanner(System.in);

		// 文字列の配列を用意して A～K までのカードを入れる
		String[] card = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		// カードを引くためのランダムクラスの準備
		Random random = new Random();

		// 自分のスコアを記憶するための変数 myScore を用意する
		int myScore = 0;
		// 自分の手札を記憶するためのArrayList myCard を用意する
		ArrayList<String> myCard = new ArrayList<String>();

		// ディーラーのスコア記憶するための変数 dealerScore を用意する
		int dealerScore = 0;
		// ディーラーの手札を記憶するためのArrayList dealerCard を用意する
		ArrayList<String> dealerCard = new ArrayList<String>();

		// 初期手札としてカードを2回配るのでforを使う
		for (int i = 0; i < 2; i++) {
			// 配られたカードをArrayListに追加するための要素番号(index)を用意する
			int no;

			// 自分のカードがi枚目の時の処理をする
			// A～Kのカードの要素番号(0～12)をランダムに決定する
			no = random.nextInt(13);
			System.out.println("あなたに「" + card[no] + "」が配られました。");
			// 自分の手札をArrayList myCard に追加する
			myCard.add(card[no]);

			// ディーラーのカードがi枚目の時の処理をする
			// A～Kのカードの要素番号(0～12)をランダムに決定する
			no = random.nextInt(13);
			System.out.println("ディーラーに「" + card[no] + "」が配られました。");
			// ディーラーの手札をArrayList yorCard に追加する
		}
		System.out.println();

		// スコアの計算をするメソッド GetScore に手札のArrayListのデータを渡してスコアを計算する
		myScore = GetScore(myCard);
		dealerScore = GetScore(dealerCard);

		// メソッド GetScore で計算した初期手札のスコアの表示をする
		System.out.println("ディーラーの合計は" + dealerScore + "です。");
		System.out.println("現在の合計は" + myScore + "です。\n");

		// 自分のスコアが21未満の時にカードを引くか選ばせる
		while (myScore < 21) {
			System.out.println("もう一枚カードを引きますか？(Y/N)\n");

			// カードを引くかどうかの文字列を入力させる (Y/N)
			// 検索キーワード：「Java 文字列 比較」
			if (stdin.next().equals("Y")) { // 文字列が同じかどうかは == を使わずに equals を使う

				// ランダムにカードを決定して自分の手札を myCard に追加する
				int no = random.nextInt(13);
				System.out.println("あなたに「" + card[no] + "」が配られました。");
				myCard.add(card[no]);

				// GetScore に myCardのデータを渡して自分のスコア計算をする
				myScore = GetScore(myCard);
				System.out.println("現在の合計は" + myScore + "です。\n");

			} else {
				// Nが入力された場合はwhile文から抜け出す
				break;
			}
		}

		// ディーラーのスコアが17以下の場合カードを引く
		while (dealerScore <= 17) {

			// ランダムにカードを決定して自分の手札を myCard に追加する
			int no = random.nextInt(13);
			System.out.println("ディーラーに「" + card[no] + "」が配られました。");
			dealerCard.add(card[no]);

			// GetScore に dealerCard を渡してディーラーのスコア計算をする
			dealerScore = GetScore(dealerCard);
			System.out.println("ディーラーの合計は" + dealerScore + "です。\n");
		}

		// カードが引き終わったらスコアの判定を行う
		// バーストしているかどうかの判定をする
		// スコアが21の場合スコアに-1を代入して絶対に勝たないようにする
		if (myScore > 21) {
			myScore = -1;
		}

		if (dealerScore > 21) {
			dealerScore = -1;
		}

		// どちらが勝ったのか勝敗の判定をする
		// ※スコアが大きい方が勝ち！(バーストは-1に強制的に書き換えているから)
		if (myScore > dealerScore) {
			System.out.println("あなたの勝ちです。");
		} else if (myScore == dealerScore) {
			System.out.println("引き分けです。");
		} else {
			System.out.println("あなたの負けです。");
		}

		// 終了処理を行う
		stdin.close();
	}

	// スコアの計算　リストに対するスコアを返す
	// 引　数：card     手札のカードを入れたリスト
	// 戻り値：int      cardの手札の場合の点数
	static int GetScore(ArrayList<String> card) {

		// 手札のスコアを記憶する変数scoreを用意する
		int score = 0;
		// スコアが21を超えた時のためにAの数を記憶する変数countを用意する
		int count = 0;

		// 手札の枚数分だけ同じ処理をしたいのでforを使う
		// 検索キーワード：「Java 拡張for文」
		// for文を簡単に使えるようにした拡張for文 for(int i=0;i<card.size();i++)
		for (String str : card) {
			// 手札のカードのスコアを計算する
			// 検索キーワード：「Java 条件分岐 同じ動作 複数」
			// カードの文字列によって違う処理をするためswitch-case文で条件分岐させる
			switch (str) {
			case "A":
				// Aの場合は、一旦、11として加算する
				score += 11;
				// スコアが21を超えた場合に A を 1 として計算できるように枚数を数えておく
				count++;
				break;
			case "J":
			case "Q":
			case "K":
				// J Q K の場合は、10を加算する
				score += 10;
				break;
			default:
				// "2"〜"9"の場合、条件分岐させると複雑になるので、文字列を数値に変換して加算する
				// parseInt() は引数に文字列を受け取り、それを数値で返すメソッド
				score += Integer.parseInt(str);
			}
		}

		// Aが手札にある場合は、Aを1として計算できるのでその場合の処理
		// スコアが21より大きい場合のみ行う
		// Aの数は引いたカードの内容によって変わるのでwhileを使う
		while (score > 21) {
			// 永久に点数を引き続けないように、Aの枚数分だけ繰り返すようにifで条件分岐させる
			if (count > 0) {
				// 11として数えていたAを1として数えたいので、差を引く(11-1=10)
				score -= 10;
				// 所持している「A」１枚分を計算し直したので「A」の数を減らす
				count--;
			} else {
				// 所持しているAを全て1として数えても21を超えている場合while文を抜け出す
				break;
			}
		}

		// スコアを返す
		return score;
	}

}
