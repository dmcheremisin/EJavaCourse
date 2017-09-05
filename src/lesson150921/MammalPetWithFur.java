package lesson150921;

/**
 * Created by dmitr on 13.08.2017.
 */
public abstract class MammalPetWithFur extends Pet{
    public abstract void comb();

//    @Override
//    public void care() {
//        super.care();
//        this.comb();
//    }


    @Override
    public void special() {
        comb();
    }
}
