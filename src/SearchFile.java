import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class SearchFile {



    public void selectFiles(String fileName) {
        File dir = new File(".");
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                return name.startsWith(fileName);
            }
        });
        for(File file: files) {
            System.out.println(file);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System. in);
        System.out.println("Enter the file name: ");
        String fileName = input.nextLine();
        System.out.println("You entered " + fileName);
        SearchFile sf = new SearchFile();
        sf.selectFiles(fileName);


    }
}
