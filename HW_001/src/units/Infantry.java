package units;

import java.util.ArrayList;

public class Infantry extends Unit implements Warrior{
    public Infantry(Banda banda, int x, int y) {
        super(String.format("Infantry #%d", ++Infantry.number),
                "Asylum",
                32,
                1,
                11,
                9,
                10,
                10,
                19,
                2,
                9,
                banda,
                x,
                y);
    }

    @Override
    public String toString() {
        return name +
                " Hp:" + hp +
                " Dfns:" + defense +
                " Dmg:" + damage;
    }

    @Override
    public void attack(Unit unit) {
        int tempDamage = 0;

        if (this.damage > unit.defense) {
            tempDamage = this.damage - unit.getDefense();
        } else {
            tempDamage = this.damage - (unit.getDefense() / this.damage);
        }
        setUnitDamage(unit, tempDamage);

        System.out.println(this.name + " attack " + unit.name + "; damage=" + tempDamage);

    }

    @Override
    public void setUnitDamage(Unit unit, int damage) {
        System.out.println(unit + " hp=" + (unit.getHp() - damage));

        unit.setHp(Math.max(unit.getHp() - damage, 0));
    }

}
