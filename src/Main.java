import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        // Working With Date
//        workingWithDate();

        // Copying files with readers and buffers
//        copyFile();

        //Copy files with Path and Files classes
//        copyFileWithPath();

        //Parse JSON
        parseJSON();

    }

    //Parse JSON
    // google-gson link
    //https://github.com/google/gson
    static void parseJSON() {
        String fileName = "files/data.json";

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
}