import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
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

    @Test
    public void testCountUrinals() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(1);
        String out = src.countUrinals(list);
        Assertions.assertEquals("0", out);

        List<Integer> list2 = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        String out2 = src.countUrinals(list);
        Assertions.assertEquals("3", out2);
    }
}