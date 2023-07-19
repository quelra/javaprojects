/*
 * Name: BAUTISTA, Raquel S.
 * Date: May 13, 2020
 * 9378A CS 122
 * 9378B CS 122L
 */


/**
 * This class BautistaRaquelSecret implements Encryptable interface
 * using the XOR cipher encryption and decryption.
 */
public class BautistaRaquelSecret implements Encryptable{
    private String message;
    private boolean encrypted;
    private String xorKey;


    /**
     * This assigns the parameter "msg" to "message",
     *      initiates boolean encrypted to be false,
     *      and initiates a string value for the xorKey.
     * The xorKey will be used
     * @param msg is the message to be encrypted or decrypted.
     */
    public BautistaRaquelSecret (String msg) {
        message = msg;
        encrypted = false;
        xorKey = "This is the xor key for encryption and decryption.";
    }

    /**
     * This encrypts the message through the XOR cypher algorithm.
     * Algorithm:
     *      1. If message is not yet encrypted,
     *              a. create a string encryptedMessage and initiate.
     *              b. encrypt the message by applying the bitwise XOR operator to every character using the given the characters in the xorKey.
     *                     each character in the message will be XORed to the character with the same index in the xorKey,
     *                     but if the character's index in the message is equal to the length of the xorKey,
     *                     it will be XORed to the first character in the xorKey.
     *                     Thus, even if the length of the message if greater the the length of the xorKey,
     *                     it won't be a problem because of the % operator used.
     *
     *              c. The result of this will be concatenated to the encryptedMessage (alternate use is the stringBuilder).
     *      2. Assign encryptedMessage to message
     *      3. Let encrypted be true.
     */
    public void encrypt() {
        if (!encrypted) {
            String encryptedMessage = "";

            for(int i = 0; i < message.length(); i++ ){
                encryptedMessage += ((char)(message.charAt(i) ^ xorKey.charAt(i % xorKey.length())));
            }

            message = encryptedMessage;
            encrypted = true;
        }
    }
    /**
     * This decrypts the message through the XOR cypher algorithm.
     * Algorithm:
     *      1. If message is encrypted,
     *              a. create a string decryptedMessage and initiate.
     *              b. decrypt the message by applying again the bitwise XOR operator to every character using the given characters in the xorKey.
     *              c. The result of this will be concatenated to the decryptedMessage (alternate use is the stringBuilder).
     *      2. Assign decryptedMessage to message
     *      3. Let encrypted be false.
     */
    public String decrypt() {
        if (encrypted) {
            String decryptedMessage = "";

            for(int i = 0; i < message.length(); i++ ){
                decryptedMessage += ((char)(message.charAt(i) ^ xorKey.charAt(i % xorKey.length())));
            }

            message = decryptedMessage;
            encrypted = false;
        }
        return message;
    }

    /**
     * This will @return the value, true or false, of "encrypted" that tells whether the message is encrypted or not.
     */
    public boolean isEncrypted() {
        return encrypted;
    }

    /**
     * This will @return the string, "message".
     */
    public String toString() {
        return message;
    }
}