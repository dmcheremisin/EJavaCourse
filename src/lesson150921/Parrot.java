package lesson150921;

/**
 * Created by dmitr on 13.08.2017.
 */
public class Parrot extends Pet implements Chirikable{

    @Override
    public void chirick() {
        System.out.println("Сам дурак");
    }

    @Override
    public void special() {
        chirick();
    }
}
