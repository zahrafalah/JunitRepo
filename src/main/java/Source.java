import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Source {

    static String isValid = "false";

    public static void run() {
        try {
            List<String> data = readFile("src\\main\\resources\\urinal.dat");
            List<String> temp = new ArrayList<>();

            for (String str : data) {
                if (isValid.equalsIgnoreCase(str)) {
                    temp.add(str);
                    System.out.println(str);
                } else {
                    List<Integer> inputs = integerToString(str);
                    temp.add(countUrinals(inputs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> integerToString(String input) {
        String[] split = input.split("");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            integerList.add(Integer.valueOf(split[i]));
        }
        return integerList;
    }

    public static String countUrinals(List<Integer> inputs) {
        int count = 0;
        Integer prev = null;
        Integer curr = null;
        Integer next = null;
        for (int i = 0; i < inputs.size() - 1; i++) {
            next = inputs.get(i + 1);
            curr = inputs.get(i);
            if (curr == 0) {
                if (next == 0) {
                    if (Objects.isNull(prev)) {
                        count++;
                        curr = 1;
                    } else if (prev == 0) {
                        count++;
                        curr = 1;
                    }
                }
            }
            prev = curr;
        }
        if (prev == 0 && next == 0)
            count++;
        System.out.println(count);
        return String.valueOf(count);
    }

    public static List<String> readFile(String filename) throws FileNotFoundException {
        List<String> data = new ArrayList<>();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (goodString(line)) {
                data.add(line);
            }
        }
        if (scanner != null)
            scanner.close();

        return data;
    }

    public static boolean goodString(String input) {
        Pattern p = Pattern.compile("[01]+");
        Matcher m = p.matcher(input);
        boolean isValid = m.matches();
        return isValid;
//        if (b == false) {
//            return isValid;
//        }
//        return input;
    }
//    public static Boolean goodString(String str) { // checks to see if the string is valid
//        System.out.println("Not yet implemented!");
//        return true;
//    }

    public String getString() {
        System.out.println("Not yet implemented!");
        return null;
    }

    public void openFile() {
        System.out.println("Not yet implemented!");

    }
//    public int countUrinals(){
//        System.out.println("Not yet implemented!");
//        return 0;
//    }
}
