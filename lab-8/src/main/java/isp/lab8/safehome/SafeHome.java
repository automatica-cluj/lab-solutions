package isp.lab8.safehome;

public class SafeHome {

    public static void main(String[] args) {
        DeserializationService deserializationService = new DeserializationService();
        deserializationService.deserializeFiles();
        deserializationService.getAccessLogs().forEach(System.out::println);
    }
}
