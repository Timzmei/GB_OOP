package units;

public class Sniper extends Unit{
    public Sniper() {
        super(String.format("Sniper #%d", ++Sniper.number));
        super.faction = "Asylum";
        super.cost = 440;
        super.damage = 30;
        super.defense = 10;
        super.level = 3;
        super.maxHp = 40;
        super.hp = maxHp;

        super.movement = 19;
        super.speed = 5;
    }

    @Override
    public String toString() {
        return "Sniper{" +
                "name='" + name + '\'' +
                '}';
    }
}
