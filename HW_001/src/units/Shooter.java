package units;

import java.util.ArrayList;

public abstract class Shooter extends Unit {

    protected int distance, maxCountBullet, currentCountBullet;
    protected float accuracy;
    public Shooter(String name, String faction, int cost, int level, int defense, int damage, int maxHp, int hp, int movement, int speed, int initiative, int distance, int maxCountBullet, float accuracy, Banda banda) {
        super(name, faction, cost, level, defense, damage, maxHp, hp, movement, speed, initiative, banda);
        this.distance = distance;
        this.maxCountBullet = maxCountBullet;
        this.currentCountBullet = maxCountBullet;
        this.accuracy = accuracy;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die() || currentCountBullet <= 0) {
            return;
        }
        attack(findNearUnit(enemy));
        for (Unit unit : banda.getUnitArrayList()) {
            if (unit instanceof Peasant) {
                if (!unit.die() && ((Peasant)unit).readiness) {
                    ((Peasant)unit).readiness = false;
                    return;
                }
            }
        }
        this.currentCountBullet--;
    }

    @Override
    public void step() {

    }
}
