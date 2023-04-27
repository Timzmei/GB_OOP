package units;

import java.util.ArrayList;

public class Mage extends Unit implements Healer, Warrior{

    protected float maxMana, mana;

    public Mage(Banda banda) {
        super(String.format("Mage #%d", ++Bandit.number),
                "Academy",
                160,
                2,
                12,
                4,
                16,
                16,
                19,
                5,
                5,
                banda);
        this.mana = 20;
        this.maxMana = 20;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void attack(Unit unit) {
        System.out.println(this.name + " attack " + unit.name);

        if (this.damage > unit.defense) {
            setUnitDamage(unit, this.damage + unit.getDefense());
        } else {
            setUnitDamage(unit, (this.damage / unit.getDefense()));
        }

    }

    @Override
    public void setUnitDamage(Unit unit, int damage) {
        if (unit.getHp() - damage > 0) {
            unit.setHp(unit.getHp() - damage);
        } else {
            unit.setHp(0);
        }
    }

    @Override
    public void healer(Unit unit, int hp) {
        unit.setHp(Math.min(hp + unit.getHp(), unit.getMaxHp()));
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (this.hp > 0 && mana > 0) {
            for (Unit unit : banda.getUnitArrayList()) {
                if (unit.hp < unit.maxHp) {
                    unit.setHp(-damage);
                    this.mana--;
                    return;
                }
            }
        }
    }
}
