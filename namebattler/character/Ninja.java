package com.wixsite.mkmercury0.superior.namebattler.character;

import com.wixsite.mkmercury0.superior.namebattler.character.base.Player;
import com.wixsite.mkmercury0.superior.namebattler.magic.NinjaMagic;
import com.wixsite.mkmercury0.superior.namebattler.util.NbUtils;

/**
 * プレイヤー： 忍者
 */
public class Ninja extends Player {

    /* ====================
     * Ninja: コンストラクタ
     * ==================== */

    public Ninja(String name) {

        super(name);
        this.job = Job.NINJA;
    }

    /* ====================
     * Ninja: @Override protected
     * ==================== */

    /**
     * 名前からキャラクターに必要なパラメータを生成
     */
    @Override
    protected void makeCharacter() {

        // 戦士のパラメータを名前から生成する
        this.hp
            = getNumber(0, Job.NINJA.getHpMin(), Job.NINJA.getHpMax());
        this.mp
            = getNumber(1, Job.NINJA.getMpMin(), Job.NINJA.getMpMax());
        this.str
            = getNumber(2, Job.NINJA.getStrMin(), Job.NINJA.getStrMax());
        this.def
            = getNumber(3, Job.FIGHTER.getDefMin(), Job.NINJA.getDefMax());
        this.luck
            = getNumber(4, Job.NINJA.getLuckMin(), Job.NINJA.getLuckMax());
        this.agi
            = getNumber(5, Job.NINJA.getAgiMin(), Job.NINJA.getAgiMax());
    }

    /* ====================
     * Ninja: public ドメインロジック
     * ==================== */

    @Override
    protected void doOriginalAttack(Player defender) {

        boolean isUseMagic = false;

        if (0 < this.mp) {

            NinjaMagic randomChoiceMagic = NinjaMagic
                .of(NbUtils.getRandomNums(NinjaMagic.values().length));

            // MPがない場合と、
            // マキビシを選択しているにも関わらず、すでにマキビシが撒かれている場合は
            // 魔法は使えないようにする
            if (randomChoiceMagic.getSpendMp() <= this.mp
                && !(defender.isScatterMakibishi()
                    && randomChoiceMagic == NinjaMagic.MAKIBISI)) {

                displayChantMagic(defender, randomChoiceMagic);

                switch (randomChoiceMagic) {

                case KAKUREMINO:
                    this.isInvisible = true;

                    View.draw("隠れ身の術を使った. " + getName() + "の姿が見えない...",
                        this.cosoleFastPadMoreWithBrick);

                    break;

                case MAKIBISI:
                    defender.setIsScatterMakibishi(true);

                    View.draw("あたり一面にマキビシをバラまいた！！",
                        this.cosoleFastPadMoreWithBrick);

                    View.draw("... 今後、落ちているマキビシを踏ませるごとに 10 のダメージを与える.",
                        this.cosoleFastPadMoreWithBrick);

                    break;
                }

                // マジックの実行により MP を消費
                this.mp -= randomChoiceMagic.getSpendMp();

                isUseMagic = true;
            }

        }

        if (!isUseMagic) {

            int damage = calcDamage(defender);

            View.draw("投げた手裏剣がヒットした！", this.cosoleFastPadMoreWithBrick);

            displayEnemyWasDamaged(defender, damage);

            defender.damage(damage);

            int chance = NbUtils.getRandomNums(5);

            // 20%の確率でひるんだすきに手裏剣がもう一度ヒット
            if (chance == 2) {

                damage = calcDamage(defender);

                View.draw("ひるんだすきに再び手裏剣がヒット！！",
                    this.cosoleFastPadMoreWithBrick);

                displayEnemyWasDamaged(defender, damage);

                defender.damage(damage);
            }

        }
    }

}
