package units;

public class Mage extends Unit{

    public Mage() {
        super(String.format("Mage #%d", ++Mage.number));
        super.faction = "Academy";
        super.cost = 160;
        super.damage = 4;
        super.defense = 12;
        super.level = 2;
        super.maxHp = 16;
        super.hp = maxHp;

        super.movement = 19;
        super.speed = 5;
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                '}';
    }
}
