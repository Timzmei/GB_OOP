package units;

import java.util.ArrayList;

public class Sniper extends Shooter implements Warrior {
    public Sniper(ArrayList<Unit> banda) {
        super(String.format("Sniper #%d", ++Bandit.number),
                "Asylum",
                440,
                3,
                10,
                30,
                40,
                40,
                19,
                5,
                8,
                5,
                10,
                12,
                banda);
    }



    @Override
    public String toString() {
        return "Sniper{" +
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
    public void step(ArrayList<Unit> enemy) {
        if (die() || currentCountBullet <= 0) {
            return;
        }
        attack(findNearUnit(enemy));
        for (Unit unit : banda) {
            if (unit instanceof Peasant) {
                if (!unit.die() && ((Peasant)unit).readiness) {
                    ((Peasant)unit).readiness = false;
                    return;
                }
            }
        }
        this.currentCountBullet--;
    }
}
