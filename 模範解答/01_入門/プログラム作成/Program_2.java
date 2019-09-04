package introduction;

import java.util.Random;
import java.util.Scanner;

public class Program_2 {
	public static void main(String[] args) {
		//図柄の配列を用意して図柄を設定する
		String[] mark = { "ハート","ダイヤ","スペード","クローバー"};

		//数字の配列を用意して初期値にA～Kを設定する
		String[] number = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

		//ランダムクラスの準備をする
		Random random = new Random();
		//入力する準備をする
		Scanner stdin = new Scanner(System.in);

		//図柄の答えの要素番号(0～3)をランダムで決める
		int markRam = random.nextInt(4);
		//数字の答えの要素番号(0～12)をランダムで決める
		int numberRam = random.nextInt(13);

		//トランプを選んだよ
		//トランプの図柄を当ててね
		//と表示する
		System.out.println("トランプを選んだよ\nトランプの図柄を当ててね\n");
		//0:ハート
		//1:ダイヤ
		//2:スペード
		//3:クローバー
		//と表示する
		System.out.print("0:ハート\n1:ダイヤ\n2:スペード\n3:クローバー\n");

		//図柄を当てさせる
		//while(true)で無限ループを生成し、回答番号があっている場合だけbreakでループを抜け出す
		while(true) {
			//図柄の回答番号を入れる変数を用意する
			int markAns = 0;
			//「どれだと思う：」を表示する
			System.out.print("どれだと思う：");
			//回答番号(整数値)を入力させる
			markAns = stdin.nextInt();
			//回答番号が想定した値(0～3)でなかった場合のエラー処理を行う
			//想定した値(0～3)が入力されるまで繰り返す
			while(markAns < 0 || markAns > 3) {
				//エラーメッセージの表示をする
				System.out.println("\n0～3を入力してください");
				//「どれだと思う：」を表示する
				System.out.print("どれだと思う：");
				//回答番号(整数値)を再入力させる
				markAns = stdin.nextInt();
			}

			//図柄の答えの要素番号(0～3)と回答番号(0～3)を比較する
			if(markAns != markRam) {
				//異なっている場合に「残念！〇〇じゃないよ」を表示する
				System.out.println("残念！" + mark[markAns] + "じゃないよ");
			}else {
				//等しい場合に「正解！図柄は〇〇だよ」を表示する
				System.out.println("\n正解！図柄は" + mark[markRam] + "だよ\n");
				//breakで無限ループを抜ける
				break;
			}
		}

		//「次は数字を当ててね」を表示する
		System.out.println("次は数字を当ててね\n");

		//数字を当てさせる
		//図柄と同様に無限ループを生成し、回答があっている場合にbreakでループを抜ける
		while(true) {
			//数字の回答番号を入れる変数を用意する
			int numberAns = 0;
			//「どれだと思う：」を表示する
			System.out.print("どれだと思う：");
			//回答番号(整数値)を入力させる
			numberAns = stdin.nextInt();

			//回答が想定した値(1～13)でなかった場合のエラー処理を行う
			//想定した値(1～13)が入力されるまで繰り返す、
			while(numberAns < 1 || numberAns > 13) {
				//エラーメッセージの表示をする
				System.out.println("\n1～13を入力してください");
				//「どれだと思う：」を表示する
				System.out.print("どれだと思う：");
				//回答番号(整数値)を再入力させる
				numberAns = stdin.nextInt();
			}

			//数字の答えの要素番号(0～12)と回答番号(1～13)を比較する
			if(numberAns - 1 != numberRam) {
				//異なっている場合に「残念！〇〇じゃないよ」を表示する
				System.out.println("\n残念！" + number[numberAns - 1] + "じゃないよ");
			}else {
				//等しい場合に「正解！〇〇の〇〇だよ」を表示する
				System.out.print("\n正解！" + mark[markRam] + "の" + number[numberRam] + "だよ");
				//breakで無限ループを抜ける
				break;
			}
		}

		//終了処理を行う
		stdin.close();
	}

}
