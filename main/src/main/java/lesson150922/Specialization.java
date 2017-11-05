package lesson150922;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Specialization {
    static class Pet {
        public void feed() {
            System.out.println("feeding pet");
        }
    }

    static class Cat extends Pet{

        @Override
        public void feed() {
            super.feed();
            murr();
        }
        public void combBehindEar(){
            murr();
        }
        private void murr() {
            System.out.println("murrrrrr");
        }
    }

}
