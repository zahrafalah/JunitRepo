import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Source {
    private String isValid = "false";

    public void run() {
        try {
            List<String> data = readFile("src\\main\\resources\\urinal.dat");
            List<String> temp = new ArrayList<>();

            for (String str : data) {
                if (isValid.equalsIgnoreCase(str)) {
                    temp.add(str);
                } else {
                    List<Integer> inputs = stringToIntegerList(str);
                    temp.add(countUrinals(inputs));
                }
            }

            for (String s : temp) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Integer> stringToIntegerList(String input) {
        String[] split = input.split("");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            integerList.add(Integer.valueOf(split[i]));
        }
        return integerList;
    }

    public String countUrinals(List<Integer> inputs) {
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

        return String.valueOf(count);
    }

    public List<String> readFile(String filename) throws FileNotFoundException {
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

    public boolean goodString(String input) {
        Pattern p = Pattern.compile("[01]+");
        Matcher m = p.matcher(input);
        boolean isValid = m.matches();
        return isValid;
    }
}
