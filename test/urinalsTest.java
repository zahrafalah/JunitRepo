import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class urinalsTest {
    private junit.framework.Assert Assertions;
    static Source src = new Source();

    @Test
    public void testGoodString() {
        Assertions.assertTrue(src.goodString("001"));
        Assertions.assertFalse(src.goodString("abc"));
        Assertions.assertFalse(src.goodString("50009"));
    }

    @Test
    public void testReadFile() {
        try {
            List<String> list = src.readFile("src\\main\\resources\\urinal.dat");
            Assertions.assertEquals(3, list.size());
        } catch (IOException e) {
        }
    }
}