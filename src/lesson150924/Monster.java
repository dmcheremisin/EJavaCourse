package lesson150924;

import java.util.Random;

/**
 * @author dmch0916
 *         Date: 31.08.2017
 *         Time: 18:54
 */
public class Monster implements Cloneable{

    private static Random random = new Random();

    private static class Dragon extends Monster {
    }

    private static class GiantBear extends Monster {
    }

    private static class Gopnik extends Monster {
    }

    static private Monster[] monsters = {new Dragon(), new GiantBear(), new Gopnik()};

    static public Monster createMonster() {
        int monsterIndex = random.nextInt(monsters.length);
        Monster randomMonster = monsters[monsterIndex];
        try {
            Monster concreteMonster = (Monster) randomMonster.clone();
            return concreteMonster;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
