public class SecretTest {
    public static void main(String[] args) {
        //Secret msg = new Secret("Interest is a key to success. People with passion are fortunate.");\
        BautistaRaquelSecret msg = new BautistaRaquelSecret("Interest is a key to success. People with passion are fortunate.");
        System.out.println(msg);

        msg.encrypt();
        System.out.println(msg);

        msg.decrypt();
        System.out.println(msg);
    }
}