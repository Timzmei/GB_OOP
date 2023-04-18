package units;

public class Pikeman extends Unit{
    public Pikeman() {
        super(String.format("Pikeman #%d", ++Pikeman.number));
        super.faction = "Asylum";
        super.cost = 150;
        super.damage = 8;
        super.defense = 14;
        super.level = 2;
        super.maxHp = 30;
        super.hp = maxHp;

        super.movement = 19;
        super.speed = 4;
    }

    @Override
    public String toString() {
        return "Pikeman{" +
                "name='" + name + '\'' +
                '}';
    }
}
