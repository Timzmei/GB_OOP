import units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Unit> banda1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda1.add(new Peasant(banda1));
                    break;
                case 1:
                    banda1.add(new Mage(banda1));
                    break;
                case 2:
                    banda1.add(new Crossbowman(banda1));
                    break;
                case 3:
                    banda1.add(new Bandit(banda1));
                    break;
            }
        }

        ArrayList<Unit> banda2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    banda2.add(new Peasant(banda2));
                    break;
                case 1:
                    banda2.add(new Mage(banda2));
                    break;
                case 2:
                    banda2.add(new Sniper(banda2));
                    break;
                case 3:
                    banda2.add(new Monk(banda2));
                    break;
            }
        }

        ArrayList<Unit> team3 = new ArrayList<Unit>();
        team3.addAll(banda1);
        team3.addAll(banda2);
        team3.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());

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