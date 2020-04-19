import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class HuffmanCodec {
    // input is an array of frequencies, indexed by character code

        public static String decodedProperty = "";
        public static String stringData = "";
        public static void writeToFileEncoded(ArrayList<Character> data, BufferedWriter output, BufferedWriter output2) throws IOException {
            decodedProperty = "";
            stringData = "";
            String s2 = "";
            for (char c : data) {
                s2 += String.valueOf(c);
            }
            stringData += s2;
            String encoded = HuffmanAlgorithm.encode(s2);
           // System.out.println(encoded + "encoded");
            output.write(encoded);
            String decoded = HuffmanAlgorithm.decode(encoded);
            decodedProperty += decoded;
            output2.write(decoded);


        }

        public static boolean testAreEqual() {
            if (stringData.equals(decodedProperty)) {
                return true;
            }
            else {
                return false;
            }
        }

    public static String bytePresentation(byte inputByte ) {

        if ( inputByte =='\n' )return "\\n";
        if ( inputByte =='\r' )return "\\r";
        if ( inputByte =='\t' )return "\\t";

        if ( inputByte >=' ' && inputByte <='~' )
            return "'" + inputByte +"'";

        String st = String.format("%02X", inputByte);
            return st;
       // return TO_HEXADECIMAL( inputByte);  // like 0xf7

    }

    private static byte[] readContentIntoByteArray(File file)
    {
        FileInputStream fileInputStream = null;
        byte[] bFile = new byte[(int) file.length()];
        try
        {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
//            for (int i = 0; i < bFile.length; i++)
//            {
//                System.out.print((char) bFile[i]);
//            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bFile;
    }


    public static byte[] read(File file) throws IOException {

        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        }finally {
            try {
                if (ous != null)
                    ous.close();
            } catch (IOException e) {
            }

            try {
                if (ios != null)
                    ios.close();
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }
}