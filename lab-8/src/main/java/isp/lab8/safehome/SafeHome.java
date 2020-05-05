package isp.lab8.safehome;

public class SafeHome {

    public static void main(String[] args) {
        DeserializationService.deserializeFiles().forEach(System.out::println);
    }
}
