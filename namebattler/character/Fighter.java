package com.wixsite.mkmercury0.superior.namebattler.character;

import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;

/**
 * プレイヤー： 戦士
 */
public class Fighter extends Player {

    /* ====================
     * Fighter: コンストラクタ
     * ==================== */

    public Fighter(String name) {

        super(name);
        this.job = Job.FIGHTER;
    }

    /* ====================
     * Fighter: @Override protected
     * ==================== */

    /**
     * 名前からキャラクターに必要なパラメータを生成
     */
    @Override
    protected void makeCharacter() {

        this.hp = getNumber(0, Job.FIGHTER.getHpMin(), Job.FIGHTER.getHpMax());
        this.mp = getNumber(1, Job.FIGHTER.getMpMin(), Job.FIGHTER.getMpMax());
        this.str
            = getNumber(2, Job.FIGHTER.getStrMin(), Job.FIGHTER.getStrMax());
        this.def
            = getNumber(3, Job.FIGHTER.getDefMin(), Job.FIGHTER.getDefMax());
        this.luck
            = getNumber(4, Job.FIGHTER.getLuckMin(), Job.FIGHTER.getLuckMax());
        this.agi
            = getNumber(5, Job.FIGHTER.getAgiMin(), Job.FIGHTER.getAgiMax());
    }

    /* ====================
     * Fighter: @Override protected ドメインロジック
     * ==================== */

    @Override
    protected int doNormalAttack(Player defender) {

        // 会心の一撃が出せるなら
        if (canCriticalHit()) {

            View.draw(
                "会心の一撃！！！！！！！！！！！！",
                this.cosoleFastPadMoreWithBrick);

            // 会心の一撃は、与えるダメージ = STR 値 とする
            return getStr();

        }

        return calcDamage(defender);
    }

}
