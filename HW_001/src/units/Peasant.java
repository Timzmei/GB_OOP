package units;

import java.util.ArrayList;

public class Peasant extends Unit implements Warrior, Healer{

    public Peasant(ArrayList<Unit> banda) {
        super(String.format("Peasant #%d", ++Bandit.number),
                "Haven",
                15,
                1,
                7,
                3,
                10,
                10,
                18,
                2,
                1,
                banda);
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void healer(Unit unit, int hp) {
        unit.setHp(Math.min(hp/2 + unit.getHp(), unit.getMaxHp()));
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
}
