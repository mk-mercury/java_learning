package geam_4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJackEx {

	//クラス変数
	static Scanner scan;

	//-----------------------------------------------------------

	public static void main(String[] args) {

		//スキャナ
		scan = new Scanner(System.in);
		//コイン
		int coin = 100;
		//while:10まいずつ賭ける
		while (coin >= 10) {
			//ベット
			System.out.println("コインのこり" + coin + "枚");
			System.out.println("コインを10枚賭けました。" + coin + "枚 → " + (coin - 10) + "枚");
			System.out.println();
			coin -= 10;
			//所持カードリスト＆スコア（プレイヤー）
			ArrayList<String> playercard = new ArrayList<String>();
			int myScore = 0;
			//所持カードリスト＆スコア（COM）
			ArrayList<String> comcard = new ArrayList<String>();
			int comScore = 0;
			//初期手札取得(2枚)
			for (int i = 0; i < 2; i++) {
				playercard.add(getcard("あなた"));
				comcard.add(getcard("ディーラー"));
			}
			//初手計算
			comScore = cardsum(comcard, "ディーラー");
			myScore = cardsum(playercard, "現在");
			//継続確認(プレイヤー)
			while (myScore < 21) {

				//カードを引く
				if (getkey().equals("Y")) {
					playercard.add(getcard("あなた"));
				} else {
					break;
				}
				//手札計算
				myScore = cardsum(playercard, "現在");
			}
			//継続確認(COM)
			while (comScore <= 17 && myScore <= 21) {
				//カードを引く
				comcard.add(getcard("ディーラー"));
				//手札計算
				comScore = cardsum(comcard, "ディーラー");
			}
			//ブラックジャック判定
			int blackjackFlg = blackjack(myScore, comScore, playercard.size(), comcard.size());
			//結果
			if (myScore > 21) {
				System.out.println("バースト!あなたの負けです。");
			} else if (comScore > 21) {
				coin += 20;
				System.out.println("バースト!あなたの勝ちです。");
			} else if (myScore < comScore || blackjackFlg == 2) {
				System.out.println("あなたの負けです。");
			} else if (myScore > comScore || blackjackFlg == 1) {
				if (blackjackFlg == 1) {
					coin += 30;
				} else {
					coin += 20;
				}
				System.out.println("あなたの勝ちです。");
			} else {
				coin += 10;
				System.out.println("引き分けです。");
			}
			System.out.println();
		}
		//終了処理
		System.out.println("コインが無くなりました");
		scan.close();
	}

	//-----------------------------------------------------------

	private static String getkey() {
		while (true) {
			System.out.println();
			System.out.println("もう１枚カードを引きますか？(Y/N) :");
			String yn = scan.next();

			if (yn.equals("Y")) {
				return "Y";
			} else if (yn.equals("N")) {
				return "N";
			} else {
				System.out.println("error: YまたはNを入力してください。");
			}
		}
	}

	private static String getcard(String turnplayer) {
		//カード
		String[] cardlist = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		//乱数生成
		Random random = new Random();
		//カード取得
		String card = cardlist[random.nextInt(13)];
		System.out.println(turnplayer + "に「" + card + "」が配られました");

		return card;
	}

	private static int cardsum(ArrayList<String> cardlist, String turnplayer) {

		//計算
		int sum = 0;
		int a = 0;
		//for: Aを除いた計算
		for (int i = 0; i < cardlist.size(); i++) {
			if (cardlist.get(i).equals("J") || cardlist.get(i).equals("Q") || cardlist.get(i).equals("K")) {

				sum += 10;
			} else if (cardlist.get(i).equals("A")) {
				a++;
			} else {
				try {
					sum += Integer.parseInt(cardlist.get(i));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}
		//for: Aのみ計算
		for (int i = 0; i < a; i++) {
			if (sum <= 10) {
				sum += 11;
			} else {
				sum++;
			}
		}
		System.out.println(turnplayer + "の合計は" + sum + "です。");
		return sum;
	}

	private static int blackjack(int myScore, int comScore, int mysize, int comsize) {

		if ((myScore == 21 && mysize == 2) || (comScore == 21 && comsize == 2)) {
			System.out.println("ブラックジャック！");
			if (myScore == 21 && mysize == 2) {
				return 1;
			} else {
				return 2;
			}
		} else if ((myScore == 21 && mysize == 2) && (comScore == 21 && comsize == 2)) {
			System.out.println("両プレイヤーブラックジャック！");
		}
		return 0;
	}
}
