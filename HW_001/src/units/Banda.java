package units;

import java.util.ArrayList;

public class Banda {

    private String name;
    private ArrayList<Unit> unitArrayList;

    public Banda(String name) {
        this.name = name;
        unitArrayList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Unit> getUnitArrayList() {
        return unitArrayList;
    }

    public void addUnit(Unit unit) {
        this.unitArrayList.add(unit);
    }
}
