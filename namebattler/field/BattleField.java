package com.wixsite.mkmercury0.superior.namebattler.field;

import java.util.Arrays;

import com.wixsite.mkmercury0.superior.namebattler.character.Job;
import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler.Pad;
import com.wixsite.mkmercury0.superior.namebattler.util.ConsoleHandler.SlowPrintTime;
import com.wixsite.mkmercury0.superior.namebattler.util.InputHandler;
import com.wixsite.mkmercury0.superior.namebattler.util.NbUtils;

/**
 * ネームバトラーの戦闘場所を表すドメインクラス
 */
public class BattleField {

    private Player hero;
    private Player enemy;

    private int turnCount; // 何ターン目かをカウント

    private String currentInputErrorMessage; //エラーメッセージ

    private ConsoleHandler ui01; // コンソール1
    private ConsoleHandler ui02; // コンソール2
    private ConsoleHandler ui02slow; // コンソール2(ゆっくり表示)
    private ConsoleHandler ui02NoPad; // コンソール2(余白なし)
    private ConsoleHandler uiFast; // 表示の速いコンソール

    private InputHandler stdin; // 標準入力

    /* ====================
     * BattleField: コンストラクタ
     * ==================== */

    public BattleField() {

        this.ui01 = new ConsoleHandler().config.padding(Pad.MORE).config
            .formatTemplate("│ %s │").config.slowPrintTime(SlowPrintTime.FAST);

        this.ui02 = new ConsoleHandler().config.padding(Pad.MORE).config
            .slowPrintTime(SlowPrintTime.NO_SLOW);

        this.ui02slow = new ConsoleHandler().config.padding(Pad.MORE).config
                .slowPrintTime(SlowPrintTime.FAST);

        this.ui02NoPad = new ConsoleHandler().config.padding(Pad.NONE).config
            .slowPrintTime(SlowPrintTime.NO_SLOW);

        this.uiFast = new ConsoleHandler().config.padding(Pad.MORE).config
            .formatTemplate("│ %s │").config
                .slowPrintTime(SlowPrintTime.NO_SLOW);

        this.turnCount = 1;

        this.stdin = new InputHandler();

        this.currentInputErrorMessage = "None.";
    }

    public BattleField setHeroSelf(Player hero) {
        this.hero = hero;
        return this;
    }

    public BattleField setEnemySelf(Player enemy) {
        this.enemy = enemy;
        return this;
    }

    public void callBattleStart() {
        ui02NoPad.out("==== バトル開始 ====\n");
    }

    public void callBattleEnd() {

        String template = "=== 戦いは終わった. %sが勝った";
        String winner = "";
        if (this.enemy.getHp() <= 0) {
            winner = this.hero.getName();
        } else {
            winner = this.enemy.getName();
        }
        ui02.out(String.format(template, winner));
    }

    public void callPlayerWasDead(Player player) {
        ui02.out(player.getName() + "のダメージが 0 になった. "
            + player.getName() + "は死んだ.");
    }

    public void callBattleTurnCount() {
        ui02NoPad.out("==== ターン( " + this.turnCount++ + " ) ====\n");
    }

    public void showHpEachOther() {

        // プレーヤー1の HP を表示
        ui02.out("Player1: " + this.hero.getName() + " ("
            + this.hero.getJob().getJaLang() + ")");

        String hpHeroToString = paramWithIndicator("  HP    : ",
            this.hero.getHp(), this.hero.getHp() / 5);
        ui02slow.out(hpHeroToString);

        String mpHeroToString = paramWithIndicator("  MP    : ",
            this.hero.getMp(), this.hero.getMp() / 3);
        ui02.out(mpHeroToString);

        // プレーヤー2の HP を表示
        ui02.out("Player2: " + this.enemy.getName() + " ("
            + this.enemy.getJob().getJaLang() + ")");

        String hpEnemyToString = paramWithIndicator("  HP    : ",
            this.enemy.getHp(), this.enemy.getHp() / 5);
        ui02slow.out(hpEnemyToString);

        String mpEnemyToString = paramWithIndicator("  MP    : ",
            this.enemy.getMp(), this.enemy.getMp() / 3);
        ui02.out(mpEnemyToString);
    }

    public void showPlayersAllParams() {

        ui02.out(
            "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        showPlayerParams("[プレーヤー1] ", this.hero);
        ui02.out(
            "├──────────────────────────────────────────────────────────────────────────────────┤");
        showPlayerParams("[プレーヤー2] ", this.enemy);
        ui02.out(
            "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
    }

    private void showPlayerParams(String label, Player player) {
        uiFast.out(label + player.getName());
        uiFast.out("職業  : " + player.getJob().getJaLang());

        String hpToString = paramWithIndicator("HP    : ", player.getHp(),
            player.getHp() / 5);
        uiFast.out(hpToString);

        String mpToString = paramWithIndicator("MP    : ", player.getMp(),
            player.getMp() / 3);
        uiFast.out(mpToString);

        String strToString
            = paramWithIndicator("攻撃力: ", player.getStr(), player.getStr() / 3);
        uiFast.out(strToString);

        String defToString
            = paramWithIndicator("防御力: ", player.getDef(), player.getDef() / 3);
        uiFast.out(defToString);

        String luckToString = paramWithIndicator("運    : ", player.getLuck(),
            player.getLuck() / 3);
        uiFast.out(luckToString);

        String agiToString
            = paramWithIndicator("素早さ: ", player.getAgi(), player.getAgi() / 3);
        ui01.out(agiToString);
    }

    private String paramWithIndicator(String label, int param,
        int indicatorLength) {
        String indicator = "";
        for (int i = 0; i < indicatorLength; i++) {
            indicator += ":";
        }
        String template = String.format("%s %3d  " + indicator, label, param);
        return template;
    }

    public int calcAttackPoint(Player player) {
        return NbUtils.getRandomNumsWithoutZero(player.getStr());
    }

    public int calcDefendPoint(Player player) {
        return NbUtils.getRandomNumsWithoutZero(player.getDef());
    }

    public void doBattle() {

        callBattleStart();

        // どちらかのプレーヤーの HP が 0 になるまで、攻守を変えながら攻撃を繰り返す
        do {
            callBattleTurnCount();
            showHpEachOther();

            boolean isAttackFirstEnemy = this.hero.getAgi() < enemy.getAgi();

            if (isAttackFirstEnemy) {

                // 敵が先攻
                this.enemy.attack(this.hero);

                if (this.hero.getHp() <= 0) {
                    ui02.out(
                        "└──────────────────────────────────────────────────────────────────────────────────┘");
                    callPlayerWasDead(this.hero);
                    break;
                }

                this.hero.attack(this.enemy);

            } else {

                // 味方が先攻
                this.hero.attack(this.enemy);

                if (this.enemy.getHp() <= 0) {
                    ui02.out(
                        "└──────────────────────────────────────────────────────────────────────────────────┘");
                    callPlayerWasDead(this.enemy);
                    break;
                }

                this.enemy.attack(this.hero);
            }

            ui02.out(
                "└──────────────────────────────────────────────────────────────────────────────────┘");

        } while (0 < this.hero.getHp() && 0 < this.enemy.getHp());

        callBattleEnd();
    }

    private String inputCheckedNameRange(String string) {

        boolean isNotAllowed = true;
        String yourInput = "";

        while (isNotAllowed) {

            yourInput = this.stdin.getString();

            if (isAllowedInputName(yourInput)) {
                break;
            }

            ui02.out("入力エラー: ");
            ui02.out("理由: " + this.currentInputErrorMessage);
            ui02.out("");
            ui02.outWithoutLf(String.format("「%s」の名前(20文字以内)を再入力してください: ", string));
        }
        return yourInput;
    }

    private String inputCheckedJobRange(String name) {

        boolean isNotAllowed = true;
        String yourInput = "";

        while (isNotAllowed) {

            yourInput = this.stdin.getString();

            if (isAllowedInputJob(yourInput)) {
                break;
            }

            ui02.out("入力エラー: ");
            ui02.out("理由: " + this.currentInputErrorMessage);
            ui02.out("");
            ui02.outWithoutLf("再入力してください. " + toStringRequireJobInput(name));
        }
        return yourInput;
    }

    public String toStringRequireJobInput(String name) {
        return name + "の「職業」を選択してください (" + Job.toStringJobList() + ") ?： ";
    }

    /**
     * ユーザの入力値が求める内容に沿っているかチェック
     * 無効だった場合、メンバ変数にエラー内容をセット
     */
    public boolean isAllowedInputName(String input) {

        // チェック: 入力された名前は20文字以内か
        int inputLength = input.length();

        if (20 < inputLength) {
            this.currentInputErrorMessage = "入力した名前が20文字を超えています.";
            return false;
        }

        // 上記チェックを通過すれば有効入力と判定
        return true;
    }

    public boolean isAllowedInputJob(String input) {

        // チェック 1: 数字であること
        int inputConvertToInt = 0;
        try {
            inputConvertToInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            this.currentInputErrorMessage = "入力が数字ではありませんでした.";
            return false;
        }

        // チェック 2: 入力値が選択肢可能な値に含まれているか
        Job[] jobArray = Job.values();
        Integer[] jobIdArray = new Integer[jobArray.length];
        for (Job job : jobArray) {
            jobIdArray[job.getId()] = job.getId();
        }
        if (!Arrays.asList(jobIdArray).contains(inputConvertToInt)) {
            this.currentInputErrorMessage = "入力値が選択可能な値ではありませんでした.";
            return false;
        }

        // 上記2つのチェックを通過すれば有効入力と判定
        return true;
    }

    public String inputJob(String name) {

        ui02.outWithoutLf(toStringRequireJobInput(name));

        return inputCheckedJobRange(name);
    }

    public String inputName(String string) {

        ui02.outWithoutLf(String.format("「%s」の名前(20文字以内)を入力してください: ", string));
        return inputCheckedNameRange(string);
    }

}
