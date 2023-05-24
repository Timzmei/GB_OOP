import units.*;

import java.nio.charset.Charset;
import java.util.*;

public class Main {

    static public Banda banda1 = new Banda("banda1");
    static public Banda banda2 = new Banda("banda2");
    static public ArrayList<Unit> allTeam = new ArrayList<>();

    public static void main(String[] args) {


        for (int i = 1; i < 11; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda1.addUnit(new Peasant(banda1, i, 1));
                    break;
                case 1:
                    banda1.addUnit(new Mage(banda1, i, 1));
                    break;
                case 2:
                    banda1.addUnit(new Infantry(banda1, i, 1));
                    break;
                case 3:
                    banda1.addUnit(new Infantry(banda1, i, 1));
                    break;
            }
        }

        for (int i = 1; i < 11; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda2.addUnit(new Peasant(banda2, i, 10));
                    break;
                case 1:
                    banda2.addUnit(new Mage(banda2,i, 10));
                    break;
                case 2:
                    banda2.addUnit(new Pikeman(banda2, i, 10));
                    break;
                case 3:
                    banda2.addUnit(new Monk(banda2, i, 10));
                    break;
            }
        }

        allTeam.addAll(banda1.getUnitArrayList());
        allTeam.addAll(banda2.getUnitArrayList());
        allTeam.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());


        System.out.println(Charset.defaultCharset());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            View.view();
            scanner.nextLine();
            for (Unit unit : allTeam) {
                if (banda1.getUnitArrayList().contains(unit)) {
                    unit.step(banda2.getUnitArrayList());
                } else {
                    unit.step(banda1.getUnitArrayList());
                }
            }
        }
    }


}