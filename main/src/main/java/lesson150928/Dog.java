package lesson150928;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 15:04
 */
public class Dog {
    BrainState brainState = Dog.this.new BadMood();

    private void bite() {
        System.out.println("bites");
    }

    private void bark() {
        System.out.println("barks");
    }

    private void eat() {
        System.out.println("eats");
    }

    private void wag() {
        System.out.println("wags");
    }

    public void feed() {
        System.out.println(" ---> feed");
        brainState.feed();

    }

    public void stroke() {
        System.out.println(" ---> stroke");
        brainState.stroke();
    }

    interface BrainState {

        void feed();

        void stroke();
    }

    class GoodMood implements BrainState {

        private static final int MAX_STROKES = 3;
        private int count;

        @Override
        public void feed() {
            Dog.this.eat();
            Dog.this.wag();
        }

        @Override
        public void stroke() {
            wag();
            bark();
            count++;
            if (count > MAX_STROKES) {
                brainState = new BadMood();
            }
        }

    }

    class BadMood implements BrainState {
        @Override
        public void feed() {
            eat();
            brainState = new GoodMood();
        }

        @Override
        public void stroke() {
            bite();
        }
    }
}
