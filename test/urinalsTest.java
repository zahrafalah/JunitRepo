import org.junit.Assert;
import org.junit.Test;


public class urinalsTest {
    private junit.framework.Assert Assertions;

    static Source  src = new Source();

    @Test
    public void testGoodString() {
        Assertions.assertTrue(src.goodString("001"));
    }
}