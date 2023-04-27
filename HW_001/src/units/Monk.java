package units;

import java.util.ArrayList;

public class Monk extends Unit implements Healer{
    public Monk(Banda banda) {
        super(String.format("Monk #%d", ++Bandit.number),
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
                banda);
    }

    @Override
    public void healer(Unit unit, int hp) {
        unit.setHp(Math.min(hp + unit.getHp(), unit.getMaxHp()));
    }

    @Override
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                '}';
    }
}
