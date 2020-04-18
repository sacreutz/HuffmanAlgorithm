import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
      //opens and closes input and output and calls HuffmanCodec class functions


        //which do the actual input/output

        String test1 = "this is an example for huffman encoding";

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        File folder = new File(s + "\\src\\Inputfiles");
        File[] listOfFiles = folder.listFiles();

//        for (int i = 0; i < listOfFiles.length; i++) {
//            String fileName = "out" + (i + 1) + ".txt";
//            File outputFile = new File(fileName);
//            BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
//        }


        String test = "ABCD1%$^";
        System.out.println("Original Text = "+test);
        String s2 = HuffmanAlgorithm.encode(test);
        HuffmanAlgorithm.decode(s2);







    }
}
