package units;

public class Crossbowman extends Unit implements Warrior{
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
