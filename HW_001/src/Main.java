import units.*;

public class Main {

    public static void main(String[] args) {

        Bandit bandit = new Bandit();
        Sniper sniper = new Sniper();
        Mage mage = new Mage();
        Crossbowman crossbowman = new Crossbowman();
        Monk monk = new Monk();
        Peasant peasant = new Peasant();
        Pikeman pikeman = new Pikeman();

        System.out.println(bandit);
        System.out.println(sniper);
        System.out.println(mage);
        System.out.println(crossbowman);
        System.out.println(monk);
        System.out.println(peasant);
        System.out.println(pikeman);

        System.out.println("хп бандита до урона: " + bandit.getHp());
        sniper.attack(bandit);
        System.out.println("хп бандита после урона: " + bandit.getHp());
    }



}