package programming;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 【入門編：プログラム作成】4 ブラックジャック回答
 * 【チャレンジ】後
 *
 *  2019/07/30修正
 *
 * @author 堤俊宏
 */
public class BlackJack {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		/**
		 * カード用配列
		 * インデックス番号0～12
		 */
		String [] card = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

		// ディーラーの手札用配列、点数用変数
		int comSum = 0;
		ArrayList<String> comHand = new ArrayList<String>();

		// プレイヤーの手札用配列、点数用変数
		int plSum = 0;
		ArrayList<String> plHand = new ArrayList<String>();

		//プレイヤーコイン初期値
		int coin = 100;

		//コインが一ゲーム分の掛け分が残って入れば繰り返す
		while(true) {

			//手札をクリア
			comHand.clear();
			plHand.clear();

			if(coin < 10) {
				System.out.println("あなたのコインがなくなりました。ゲーム終了です。");
				break;
			}

			System.out.println("あなたのコインは現在"+ coin + "枚です。\n");
			System.out.println("ゲーム一回分の賭けコイン 10 を徴収します。\n");
			coin -= 10;

			//初回のカードをディーラーとプレイヤーに二枚ずつ配る
			for(int i = 0;i < 2;i++) {

				int rdCard = rd.nextInt(13);
				String comCard = card[rdCard];

				comHand.add(comCard);

				int rdCard2 = rd.nextInt(13);
				String plCard = card[rdCard2];

				plHand.add(plCard);

				System.out.println("あなたに「" + plCard + "」が配られました。");
				System.out.println("ディーラーに「" + comCard + "」が配られました。");
			}

			// スコアの計算
			comSum = sumCalc(comHand);
			plSum = sumCalc(plHand);

			/**
			 * ブラックジャック判定
			 * 同じ21なら、ブラックジャックのほうが強い
			 */
			if((comHand.contains("A") && comHand.contains("J")) && (plHand.contains("A") && plHand.contains("J"))) {
				System.out.println("あなたとディーラーいずれもブラックジャック！ 引き分けです");
				coin += 10;
				continue ;
			}else if(comHand.contains("A") && comHand.contains("J")) {
				System.out.println("ディーラーのブラックジャック！ あなたの負けです。\n");
				continue ;
			}else if(plHand.contains("A") && plHand.contains("J")) {
				System.out.println("あなたのブラックジャック！ あなたの勝ちです。コイン + 30\n");
				coin += 30;
				continue ;
			}

			if((comSum == 21 && comHand.size() == 2) && (plSum == 21 && plHand.size() == 2)) {
				System.out.println("あなたとディーラーいずれもブラックジャック！ 引き分けです");
				coin += 10;
				continue ;
			}else if(plSum == 21 && plHand.size() == 2) {
				System.out.println("あなたのブラックジャック！ あなたの勝ちです。コイン + 30\n");
				coin += 30;
				continue ;
			}else if(comSum == 21 && comHand.size() == 2) {
				System.out.println("ディーラーのブラックジャック！ あなたの負けです。\n");
				continue ;
			}

			//最初に配られたカードの合計点数を表示
			System.out.println("ディーラーの合計は" + comSum + "です。");
			System.out.print("現在の合計は" + plSum + "です。");

			//プレイヤーが追加のカードを引くかどうか、引いた結果
			while(plSum < 21) {

				System.out.print("もう一枚カードを引きますか？(Y/N):\n");

				String yn = sc.next();
				String upper_yn = yn.toUpperCase();

				if(upper_yn.equals("Y")) {
					int rdCardAdd= rd.nextInt(13);
					String plCardAdd = card[rdCardAdd];
					System.out.println("あなたに" + plCardAdd + "が配られました");

					plHand.add(plCardAdd);

					plSum = sumCalc(plHand);

					System.out.println("現在の合計は" + plSum + "です。");

				}else if(upper_yn.equals("N")){
					break;

					//y(Y)、n(N)以外が入力された場合
				}else {
					System.out.println("YかNを入力してください");
				}
			}
			//プレイヤーのバースト時
			if(plSum > 21) {
				System.out.println("あなたのバースト！");
				System.out.println("\nあなたの負けです\n");
				continue ;
			}


			//ディーラーが追加のカードを引くか判定、引いた結果
			while(comSum <= 17) {

				int rdCardAdd2 = rd.nextInt(13);
				String comCardAdd = card[rdCardAdd2];
				System.out.println("\nディーラーに「" + comCardAdd + "」が配られました。");

				comHand.add(comCardAdd);

				comSum = sumCalc(comHand);

				System.out.println("ディーラーの合計は" + comSum + "です。");
			}
			//ディーラーのバースト時
			if(comSum > 21) {
				System.out.println("ディーラーのバースト！");
				System.out.println("\nあなたの勝ちです。コイン + 20\n");
				coin += 20;
				continue ;
			}

			//勝敗の判定
			if(comSum == plSum) {
				System.out.println("\n引き分けです。コイン + 10\n");
				coin += 10;
			}else if(comSum > plSum) {
				System.out.println("\nあなたの負けです");
			}else {
				System.out.println("\nあなたの勝ちです。コイン + 20");
				coin += 20;
			}
			System.out.println();
		}

		sc.close();
	}

	/**
	 * 点数計算メソッド
	 * @param カード
	 * @return 点数
	 */
	static int sumCalc(ArrayList<String> card) {

		//点数
		int point = 0;

		//A札の数
		int ace = 0;

		for (int i = 0; i < card.size(); i++) {
			if (card.get(i) == "A") {
				point += 11;
				ace++;
			} else if  (card.get(i) == "J") {
				point += 10;
			} else if  (card.get(i) == "Q") {
				point += 10;
			} else if  (card.get(i) == "K") {
				point += 10;
			}else {
				point += Integer.parseInt(card.get(i));
			}
		}

		//合計点数がバーストしてしまう場合、Aを1として扱う（11 - 10）
		while(point >= 22) {
			if(ace >= 1){
				point -= 10;
				ace--;
			}else {
				break;
			}
		}

		return point;
	}
}