package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Unit implements GameInterface{

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
    protected int initiative;
    protected ArrayList<Unit> banda;

    protected Coordinate coordinate;

    static {
        Unit.number = 0;
        Unit.r = new Random();
    }

//    public Unit() {
//        this(String.format("Hero #%d", ++Unit.number));
//    }

//    public Unit(String name) {
//        this.name = name;
//    }


    public Unit(String name, String faction, int cost, int level, int defense, int damage, int maxHp, int hp, int movement, int speed, int initiative, ArrayList banda) {
        this.name = name;
        this.faction = faction;
        this.cost = cost;
        this.level = level;
        this.defense = defense;
        this.damage = damage;
        this.maxHp = maxHp;
        this.hp = hp;
        this.movement = movement;
        this.speed = speed;
        this.initiative = initiative;
        this.banda = banda;
        this.coordinate = new Coordinate(0, 0);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String getFaction() {
        return faction;
    }

    public int getCost() {
        return cost;
    }

    public int getMaxHp() {
        return maxHp;
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

    @Override
    public void getInfo() {
        System.out.println("Unit{" +
                "name='" + name + '\'' +
                ", faction='" + faction + '\'' +
                ", cost=" + cost +
                ", level=" + level +
                ", defense=" + defense +
                ", damage=" + damage +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                ", movement=" + movement +
                ", speed=" + speed +
                '}');
    }

    @Override
    public void step(ArrayList<Unit> enemy) {

    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    boolean die(){
        if (hp <= 0) {
            return true;
        }else{
            return false;
        }
    }

    void attack(Unit target){
        target.setHp(damage);
    }

    public Unit findNearUnit(ArrayList<Unit> team){
        Unit nearUnit = null;
        float minDist = Float.MAX_VALUE;
        for (Unit unit : team) {
            float dist = unit.coordinate.distance(this.coordinate);
            if (minDist > dist) {
                nearUnit = unit;
                minDist = dist;
            }
        }
        return nearUnit;
    }


}
