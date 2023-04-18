package units;

public class Bandit extends Unit{

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
        if (this.damage > unit.defense) {
            unit.setHp(unit.getHp() - this.damage + unit.getDefense());
        } else {
            unit.setHp((int) (unit.getHp() - (this.damage / unit.getDefense()) * 1.5));
        }
    }

    @Override
    public String toString() {
        return "Bandit{" +
                "name='" + name + '\'' +
                '}';
    }
}
