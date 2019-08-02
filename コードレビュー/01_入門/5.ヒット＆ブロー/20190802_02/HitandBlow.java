package programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 【入門編：プログラム作成】5 ヒットアンドブロー回答
 * 【チャレンジ】後
 *
 *  2019/08/01
 *
 * @author 堤俊宏
 */
public class HitandBlow {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		//ヒットアンドブロー用リスト
		ArrayList<Integer> comHitblow = new ArrayList<Integer>();

		ArrayList<Integer> plHitblow = new ArrayList<Integer>();

		//回答の桁数
		int digits = 5;

		//ヒット、ブロー、回数カウント用変数
		int hit = 0;
		int blow = 0;
		int count = 0;

		//ヒント用リスト
		ArrayList<Integer> hintArray = new ArrayList<Integer>();

		//ヒント用変数
		int hint = 0;
		int hintCount = 0;

		//ゲームの答えを決定
		int i = 0;
		while(i < digits) {
			int comNumber = rd.nextInt(10);

			//答えの重複チェック。重複したら、答えのリストに数字を加えずやり直し
			if(comHitblow.contains(comNumber)) {
				continue;
			}
			comHitblow.add(i,comNumber);
			i++;
		}

		//プレイヤーが正解するまでループ
		while(true) {

			//回答3回ごとにヒント
			if(count != 0 && count % 3 == 0) {
				while(true) {
					int hintNum = rd.nextInt(digits);

					hint = comHitblow.get(hintNum);

					//ヒントをすべて出した後は、何も表示しない
					if(hintArray.size() == digits){
						break;
						//すでに出ているヒントの数字は、二度出さない
					}else if(hintArray.contains(hint)){
						continue;
					}else {
						System.out.println("ヒントです。\n使われている数字の一つは" + hint + "だよ\n");
						hintArray.add(hintCount,hint);
						break;
					}
				}
				hintCount++;
			}

			//プレイヤーの回答
			System.out.println(digits + "桁の数字を入力してください。");

			/**
			 * int型の入力だと、先頭の入力が0の場合無視され、
			 * また桁数が足りない場合、先頭が0扱いされるので、
			 * String型で入力→数値に変換の方式で入力を処理
			 */
			String plAns = sc.next();

			System.out.println("あなたの回答は" + plAns +"です");

			//入力された文字列をチェック
			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher match = p.matcher(plAns);

			if(plAns.length() != digits) {
				System.out.println("桁数があっていません");
				continue;
			}else if(match.find() == false){
				System.out.println("数字以外が含まれています");
				continue;
			}

			//文字列を分割、プレイヤー回答用リストに数値に変換して入れる
			String[] strAns = (plAns.split(""));

			for(int n = 0;n < strAns.length;n++) {
				int plNumber = Integer.parseInt(strAns[n]);
				plHitblow.add(n,plNumber);
			}

			//回答の重複チェック
			boolean ans = (plHitblow.size() == new HashSet<>(plHitblow).size());
			if(ans != true) {
				System.out.println("入力した数に重複があります。同じ数字は2回以上、使いません");
				plHitblow.clear();
				continue;
			}

			//ヒット数判定。要素の数字とインデックスが同じならヒットを加算
			for(int k = 0;k < digits;k++) {
				if(comHitblow.get(k) == plHitblow.get(k)) {
					hit++;
				}else {
					//ブロー数判定。ヒットになる場合以外で、要素だけが同じならブローを加算
					for(int l = 0;l < digits;l++) {
						if(comHitblow.get(k) == plHitblow.get(l)) {
							blow++;
						}
					}
				}
			}

			//回答数加算
			count++;

			//正解時
			if(hit == digits) {
				System.out.println("おめでとう！" + count + "回目で成功♪");
				break;
			}

			//不正解時、ヒットとブローの数を表示
			System.out.println("ヒット:" + hit + "個、" + " ブロー:" + blow + "個\n");

			//不正解時、プレイヤーの入力値、ヒットとブローの数をクリアして最初に戻る
			plHitblow.clear();
			hit = 0;
			blow = 0;
		}
		sc.close();
	}
}