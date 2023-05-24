package units;

import java.util.ArrayList;

public class Monk extends Unit implements Healer{
    public Monk(Banda banda, int x, int y) {
        super(String.format("Monk #%d", ++Monk.number),
                "Asylum",
                550,
                3,
                22,
                15,
                55,
                55,
                19,
                5,
                2,
                banda,
                x,
                y);
    }

    @Override
    public void healer(Unit unit) {
        unit.setHp(Math.min(unit.getHp(), unit.getMaxHp()));
    }

    @Override
    public String toString() {
        return name +
                " Hp:" + hp +
                " Dfns:" + defense +
                " Dmg:" + damage;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {

        Unit target = findNearUnit(banda.getUnitArrayList());
        attack(target);
    }

    @Override
    public Unit findNearUnit(ArrayList<Unit> banda){
        Unit nearUnit = null;
        float minDist = Float.MAX_VALUE;
        for (Unit unit : banda) {
            if (unit.banda.getName().equals(this.banda.getName())) {
                float dist = unit.coordinate.distance(this.coordinate);
                if (minDist > dist) {
                    nearUnit = unit;
                    minDist = dist;
                }
            }
        }
        return nearUnit;
    }

    @Override
    void attack(Unit target){
        target.setHp(damage);
    }

}
