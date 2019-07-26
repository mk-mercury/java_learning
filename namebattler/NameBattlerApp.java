package com.wixsite.mkmercury0.superior.namebattler;

import com.wixsite.mkmercury0.superior.namebattler.character.Fighter;
import com.wixsite.mkmercury0.superior.namebattler.character.Ninja;
import com.wixsite.mkmercury0.superior.namebattler.character.Priest;
import com.wixsite.mkmercury0.superior.namebattler.character.Wizard;
import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;
import com.wixsite.mkmercury0.superior.namebattler.field.BattleField;

/**
 * ====================
 * ネームバトラー
 * ====================
 * 「名前」からキャラクターを生成して、戦わせるゲーム.
 * 入力した名前によって、キャラクターのパラメータ
 * （体力、攻撃力、防御力など）が変動する.
 *
 * [ゲームの仕様]
 * ・キャラクター２人の自動バトルゲーム
 * 表示形式：
 * ・バトルの内容は、ＲＰＧ風に表示する
 * ・入力した名前で対戦ログが表示される
 * ・攻撃ダメージが０の場合は「攻撃がミス」と表示する
 * パラメータの仕様：
 * ・ＨＰをキャラクターの名前から算出
 * ・攻撃力(STR)をキャラクターの名前から算出
 * ・防御力(DEF)をキャラクターの名前から算出
 * ・運(LUCK)をキャラクターの名前から算出する
 * ・運(LUCK)が高いほど、会心の一撃の確率が高くなる
 * 攻撃時に相手に与えるダメージの計算式：
 * ・攻撃側の攻撃力(STR) ー 防御側の防御力(DEF)
 * ・ダメージが０以下の場合は、ダメージを０として扱う
 *
 * @author Natsuki, Hashimoto
 * @since  2019.07.26
 */
public class NameBattlerApp {

    public static void main(String... args) {

        BattleField field = new BattleField();

        String heroName = field.inputName("プレーヤー1");
        String heroJob = field.inputJob(heroName);
        Player hero = createPlayer(heroName, heroJob);

        String enemyName = field.inputName("プレーヤー2");
        String enemyJob = field.inputJob(enemyName);
        Player enemy = createPlayer(enemyName, enemyJob);

        field = field.setHeroSelf(hero).setEnemySelf(enemy);

        field.showPlayersAllParams();
        field.doBattle();
    }

    private static Player createPlayer(String name, String job) {

        switch (job) {

        case "0": // 戦士
            return new Fighter(name);

        case "1": // 魔法使い
            return new Wizard(name);

        case "2": // 僧侶
            return new Priest(name);

        case "3": // 忍者
            return new Ninja(name);
        }

        return new Fighter("No Name.");
    }

}
