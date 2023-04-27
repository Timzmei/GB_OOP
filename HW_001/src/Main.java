import units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Banda banda1 = new Banda("banda1");
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda1.addUnit(new Peasant(banda1));
                    break;
                case 1:
                    banda1.addUnit(new Mage(banda1));
                    break;
                case 2:
                    banda1.addUnit(new Crossbowman(banda1));
                    break;
                case 3:
                    banda1.addUnit(new Bandit(banda1));
                    break;
            }
        }

        Banda banda2 = new Banda("banda2");
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda2.addUnit(new Peasant(banda2));
                    break;
                case 1:
                    banda2.addUnit(new Mage(banda2));
                    break;
                case 2:
                    banda2.addUnit(new Sniper(banda2));
                    break;
                case 3:
                    banda2.addUnit(new Monk(banda2));
                    break;
            }
        }

        ArrayList<Unit> team3 = new ArrayList<Unit>();
        team3.addAll(banda1.getUnitArrayList());
        team3.addAll(banda2.getUnitArrayList());
        team3.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());



        System.out.println("[Команда 1]");
        banda1.getUnitArrayList().forEach(n -> n.getInfo());
        System.out.println("\n[Команда 2]");
        banda2.getUnitArrayList().forEach(n -> n.getInfo());

        System.out.println("\n[Инициатива]");
        System.out.println(team3);

        banda1.getUnitArrayList().forEach(n -> n.step(banda2.getUnitArrayList()));
        banda2.getUnitArrayList().forEach(n -> n.step(banda1.getUnitArrayList()));
        System.out.println("\n[Команда 1]");
        banda1.getUnitArrayList().forEach(n -> n.getInfo());
        System.out.println("\n[Команда 2]");
        banda2.getUnitArrayList().forEach(n -> n.getInfo());

//        List<Unit> list = new ArrayList<>();
//        list.add(new Bandit());
//        list.add(new Sniper());
//        list.add(new Mage());
//        list.add(new Crossbowman());
//        list.add(new Monk());
//        list.add(new Peasant());
//        list.add(new Pikeman());
//
//        list.forEach(Unit::getInfo);

//        System.out.println("хп бандита до урона: " + bandit.getHp());
//        ((Sniper) sniper).attack(bandit);
//        System.out.println("хп бандита после урона: " + bandit.getHp());
    }



}