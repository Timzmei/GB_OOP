package units;

import java.util.ArrayList;

public class Bandit extends Unit implements Warrior{

    public Bandit(ArrayList<Unit> banda) {
        super(String.format("Bandit #%d", ++Bandit.number),
                "Asylum",
                20,
                3,
                9,
                1,
                10,
                10,
                23,
                7,
                6,
                banda);

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
        return "Bandit{" +
                "name='" + name + '\'' +
                '}';
    }
}
