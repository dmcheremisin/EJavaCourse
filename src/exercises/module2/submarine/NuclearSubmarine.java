package exercises.module2.submarine;

import exercises.module2.annotation.EngineAnnotation;

/**
 * @author dmch0916
 *         Date: 23.08.2017
 *         Time: 19:03
 *
 * {@link EngineAnnotation}
 */
@EngineAnnotation(manufacturer = "Electrosila", model = "X", series = 23)
public class NuclearSubmarine {

    private SubmarineEngine submarineEngine = new SubmarineEngine(55.5);

    public static void main(String[] args) {
        NuclearSubmarine ns = new NuclearSubmarine();
        ns.submarineEngine.startAVGMoving();
        ns.submarineEngine.startMoving(1000);
    }

    public static class SubmarineEngine {
        private static final int AVG_SPEED = 100;
        private static final int MAX_SPEED = 150;

        private double enginePower;
        private int speed = 0;

        public SubmarineEngine(double enginePower) {
            if (this.enginePower > 100) {
                this.enginePower = 100;
            } else if (enginePower < 0) {
                this.enginePower = 1;
            } else {
                this.enginePower = enginePower;
            }
        }

        private void startAVGMoving(){
            this.speed = AVG_SPEED;
            System.out.println("Moving with speed = " + this.speed);
        }

        private void startMoving(int speed){
            int countedSpeed = (int) enginePower / 10 * speed;
            if (countedSpeed > MAX_SPEED) {
                this.speed = MAX_SPEED;
            } else {
                this.speed = countedSpeed;
            }
            System.out.println("Moving with speed = " + this.speed);
        }

        private void stopMoving(){
            speed = 0;
            System.out.println("Stopped moving!");
        }

    }

}