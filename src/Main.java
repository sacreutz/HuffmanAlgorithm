import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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

        for (int i = 0; i < listOfFiles.length; i++) {
            //String fileName = (i + 1) + "_encoded.txt";

            File inputFile = listOfFiles[i];
            String fileName = inputFile.getName() + "_encoded.txt";
            String fileName2 = inputFile.getName() + "_decoded.txt";
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            ArrayList<Character> allBytes = new ArrayList<Character>();
//            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
//                int singleCharInt;
//                char singleChar;
//                while ((singleCharInt = bufferedInputStream.read()) != -1) {
//                    singleChar = (char) singleCharInt;
//                    System.out.print(singleChar);
//                    allBytes.add(singleChar);
//                }

                byte [] fileBytes = Files.readAllBytes(inputFile.toPath());
                char singleChar;
                for(byte b : fileBytes) {
                    singleChar = (char) b;
                  //  System.out.print(singleChar);
                    allBytes.add(singleChar);
                }


                File outputFile = new File(fileName);
                File outputFile2 = new File(fileName2);
                BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
                BufferedWriter output2 = new BufferedWriter(new FileWriter(outputFile2));
                HuffmanCodec.writeToFileEncoded(allBytes, output, output2);



                output.close();
                output2.close();

            }

            for (int i = 0; i < listOfFiles.length; i ++) {
                String fileName3 = listOfFiles[i].getName() + "_debug.txt";
                File outputFile3 = new File(fileName3);
                BufferedWriter output3 = new BufferedWriter(new FileWriter(outputFile3));
                System.out.println("testing " + listOfFiles[i].getName() + " and " + listOfFiles[i].getName() + "_decoded.txt");
                boolean testResult = HuffmanCodec.testAreEqual();
                if (testResult) {
                    System.out.println("OK");
                    output3.write(listOfFiles[i].getName() + " and " + listOfFiles[i].getName() + "_decoded.txt are equal!!" );
                } else {
                    System.out.println("not ok");
                }

                output3.close();
            }

        }

}