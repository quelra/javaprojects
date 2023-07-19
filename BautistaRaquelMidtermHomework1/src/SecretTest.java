public class SecretTest {
    public static void main(String[]args){
        Secret sample = new Secret("The quick brown fox jumped over the lazy dog");
        System.out.println("Message to be encrypted: ");
        System.out.println(sample.toString());
        sample.encrypt(); /*Encrypt by invoking the encrypt method*/
        System.out.println("Encrypted Message: ");
        System.out.println(sample.toString());
        System.out.println("Result of Decryption: ");
        sample = new Secret(sample.decrypt()); /*Decrypt by invoking the decrypt method*/
        System.out.println(sample.toString());
        System.exit(0);
    }
} //end of SecretTest class
