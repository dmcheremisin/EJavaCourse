package lesson150928;

/**
 * @author dmch0916
 *         Date: 01.09.2017
 *         Time: 18:03
 */
public class Inners {

    static class A {
        int x = 0;

        class B {
            {
                //A.this.x = 10;
                x = 10;
            }
            public void change(){
                x += 20;
            }
        }
    }

    static class C {
        int x = 0;
    }

    static class D {
        private C c;

        public D(C c){
            this.c = c;
        }
        public void change () {
            c.x += 20;
        }
    }

}
