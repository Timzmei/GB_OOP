package units;

public class Peasant extends Unit{

    public Peasant() {
        super(String.format("Peasant #%d", ++Peasant.number));
        super.faction = "Haven";
        super.cost = 15;
        super.damage = 3;
        super.defense = 7;
        super.level = 1;
        super.maxHp = 10;
        super.hp = maxHp;

        super.movement = 18;
        super.speed = 2;
    }

    @Override
    public String toString() {
        return "Peasant{" +
                "name='" + name + '\'' +
                '}';
    }
}
