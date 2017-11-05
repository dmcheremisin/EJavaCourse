package lesson150921;

/**
 * Created by dmitr on 13.08.2017.
 */
public class PetCare {


    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Turtle turtle = new Turtle();
        Parrot parrot = new Parrot();
        Raven raven = new Raven();

        care(cat, dog, parrot, raven);
    }

    public static void care(Pet... pets){
        for (Pet pet: pets) {
            pet.care();
        }
    }


}
