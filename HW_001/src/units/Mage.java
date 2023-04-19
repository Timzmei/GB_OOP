package units;

public class Mage extends Unit implements Healer, Warrior{

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

    @Override
    public void healer(Unit unit, int hp) {
        unit.setHp(Math.min(hp + unit.getHp(), unit.getMaxHp()));
    }

}
