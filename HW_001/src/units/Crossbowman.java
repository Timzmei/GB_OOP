package units;

public class Crossbowman extends Unit{
    public Crossbowman() {
        super(String.format("Crossbowman #%d", ++Crossbowman.number));
        super.faction = "Asylum";
        super.cost = 32;
        super.damage = 9;
        super.defense = 11;
        super.level = 1;
        super.maxHp = 10;
        super.hp = maxHp;

        super.movement = 19;
        super.speed = 2;
    }

    @Override
    public String toString() {
        return "Crossbowman{" +
                "name='" + name + '\'' +
                '}';
    }
}
