package geam_5;

import java.util.Random;
import java.util.Scanner;

public class TrumpQuizEx {

	static Scanner scan;
	//----------------------------------------------

	public static void main(String[] args) {
		//スキャナ
		scan = new Scanner(System.in);
		//カードリスト
		String[] symbollist = { "ハート", "ダイヤ", "スペード", "クローバー" };
		String[] numlist = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		//選択カード
		int[] playercard = new int[2];
		//COMカード取得
		int[] comcard = get_card();

		//図柄当て
		System.out.println("トランプを選んだよ");
		System.out.println("トランプの図柄を当ててね");
		System.out.println();
		System.out.println("0:ハート");
		System.out.println("1:ダイヤ");
		System.out.println("2:スペード");
		System.out.println("3:クローバー");
		for (int i = 0; i < 2; i++) {
			//キー入力受付
			do {
				System.out.println("0,1,2,3を入力して下さい。");
				playercard[0] = getkey0();
			} while (playercard[0] < 0 || playercard[0] > 3);
			//正誤判定
			if (playercard[0] == comcard[0]) {
				System.out.println("正解！図柄は" + symbollist[comcard[0]] + "だよ");
				System.out.println("次は数字を当ててね");
				break;
			}
			System.out.println("残念！" + symbollist[playercard[0]] + "じゃないよ");
		}

		//数字当て
		if (playercard[0] == comcard[0]) {
			for (int i = 0; i < 4; i++) {
				do {
					System.out.println("2~10 の整数または A,J,Q,K を入力してください");
					playercard[1] = getkey1();
				} while (playercard[1] < 0 || playercard[1] > 12);
				//正誤判定
				if (playercard[1] == comcard[1]) {
					System.out.println("正解！" + symbollist[comcard[0]] + "の" + numlist[comcard[1]] + "だよ");
					break;
				}
				//ヒント
				if (playercard[1] < comcard[1]) {
					System.out.println("残念！" + numlist[playercard[1]] + "より大きい数字だよ");
				} else {
					System.out.println("残念！" + numlist[playercard[1]] + "より小さい数字だよ");
				}
			}
		}
		//ゲームオーバー
		if (playercard[0] != comcard[0] || playercard[1] != comcard[1]) {
			System.out.println("残念！ゲームオーバー。");
		}
		//終了処理
		scan.close();
	}

	//----------------------------------------------

	private static int[] get_card() {

		//乱数生成
		Random random = new Random();
		//カード決定
		int[] card = { random.nextInt(4), random.nextInt(13) };
		return card;
	}

	private static int getkey0() {
		//入力受付（図柄）
		System.out.println("どれだと思う？:");
		int key = 100;
		try {
			key = Integer.parseInt(scan.next());
		} catch (NumberFormatException e) {
			System.out.println("整数以外が入力されました。");
		}
		return key;
	}

	private static int getkey1() {
		//入力受付（数字）
		System.out.println("どれだと思う？:");
		int key = 100;
		String str = scan.next();
		//A,J,Q,K処理
		if (str.equals("A") || str.equals("1") || str.equals("１")) {
			return 0;
		} else if (str.equals("J") || str.equals("11") || str.equals("１１")) {
			return 10;
		} else if (str.equals("Q") || str.equals("12") || str.equals("１２")) {
			return 11;
		} else if (str.equals("K") || str.equals("13") || str.equals("１３")) {
			return 12;
		}
		try {
			key = Integer.parseInt(str) - 1;
		} catch (NumberFormatException e) {
			System.out.println("整数以外が入力されました。");
		}
		return key;
	}
}