package isp.lab8.exercise1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptFileService {
    private EncryptFileService() {
    }

    public static void encryptAndSaveContent(final String path) {
        try (final FileReader inputFileReader = new FileReader(path);
             final FileWriter outputFileWriter = new FileWriter(path + ".enc")) {

            // read data
            int c;

            while ((c = inputFileReader.read()) != -1) {
                outputFileWriter.write(c - 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
