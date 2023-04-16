import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.Person;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException {

        // Working With Date
//        workingWithDate();

        // Copying files with readers and buffers
//        copyFile();

        //Copy files with Path and Files classes
//        copyFileWithPath();

        int[] arr = {2,3,5,1,3};
        List<Boolean> res = kidsWithCandies(arr, 3);
        System.out.println(res);


        //Parse JSON
//        parseJSON();

    }

    //Parse JSON
    // google-gson link
    //https://github.com/google/gson
    static void parseJSON() throws IOException {
        String fileName = "files/data.json";

        Gson gson = new Gson();
        try (
                FileReader fileReader = new FileReader(fileName);
                JsonReader reader = new JsonReader(fileReader);
        ){
            Person[] data = gson.fromJson(reader, Person[].class);
            for (Person person : data) {
                System.out.println(person);
            }
        }
    }


    //Copy files with Path and Files classes
    static void copyFileWithPath() {
        Path sourceFile = Paths.get("files", "loremipsum.txt");
        Path targetFile = Paths.get("files", "target1.txt");

        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    // Copying files with readers and buffers
    static void copyFile() {
        String sourceFile = "files/loremipsum.txt";

        String targetFile = "files/target.txt";

        try (
                FileReader fileReader = new FileReader(sourceFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(targetFile);
                ) {

            while(true) {
                String line = bufferedReader.readLine();
                if(line == null) {
                    break;
                }

                fileWriter.write(line + "\n");
                System.out.println("line: " + line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Working With Date
    static void workingWithDate() {
        // Current time:
        Date now = new Date();
        System.out.println(now);

        // Particular time:

        GregorianCalendar gc = new GregorianCalendar(2009, 1, 28);
        Date d1 = gc.getTime();
        System.out.println(d1);

        gc.add(GregorianCalendar.DATE, 1);
        Date d2 = gc.getTime();
        System.out.println(d2);

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(d2));

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDate ld = LocalDate.of(2009, 1, 28);
        System.out.println(ld);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        System.out.println(dtf.format(ld));
    }



    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();

        int i = 0;
        int count = 0;
        int greatestCandy = 0;
        while(i < candies.length){
            greatestCandy = candies[i] + extraCandies;
            for(int j = 0; j < candies.length; j++) {
                if(greatestCandy >= candies[j]) count++;
            }
            if(count >= candies.length){
                res.add(true);
            } else res.add(false);
            count = 0;
            i++;
        }
        return res;
    }
}