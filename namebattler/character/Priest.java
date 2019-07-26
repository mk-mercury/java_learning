package com.wixsite.mkmercury0.superior.namebattler.character;

import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;
import com.wixsite.mkmercury0.superior.namebattler.magic.PriestMagic;
import com.wixsite.mkmercury0.superior.namebattler.util.NbUtils;

/**
 * プレイヤー： 僧侶
 */
public class Priest extends Player {

    /* ====================
     * Priest: コンストラクタ
     * ==================== */

    public Priest(String name) {

        super(name);
        this.job = Job.PRIEST;
    }

    /* ====================
     * Priest: @Override protected
     * ==================== */

    /**
     * 名前からキャラクターに必要なパラメータを生成
     */
    @Override
    protected void makeCharacter() {

        this.hp = getNumber(0, Job.PRIEST.getHpMin(), Job.PRIEST.getHpMax());
        this.mp = getNumber(1, Job.PRIEST.getMpMin(), Job.PRIEST.getMpMax());
        this.str = getNumber(2, Job.PRIEST.getStrMin(), Job.PRIEST.getStrMax());
        this.def = getNumber(3, Job.PRIEST.getDefMin(), Job.PRIEST.getDefMax());
        this.luck
            = getNumber(4, Job.PRIEST.getLuckMin(), Job.PRIEST.getLuckMax());
        this.agi = getNumber(5, Job.PRIEST.getAgiMin(), Job.PRIEST.getAgiMax());
    }

    /* ====================
     * Priest: public ドメインロジック
     * ==================== */

    @Override
    protected void doOriginalAttack(Player defender) {

        boolean isUseMagic = false;

        if (0 < this.mp) {

            PriestMagic randomChoiceMagic = PriestMagic
                .of(NbUtils.getRandomNums(PriestMagic.values().length));

            // MPがない場合と、
            // ポイズンの魔法を選択しているにも関わらず、すでに相手に毒が効いている場合は
            // 魔法は使えないようにする
            if (randomChoiceMagic.getSpendMp() <= this.mp
                && !(defender.isPoisoned()
                    && randomChoiceMagic == PriestMagic.POISON)) {

                displayChantMagic(defender, randomChoiceMagic);

                switch (randomChoiceMagic) {

                case HEAL:
                    this.hp += 50;

                    View.draw("HPが 50 ポイント回復した.",
                        this.cosoleFastPadMoreWithBrick);

                    break;

                case PARIZE:
                    int chance = NbUtils.getRandomNums(5);

                    // 20%の確率で麻痺させる
                    if (chance == 2) {

                        defender.setIsParalyzed(true);

                        View.draw(defender.getName() + "を麻痺させた.",
                            this.cosoleFastPadMoreWithBrick);

                    } else {

                        View.draw(randomChoiceMagic.getJaLang() + "は効かなかった.",
                            this.cosoleFastPadMoreWithBrick);

                        int damage = 0;
                        displayEnemyWasDamaged(defender, damage);
                    }
                    break;

                case POISON:
                    defender.setIsPoisoned(true);

                    View.draw(defender.getName() + "に毒を与えた.",
                        this.cosoleFastPadMoreWithBrick);

                    View.draw("... 毒により、毎ターン 20 のダメージを与え続ける.",
                        this.cosoleFastPadMoreWithBrick);

                    break;
                }

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
