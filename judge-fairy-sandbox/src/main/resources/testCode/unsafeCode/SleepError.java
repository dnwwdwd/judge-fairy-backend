import lombok.SneakyThrows;

/**
 * 无限睡眠
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        long ONE_HOUR = 60 * 60 * 100L;
        Thread.sleep(ONE_HOUR);
        System.out.println("睡完了");
    }
}
