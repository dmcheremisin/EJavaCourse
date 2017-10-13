package lesson151027;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dmitrii on 13.10.2017.
 */
public class ATest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void test() throws Exception {
        final Crashable c = context.mock(Crashable.class);
        A a = new A(c);
        context.checking(new Expectations(){{
            //oneOf(c).crash();
            this.atLeast(2).of(c).crash();
        }});
        a.destroy();
    }
}