import units.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Unit> list = new ArrayList<>();
        list.add(new Bandit());
        list.add(new Sniper());
        list.add(new Mage());
        list.add(new Crossbowman());
        list.add(new Monk());
        list.add(new Peasant());
        list.add(new Pikeman());

        list.forEach(Unit::getInfo);

//        System.out.println("хп бандита до урона: " + bandit.getHp());
//        ((Sniper) sniper).attack(bandit);
//        System.out.println("хп бандита после урона: " + bandit.getHp());
    }



}