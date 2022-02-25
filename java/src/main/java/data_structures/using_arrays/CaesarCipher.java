package data_structures.using_arrays;

public class CaesarCipher {
    private final int encoder_decoder_size = 26;
    protected char[] encoder = new char[encoder_decoder_size];
    protected char[] decoder = new char[encoder_decoder_size];

    public CaesarCipher(int rotation) {
        for (int k =0; k < encoder_decoder_size ; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    private String transform(String original, char[ ] code) {
        char[ ] msg = original.toCharArray( );
        for (int k=0; k < msg.length; k++)
        if (Character.isUpperCase(msg[k])) {
            int j = msg[k] - 'A';
            msg[k] = code[j];
        }
        return new String(msg);
    }

    public String encrypt(String msg) {
        return this.transform(msg, this.encoder);
    }

    public String decrypt(String secret) {
        return this.transform(secret, this.decoder);
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }
}
