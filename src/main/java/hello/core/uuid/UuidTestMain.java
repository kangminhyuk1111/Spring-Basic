package hello.core.uuid;

import java.util.UUID;

public class UuidTestMain {

    public static void main(String[] args) {
        final String uuid = UUID.randomUUID().toString();

        System.out.println(uuid);
    }
}
