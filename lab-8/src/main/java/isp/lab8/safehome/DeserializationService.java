package isp.lab8.safehome;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeserializationService {
    private DeserializationService() {
        // just to hide access to the constructor
    }

    /**
     * This method read all files from ./data directory and
     * deserialize the content of the files to an {@link AccessLog} and
     * add that {@link AccessLog} to accessLogs
     */
    public static List<AccessLog> deserializeFiles() {
        final List<AccessLog> accessLogs = new ArrayList<>();
        File folder = new File("lab-8/data");
        String[] folderFiles = folder.list();

        if (folderFiles != null) {
            for (String fileName : folderFiles) {
                try (final FileInputStream fileInputStream = new FileInputStream(folder + "/" + fileName);
                     final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                    final AccessLog accessLogFromFile = (AccessLog) objectInputStream.readObject();
                    accessLogs.add(accessLogFromFile);

                } catch (FileNotFoundException e) {
                    System.err.println("The file was not found or can not be created because: " + e.getMessage());
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Some error occurs: " + e.getMessage());
                }
            }
        } else {
            System.err.println("Not a valid directory: " + folder.toString());
        }

        return accessLogs;
    }
}
