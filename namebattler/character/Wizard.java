package com.wixsite.mkmercury0.superior.namebattler.character;

import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;
import com.wixsite.mkmercury0.superior.namebattler.magic.WizardMagic;
import com.wixsite.mkmercury0.superior.namebattler.util.NbUtils;

/**
 * プレイヤー： 魔法使い
 */
public class Wizard extends Player {

    /* ====================
     * Wizard: コンストラクタ
     * ==================== */

    public Wizard(String name) {

        super(name);
        this.job = Job.WIZARD;
    }

    /* ====================
     * Wizard: @Override protected
     * ==================== */

    /**
     * 名前からキャラクターに必要なパラメータを生成
     */
    @Override
    protected void makeCharacter() {

        this.hp = getNumber(0, Job.WIZARD.getHpMin(), Job.WIZARD.getHpMax());
        this.mp = getNumber(1, Job.WIZARD.getMpMin(), Job.WIZARD.getMpMax());
        this.str = getNumber(2, Job.WIZARD.getStrMin(), Job.WIZARD.getStrMax());
        this.def = getNumber(3, Job.WIZARD.getDefMin(), Job.WIZARD.getDefMax());
        this.luck
            = getNumber(4, Job.WIZARD.getLuckMin(), Job.WIZARD.getLuckMax());
        this.agi = getNumber(5, Job.WIZARD.getAgiMin(), Job.WIZARD.getAgiMax());
    }

    /* ====================
     * Wizard: public ドメインロジック
     * ==================== */

    @Override
    protected void doOriginalAttack(Player defender) {

        boolean isUseMagic = false;

        if (0 < this.mp) {

            WizardMagic randomChoiceMagic = WizardMagic
                .of(NbUtils.getRandomNums(WizardMagic.values().length));

            if (randomChoiceMagic.getSpendMp() <= this.mp) {

                displayChantMagic(defender, randomChoiceMagic);

                View.draw(defender.getName() + "は防御できない. ",
                    this.cosoleFastPadMoreWithBrick);

                int damage = NbUtils.getRandomNums(10, 30);
                displayEnemyWasDamaged(defender, damage);

                defender.damage(damage);

                // マジックの実行により MP を消費
                this.mp -= randomChoiceMagic.getSpendMp();

                isUseMagic = true;
            }
        }

        if (!isUseMagic) {

            int damage = 0;
            damage = calcDamage(defender);

            displayEnemyWasDamaged(defender, damage);
            defender.damage(damage);
        }
    }

}
