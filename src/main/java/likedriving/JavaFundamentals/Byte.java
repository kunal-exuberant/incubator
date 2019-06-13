package likedriving.JavaFundamentals;

public class Byte {

    public static void main(String[] args) {
        test();
    }


    public static byte[] test() {

        byte [] bytes = new byte[2];

        bytes = "Hello".getBytes();

        System.out.println(bytes);

        bytes = "Hello World".getBytes();

        System.out.println(bytes);

        String string = new String(bytes);

        System.out.println(string);

        return "Hello World".getBytes();

    }
}
