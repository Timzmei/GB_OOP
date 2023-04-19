package units;

public class Sniper extends Unit implements Warrior {
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
