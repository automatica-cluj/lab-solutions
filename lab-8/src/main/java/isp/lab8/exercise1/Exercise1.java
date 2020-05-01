package isp.lab8.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Operation and path must be supplied. --operation --path. Operations supported: e / d");
            System.exit(1);
        }

        final String operation = args[0];
        final String filePath = args[1];

        if (operation.equals("e")) {
            EncryptFileService.encryptAndSaveContent(filePath);
            return;
        }

        if (operation.equals("d")) {
            DecryptFileService.decryptAndSaveContent(filePath);
            return;
        }

        System.out.println("Invalid operation value.");
    }
}
