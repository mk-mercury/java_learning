package com.wixsite.mkmercury0.superior.namebattler.character.base;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.wixsite.mkmercury0.superior.namebattler.character.Job;
import com.wixsite.mkmercury0.superior.namebattler.magic.Magic;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler.Pad;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler.SlowPrintTime;
import com.wixsite.mkmercury0.superior.namebattler.util.NbUtils;

/**
 * プレイヤーを表すドメインクラス
 * 各種ジョブの基底クラス
 */
public class Player {

    /* ====================
     * Player: フィールド変数
     * ==================== */

    protected String name; // 名前
    protected int hp; // HP
    protected int mp; // MP
    protected int str; // 攻撃力
    protected int def; // 防御力
    protected int luck; // 運
    protected int agi; // 素早さ
    protected Job job; // 職業

    protected boolean isParalyzed; // 麻痺しているかどうか
    protected boolean isPoisoned; // 毒が効いているかどうか
    protected boolean isScatterMakibishi; // まきびしが撒かれているかどうか
    protected boolean isInvisible; // 見えない状態かどうか

    protected ConsoleHandler cosoleFastPadMoreWithBrick; // コンソール1
    protected ConsoleHandler consoleNoSlowPadMoreNoBrick; // コンソール2

    /* ====================
     * Player: コンストラクタ
     * ==================== */

    public Player(String name) {

        this.name = name;
        this.isParalyzed = false; // 初期状態では麻痺していない
        this.isPoisoned = false; // 初期状態では毒が効いていない
        this.isScatterMakibishi = false; // 初期状態ではまきびしが撒かれていない
        this.isInvisible = false; // 初期状態では見えている状態

        // キャラクターのパラメータ生成
        makeCharacter();

        cosoleFastPadMoreWithBrick
            = new ConsoleHandler().config.padding(Pad.MORE).config
                .formatTemplate("│ %s │").config
                    .slowPrintTime(SlowPrintTime.LITTLE_SLOW);

        consoleNoSlowPadMoreNoBrick
            = new ConsoleHandler().config.padding(Pad.MORE).config
                .slowPrintTime(SlowPrintTime.NO_SLOW);
    }

    /* ====================
     * Player: setter
     * ==================== */

    public Player setNameSelf(String name) {

        this.name = name;
        return this;
    }

    /** 痺れているかどうかを設定 */
    public void setIsParalyzed(boolean flag) {
        this.isParalyzed = flag;
    }

    /** 毒が効いているかどうかを設定 */
    public void setIsPoisoned(boolean flag) {
        this.isPoisoned = flag;
    }

    /** 姿が見えているかどうかを設定 */
    public void setIsInvisible(boolean flag) {
        this.isInvisible = flag;
    }

    /** マキビシが撒かれているかどうかを設定 */
    public void setIsScatterMakibishi(boolean flag) {
        this.isScatterMakibishi = flag;
    }

    /* ====================
     * Player: getter
     * ==================== */

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMp() {
        return this.mp;
    }

    public int getStr() {
        return this.str;
    }

    public int getDef() {
        return this.def;
    }

    public int getLuck() {
        return this.luck;
    }

    public int getAgi() {
        return this.agi;
    }

    public Job getJob() {
        return this.job;
    }

    public boolean isPoisoned() {
        return this.isPoisoned;
    }

    public boolean isScatterMakibishi() {
        return this.isScatterMakibishi;
    }

    /* ====================
     * Player: ドメインロジック
     * ==================== */

    /**
     * 名前からキャラクターに必要なパラメータを生成
     */
    protected void makeCharacter() {
    }

    /**
     * 名前(name)からハッシュ値を生成し、指定された位置の数値を取り出す
     * @param index : 何番目の数値を取り出すか
     * @param min : 最小値(内部的に0～255の値を生成するが、min～maxまでの値に補正)
     * @param max : 最大値(内部的に0～255の値を生成するが、min～maxまでの値に補正)
     * @return 数値(0～max) ※maxも含む
     */
    protected int getNumber(int index, int min, int max) {

        double rangeWidth = max - min;
        double valRate = rangeWidth / 255;

        try {
            // 名前からハッシュ値を生成する
            byte[] result = MessageDigest.getInstance("SHA-1")
                .digest(this.name.getBytes());
            String digest = String.format("%040x", new BigInteger(1, result));

            // ハッシュ値から指定された位置の文字列を取り出す（２文字分）
            String hex = digest.substring(index * 2, index * 2 + 2);

            // 取り出した文字列（16進数）を数値に変換する
            int val = Integer.parseInt(hex, 16);
            return (int) (val * valRate) + min;
        } catch (Exception e) {
            // エラー
            e.printStackTrace();
        }
        return 0;
    }

    /** 現在のステータスを文字列化 */
    protected String toStringStatus() {

        return String.format("%s (HP=%3d : STR=%3d : DEF=%3d)\n",
            this.getName(), this.getHp(), this.getStr(), this.getDef());
    }

    /**
     * 現在のステータスを System.out で表示する
     */
    public void PrintStatus() {
        View.draw(toStringStatus(), consoleNoSlowPadMoreNoBrick);
    }

    /**
     * 敵を攻撃する（継承したクラスでは実装できない）
     * @param defender 攻撃相手
     */
    public final void attack(Player defender) {

        // 攻撃開始の一連の共通処理を実行
        doCommonProcsStartingAttack(defender);

        // 痺れていなければ、攻撃できる
        if (isNotParalyzed()) {

            // 職業ごとの独自攻撃を実行
            doOriginalAttack(defender);
        }

        // 攻撃終了の一連の共通処理を実行
        doCommonProcsEndingAttack(defender);
    }

    /** 職業ごとの独自攻撃 */
    protected void doOriginalAttack(Player defender) {

        int damage = 0; // 攻撃相手に与えるダメージ

        // 職業ごとに合わせた攻撃処理を実行
        damage = doNormalAttack(defender);

        if (defender.isInvisible) {

            View.draw(
                "隠れ身の術で" + defender.getName() + "の姿が見えない！",
                this.cosoleFastPadMoreWithBrick);

            View.draw(
                getName() + "の攻撃をかわした！",
                this.cosoleFastPadMoreWithBrick);

            displayEnemyWasDamaged(defender, damage = 0);

            defender.setIsInvisible(false);
        } else {

            displayEnemyWasDamaged(defender, damage);

            // 攻撃相手にダメージを反映させる
            defender.damage(damage);
        }
    }

    /** 標準的な攻撃内容 */
    protected int doNormalAttack(Player defender) {
        return 0;
    }

    /** 攻撃終了の一連の Player 共通処理 */
    private void doCommonProcsEndingAttack(Player defender) {

        // 痺れている状態なら、攻撃不能
        if (this.isParalyzed) {

            View.draw(getName() + "は麻痺して攻撃できない！",
                this.cosoleFastPadMoreWithBrick);

            setIsParalyzed(false); // 痺れから解放
        }

        // 攻撃相手の HP がゼロになったら、結果表示
        if (isDead(defender))
            displayEnemyWasDead(defender);

        // 攻撃相手がまだ生きていれば
        if (isLive(defender)) {

            // 毒が効いていれば
            if (defender.isPoisoned()) {

                // 毒が効いている場合の追加ダメージ
                int damage = 20;

                View.draw("毒が効いている... ",
                    this.cosoleFastPadMoreWithBrick);

                displayEnemyWasDamaged(defender, damage);

                defender.damage(damage);
            }

            // マキビシが撒かれていれば
            if (defender.isScatterMakibishi) {

                // マキビシを踏んだ場合の追加ダメージ
                int damage = 10;

                int chance = NbUtils.getRandomNums(3);

                // 20%の確率でマキビシを踏んでしまう
                if (chance == 2) {
                    View.draw(
                        defender.getName() + "はマキビシを踏んで痛がっている！",
                        this.cosoleFastPadMoreWithBrick);

                    displayEnemyWasDamaged(defender, damage);

                    defender.damage(damage);
                }
            }

            // 攻撃相手の HP がゼロになったら、結果表示
            if (isDead(defender))
                displayEnemyWasDead(defender);
        }
    }

    /**
     * 攻撃で与えるダメージを計算する
     * @param target 攻撃相手
     * @return ダメージ値(0～)
     */
    protected int calcDamage(Player target) {

        int myAttackPoint = NbUtils.getRandomNums(getStr());
        int targetDefPoint = NbUtils.getRandomNums(target.getDef());

        int damage = (myAttackPoint ^ 2 / (myAttackPoint + targetDefPoint));

        return damage < 0 ? 0 : damage;
    }

    /**
     * ダメージを受けた分だけ HP を減少させる
     * @param damage : ダメージ値
     */
    public void damage(int damage) {

        this.hp = Math.max(this.getHp() - damage, 0);
    }

    /** 痺れていないよね？ */
    protected boolean isNotParalyzed() {
        return this.isParalyzed == false;
    }

    /** 生死判定 */
    private boolean isLive(Player player) {
        return 0 < player.getHp();
    }

    private boolean isDead(Player player) {
        return player.getHp() <= 0;
    }

    /** 会心の一撃が出せるかどうかを判定 */
    protected boolean canCriticalHit() {

        int criticalHitChance
            = NbUtils.getRandomNums(100 - getLuck());

        return NbUtils.getDigit(criticalHitChance, 1) == 0;
    }

    /** 攻撃開始の一連の Player 共通処理 */
    private void doCommonProcsStartingAttack(Player defender) {

        // 囲み文字でヘッダ枠を表示
        View.drawHeadBrickLine(this.consoleNoSlowPadMoreNoBrick);

        // 与えるダメージを求める
        View.draw(getName() + "の攻撃！", this.cosoleFastPadMoreWithBrick);
    }

    /** 敵が死んだことを表示する */
    private void displayEnemyWasDead(Player defender) {

        View.draw(defender.getName() + "は力尽きた...",
            this.cosoleFastPadMoreWithBrick);
    }

    /** 敵へのダメージを表示する */
    protected void displayEnemyWasDamaged(Player defender, int damage) {

        View.draw("  ----> " + defender.getName() + "に" + damage + "のダメージ！",
            this.cosoleFastPadMoreWithBrick);
    }

    /** 唱えた魔法を表示する */
    protected void displayChantMagic(Player defender, Magic magic) {

        View.draw(
            getName() + "は" + magic.getJaLang() + "を唱えた"
                + "(MP " + magic.getSpendMp() + " を消費)!",
            this.cosoleFastPadMoreWithBrick);
    }

    /**
     * 内部クラス： ビュー担当
     */
    protected static class View {

        public static void drawHeadBrickLine(ConsoleHandler console) {
            console.out(
                "├──────────────────────────────────────────────────────────────────────────────────┤");
        }

        public static void draw(String message, ConsoleHandler console) {
            console.out(message);
        }

    }
}