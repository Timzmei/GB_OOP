package units;

public class Monk extends Unit implements Healer{
    public Monk() {
        super(String.format("Monk #%d", ++Monk.number));
        super.faction = "Asylum";
        super.cost = 550;
        super.damage = 15;
        super.defense = 22;
        super.level = 3;
        super.maxHp = 55;
        super.hp = maxHp;

        super.movement = 19;
        super.speed = 5;
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
