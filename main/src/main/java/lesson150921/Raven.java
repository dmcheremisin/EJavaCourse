package lesson150921;

/**
 * Created by dmitr on 17.08.2017.
 */
public class Raven extends Pet implements Chirikable {

    @Override
    public void chirick() {
        System.out.println("Chirick");
    }

    @Override
    public void special() {
        chirick();
    }
}
