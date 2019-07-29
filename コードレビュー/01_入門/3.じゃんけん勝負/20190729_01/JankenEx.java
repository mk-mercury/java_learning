package geam_2;

import java.util.Random;
import java.util.Scanner;

public class JankenEx {

	//クラス変数
	static Scanner scan;
	static int win;
	static int losing;

	//---------------------------------------------------

	public static void main(String[] args) {

		//スキャナ
		scan = new Scanner(System.in);

		System.out.println("あっちむいてほい");
		System.out.println("３回勝負だよ！");
		System.out.println("グーチョキパーを数字で入力してね");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		System.out.println();

		for (int i = 0; i < 3; i++) {

			//判定フラグ 0:じゃんけん  1:あいこ 2,3:あっちむいてほい 4:結果
			int flg = 0;

			while (flg == 0) {

				do {
					//入力受付（じゃんけん）
					int key = key(flg);
					//じゃんけん結果
					flg = collation(key);
				} while (flg == 1);

				//入力受付（あっちむいてほい）
				int key2 = hoi_key(flg);
				//あっちむいてほい結果
				flg = hoi_collation(key2, flg);
			}
		}
		//総合結果
		System.out.println("■結果");
		System.out.println(win + "勝" + losing + "敗");
		//終了処理
		scan.close();
	}

	//---------------------------------------------------

	private static int key(int flg) {

		//入力キー
		int key012 = 0;

		while (true) {

			switch (flg) {
			case 0:
				System.out.println("最初はぐー、じゃんけん:");
				break;
			case 1:
				System.out.println("あいこで：");
				break;
			}

			//try-catch: キー入力受付
			try {

				String str = scan.next();
				key012 = Integer.parseInt(str);

				if (key012 < 0 || key012 > 2) {
					System.out.println("0,1,2を入力してください");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("整数以外が入力されました");
				continue;
			}
			return key012;
		}
	}

	private static int hoi_key(int flg) {

		//入力キー
		int key0123 = 0;

		while (true) {

			switch (flg) {
			case 2:
				System.out.println("プレイヤーが当てるよ！");
				break;
			case 3:
				System.out.println("COMが当てるよ！");
				break;
			}

			System.out.println("0:右");
			System.out.println("1:左");
			System.out.println("2:上");
			System.out.println("3:下");
			System.out.println();
			System.out.println("あっちむいてほい！：");

			//try-catch: キー入力受付
			try {
				String str = scan.next();
				key0123 = Integer.parseInt(str);

				if (key0123 < 0 || key0123 > 3) {
					System.out.println("0,1,2,3を入力してください");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("整数以外が入力されました");
				continue;
			}
			return key0123;
		}
	}

	private static int collation(int key) {

		//リスト生成
		String[] list = { "グー", "チョキ", "パー" };
		//乱数生成(じゃんけん)
		Random random = new Random();
		//乱数取得(じゃんけん)
		int num = random.nextInt(3);

		System.out.println(list[num] + "(COM)と" + list[key] + "(Player)で…");

		if (key == num) {
			System.out.println("あいこだよ！");
			return 1;
		} else if ((num - key) == 1 || (num - key) == -2) {
			System.out.println("あなたの勝ち");
			return 2;
		} else {
			System.out.println("あなたの負け");
			return 3;
		}
	}

	private static int hoi_collation(int key2, int flg) {

		//リスト生成
		String[] list_hoi = { "右", "左", "上", "下" };
		//乱数生成（あっちむいてほい）
		//乱数生成(じゃんけん)
		Random random = new Random();
		//乱数取得
		int num2 = random.nextInt(4);

		System.out.println("(COM)" + list_hoi[num2] + "(Player)" + list_hoi[key2] + "で…");

		if (key2 == num2) {

			if (flg == 2) {
				win++;
				System.out.println("あたり！プレイヤーの勝ち！");
				return 4;
			} else if (flg == 3) {
				losing++;
				System.out.println("あたり！ＣＯＭの勝ち！");
				return 4;
			}
		}
		System.out.println("はずれ！もう一度じゃんけんするよ");
		return 0;
	}
}
