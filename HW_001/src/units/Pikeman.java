package units;

public class Pikeman extends Unit implements Warrior{
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
    public String toString() {
        return "Pikeman{" +
                "name='" + name + '\'' +
                '}';
    }
}
