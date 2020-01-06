import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//import org.kohsuke.randname.RandomNameGenerator;


public class FileGenerator {
    private static File root = new File("./");
    private final String fileName;
    private final int lines;
//    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
//    final java.util.Random rand = new java.util.Random();
//    final Set<String> identifiers = new HashSet<String>();

    public FileGenerator(String fileName, int lineCount){
        this.fileName = fileName;
        this.lines = lineCount;
    }
    public void randomfileGenerator() throws IOException {
        Path fullPath = new File(root, fileName).toPath();
        CheckFile chkFile = new CheckFile();
        try (BufferedWriter bw = Files.newBufferedWriter(fullPath)) {
            for (int i = 0; i < lines; ++i) {
                String name = chkFile.randomIdentifier();
                String line = String.format("%s %n", name);
                bw.write(line);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        CFG cfg = new CFG();
        Random rand = new Random();
        int low = 3;
        int high = 10;
        int result = rand.nextInt(high - low) + low;

        Scanner scanner = new Scanner(new File("fileNames.txt"));
        List<String> myList = new ArrayList<>();
        while(scanner.hasNext()){
            myList.add(scanner.nextLine());
        }
        int numb = rand.nextInt(myList.size());
        String name = myList.get(numb);

        FileGenerator fg = new FileGenerator(name, result);
        try {
            fg.randomfileGenerator();
            File file = new File(fg.fileName);
            double bytes = file.length();
            System.out.println(fg.fileName+" "+bytes);
//            System.out.println(cfg.getSHA());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
