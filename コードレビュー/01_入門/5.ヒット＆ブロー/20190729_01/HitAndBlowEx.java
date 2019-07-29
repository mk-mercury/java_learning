package geam_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HitAndBlowEx {

	//クラス変数
	static Scanner scan;

	//------------------------------------------------

	public static void main(String[] args) {

		//スキャナ
		scan = new Scanner(System.in);
		//リスト
		ArrayList<Integer> numlist;
		ArrayList<Integer> keylist;
		//カウンター
		int count = 0;
		int hint_count = 0;
		//終了判定フラグ
		int flg = 0;

		//乱数取得
		numlist = random_num();

		//while: キー入力＆判定処理
		while (flg == 0) {

			//do-while: キー入力受付
			do {
				keylist = key();
			} while (keylist == null);

			//カウンターUP
			count++;
			//照合 & 終了判定
			flg = collation(numlist, keylist, count);
			//3周ごとにヒント出力
			if (flg == 0 && count % 3 == 0) {

				hint_count++;
				hint(hint_count, numlist);
			}
		}
		//終了処理
		scan.close();
	}

	//------------------------------------------------

	public static ArrayList<Integer> random_num() {

		//リスト生成
		ArrayList<Integer> numlist = new ArrayList<Integer>();
		//5桁乱数生成
		for (int i = 0; i < 10; i++) {
			numlist.add(i);
		}
		Collections.shuffle(numlist);
		for (int i = 9; i > 4; i--) {
			numlist.remove(i);
		}
		return numlist;
	}

	private static ArrayList<Integer> key() {

		//リスト生成
		ArrayList<Integer> keylist = new ArrayList<Integer>();
		//キー入力受付
		System.out.println("被らない数字を5桁入力してください");
		String str = scan.next();
		//桁数チェック
		if (str.length() < 5 || str.length() > 5) {
			System.out.println("Sorry. Input point (10000-99999).");
			return null;
		}
		//for: 被りチェック
		for (int i = 0; i < str.length(); i++) {
			try {

				int key = Integer.parseInt(String.valueOf(str.charAt(i)));

				//被りチェック
				for (int n = 0; n < keylist.size(); n++) {
					if (keylist.get(n) == key) {
						System.out.println("同じ数字が含まれています");
						return null;
					}
				}
				//リストに追加
				keylist.add(key);

			} catch (NumberFormatException e) {
				System.out.println("整数以外が入力されました");
				return null;
			}
		}
		return keylist;
	}

	private static int collation(ArrayList<Integer> numlist, ArrayList<Integer> keylist, int count) {

		int hit = 0;
		int blow = 0;

		//ヒットのカウント
		for (int i = 0; i < numlist.size(); i++) {
			if (numlist.get(i) == keylist.get(i)) {
				hit++;
			}
		}
		//ブローのカウント
		for (int i = 0; i < numlist.size(); i++) {
			for (int n = 0; n < keylist.size(); n++) {
				if (numlist.get(0) == keylist.get(n)) {
					blow++;
				}
			}
		}
		blow -= hit;
		//終了判定
		if (hit == 5) {
			System.out.println("おめでとう！" + count + "回目で成功♪");
			return 1;
		} else {
			System.out.println("ヒット：" + hit + "個、" + "ブロー：" + blow + "個");
			return 0;
		}
	}

	private static void hint(int hint_count, ArrayList<Integer> numlist) {

		System.out.print("ヒント：");

		for (int i = 0; i < hint_count; i++) {
			System.out.print(numlist.get(i));
		}
		System.out.println();
	}
}
