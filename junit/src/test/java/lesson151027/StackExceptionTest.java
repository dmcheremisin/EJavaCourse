package lesson151027;

import lesson151027.Stack;
import org.junit.Test;

import static org.junit.Assert.fail;


/**
 * Created by Dmitrii on 13.10.2017.
 */
public class StackExceptionTest {

    @Test
    public void testPopWhenEmpty() {
        Stack<String> stack = new Stack<>(3);
        try {
            String result = stack.pop();
        } catch (Exception e) {
            fail("empty stack");
            e.printStackTrace();
        }
    }
}
