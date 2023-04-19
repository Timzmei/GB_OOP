package units;

public class Peasant extends Unit implements Warrior, Healer{

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

    @Override
    public void healer(Unit unit, int hp) {
        unit.setHp(Math.min(hp/2 + unit.getHp(), unit.getMaxHp()));
    }

    @Override
    public void attack(Unit unit) {
        System.out.println(this.name + " attack " + unit.name);

        if (this.damage > unit.defense) {
            setUnitDamage(unit, this.damage + unit.getDefense());
        } else {
            setUnitDamage(unit, (this.damage / unit.getDefense()));
        }

    }

    @Override
    public void setUnitDamage(Unit unit, int damage) {
        if (unit.getHp() - damage > 0) {
            unit.setHp(unit.getHp() - damage);
        } else {
            unit.setHp(0);
        }
    }
}
