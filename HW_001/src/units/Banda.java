package units;

import java.util.ArrayList;
import java.util.Comparator;

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

    public void sortList() {
        unitArrayList.sort(new Comparator<Unit>() {

            @Override
            public int compare(Unit o1, Unit o2) {
                return o2.speed - o1.speed;
            }

        });
    }


}
