package novice;

public class FsNovice0102 {

	public static void main(String[] args) {

		// 合計金額
		int totalPrice = 12000;
		// 男性の数
		int numberOfMale = 3;
		// 女性の数
		int numberOfFemale = 3;
		// 男性が多く払う金額
		final int MALE_MANY_MONEY = 1000;

		// 割り勘する前に男性が1000円多く払う事を考慮しておく為、
		// あらかじめ1000円 * 男性の人数した金額を合計金額から減らしておく
		totalPrice = totalPrice - (MALE_MANY_MONEY * numberOfMale);

		// 割り勘の金額
		// 合計金額 / (男性の数 + 女性の数)
		int price = totalPrice / (numberOfMale + numberOfFemale);

		System.out.println("男性：" + (price + MALE_MANY_MONEY));
		System.out.println("女性：" + price);

	}

}
