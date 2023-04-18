package units;

public class Monk extends Unit{
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
    public String toString() {
        return "Monk{" +
                "name='" + name + '\'' +
                '}';
    }
}
