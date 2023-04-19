import units.*;

public class Main {

    public static void main(String[] args) {

        Unit bandit = new Bandit();
        Unit sniper = new Sniper();
        Unit mage = new Mage();
        Unit crossbowman = new Crossbowman();
        Unit monk = new Monk();
        Unit peasant = new Peasant();
        Unit pikeman = new Pikeman();

        System.out.println(bandit);
        System.out.println(sniper);
        System.out.println(mage);
        System.out.println(crossbowman);
        System.out.println(monk);
        System.out.println(peasant);
        System.out.println(pikeman);

        System.out.println("хп бандита до урона: " + bandit.getHp());
        ((Sniper) sniper).attack(bandit);
        System.out.println("хп бандита после урона: " + bandit.getHp());
    }



}