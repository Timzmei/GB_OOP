package units;

import java.util.ArrayList;

public class Pikeman extends Unit implements Warrior{
    public Pikeman(Banda banda, int x, int y) {
        super(String.format("Pikeman #%d", ++Pikeman.number),
                "Asylum",
                150,
                2,
                14,
                8,
                30,
                30,
                19,
                4,
                4,
                banda,
                x,
                y);
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
    public String toString() {
        return name +
                " Hp:" + hp +
                " Dfns:" + defense +
                " Dmg:" + damage;
    }
}
