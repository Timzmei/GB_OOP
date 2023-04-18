package units;

import java.util.Random;

public abstract class Unit {

    protected static int number;
    protected static Random r;

    protected String name;
    protected  String faction;
    protected int cost;
    protected int level;
    protected int defense;
    protected int damage;
    protected int hp;
    protected int maxHp;
    protected int movement;
    protected int speed;

    static {
        Unit.number = 0;
        Unit.r = new Random();
    }

    public Unit() {
        this(String.format("Hero #%d", ++Unit.number));
    }

    public Unit(String name) {
        this.name = name;
    }

    public String getFaction() {
        return faction;
    }

    public int getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }

    public int getDefense() {
        return defense;
    }

    public int getDamage() {
        return damage;
    }

    public int getMovement() {
        return movement;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int divHp) {
        if (divHp <= 0) {
            this.hp = 0;
        } else {
            this.hp = divHp;
        }
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    public void attack(Unit unit) {
        System.out.println(this.name + " attack " + unit.name);

        if (this.damage > unit.defense) {
            setUnitDamage(unit, this.damage + unit.getDefense());
        } else {
            setUnitDamage(unit, (this.damage / unit.getDefense()));
        }

    }

    private void setUnitDamage(Unit unit, int damage) {

        if (unit.getHp() - damage > 0) {
            unit.setHp(unit.getHp() - damage);
        } else {
            unit.setHp(0);
        }
    }

    public void healed(int hp) {
        this.hp = Math.min(hp + this.hp, this.maxHp);
    }





}
