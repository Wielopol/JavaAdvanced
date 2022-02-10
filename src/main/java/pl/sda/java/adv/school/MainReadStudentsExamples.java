package pl.sda.java.adv.school;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainReadStudentsExamples {
    public static void main(String[] args) throws IOException {
        Path path1 = Path.of("C:\\Users\\karol\\IdeaProjects\\JavaAdvanced\\students.csv");
        Path path2 = Path.of("C:/Users/karol/IdeaProjects/JavaAdvanced/students.csv");
        Path path3 = Path.of("C:","Users","karol","IdeaProjects","JavaAdvanced","students.csv");
        Path path4 = Path.of("c:","users","karol","ideaprojects","javaadvanced","students.csv");
        Path path5 = Path.of(URI.create("file:///C:/Users/karol/IdeaProjects/JavaAdvanced/students.csv"));
        Path path6 = Path.of("example/students.csv");

        for (Path path : List.of(path1,path2,path3,path4,path5,path6)) {
            boolean exists = Files.exists(path);
            System.out.printf("%s: %b\n",path,exists);
        }

        File file1 = new File("C:\\Users\\karol\\IdeaProjects\\JavaAdvanced\\students.csv");
        File file2 = new File("C:/Users/karol/IdeaProjects/JavaAdvanced/student.csv");
        File file3 = new File("example/students.csv");

        System.out.println();

        for (File file : List.of(file1,file2,file3)) {
            boolean exists = file.exists();
            System.out.printf("%s: %b\n",file,exists);
        }

        System.out.println();

//        printContentsInIncorrectWay(file3);

//        printContentsInCorrectOldSchoolWay(file2);

        printContentsInModernWay(file1);
    }

    private static void printContentsInIncorrectWay(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

//        bufferedReader.lines().forEach(System.out::println);
    }

    private static void printContentsInCorrectOldSchoolWay(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.err.println("Reading file");
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printContentsInModernWay (File file) throws IOException {
        try(FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        }
//        } catch (IOException e) {
//            System.err.println("Reading file");
//            e.printStackTrace();
//        }
    }
}
