package units;

public class Bandit extends Unit implements Warrior{

    public Bandit() {
        super(String.format("Bandit #%d", ++Bandit.number));
        super.faction = "Asylum";
        super.cost = 20;
        super.damage = 3;
        super.defense = 9;
        super.level = 1;
        super.maxHp = 10;
        super.hp = maxHp;
        super.movement = 23;
        super.speed = 7;
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
        return "Bandit{" +
                "name='" + name + '\'' +
                '}';
    }
}
