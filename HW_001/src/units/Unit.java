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
    protected Banda banda;

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


    public Unit(String name, String faction, int cost, int level, int defense, int damage, int maxHp, int hp, int movement, int speed, int initiative, Banda banda, int x, int y) {
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
        this.coordinate = new Coordinate(x, y);
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
        this.hp = Math.max(divHp, 0);
    }

    @Override
    public String getInfo() {
        return toString();
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

    public Unit findNearUnit(ArrayList<Unit> banda){
        Unit nearUnit = null;
        float minDist = Float.MAX_VALUE;
        for (Unit unit : banda) {
            if (!unit.banda.getName().equals(this.banda.getName())) {
                float dist = unit.coordinate.distance(this.coordinate);
                if (minDist > dist) {
                    nearUnit = unit;
                    minDist = dist;
                }
            }
        }
        return nearUnit;
    }

    @Override
    public String toString() {
        return name +
                " Hp:" + hp +
                " Dfns:" + defense +
                " Dmg:" + damage;
    }

    @Override
    public void step(ArrayList<Unit> enemy) {
        if (die()) {
            return;
        }
        Unit target = findNearUnit(enemy);
        if (target.coordinate.distance(this.coordinate) < 2) {
            attack(target);
        }else {
            move(target);
        }
    }

    @Override
    public String introduce() {
        return this + " " + this.name;
    }

    protected void move(Unit target){
        int dx = target.coordinate.distanceXY(this.coordinate)[0];
        int dy = target.coordinate.distanceXY(this.coordinate)[1];
        if (Math.abs(dx) < Math.abs(dy)){
            moveY(dx, dy, true);
        }else {
            moveX(dx, dy, true);
        }
    }

    private void moveX(int dx, int dy, boolean flag){
        if (dx > 0) {
            if (isEmptyPosition(this.coordinate.x-1, this.coordinate.y)) {
                this.coordinate.x--;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.coordinate.x+1, this.coordinate.y)) {
                this.coordinate.x++;
            }else if(flag){
                moveY(dx,dy, false);
            }
        }
    }
    private void moveY(int dx, int dy, boolean flag){
        if (dy > 0) {
            if (isEmptyPosition(this.coordinate.x, this.coordinate.y-1)) {
                this.coordinate.y--;
            }else if(flag){
                moveX(dx,dy, false);
            }
        }else {
            if (isEmptyPosition(this.coordinate.x, this.coordinate.y+1)) {
                this.coordinate.y++;
            }else if(flag){
                moveX(dx,dy, false);
            }
        }
    }



    protected boolean isEmptyPosition(int x, int y){
        for (Unit unit: banda.getUnitArrayList()) {
            if (unit.coordinate.x == x && unit.coordinate.y == y) {
                if (!unit.die()) {
                    return false;
                }
            }
        }
        return true;
    }
}
