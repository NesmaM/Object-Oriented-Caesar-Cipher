import edu.duke.*;
/**
 * @author (Nesma Abouzaid) 
 * @version (07/10/2023)
 */
public class TestCaesarCipherTwo {
    
    private String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < message.length(); i += 2) {
            char ch = message.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }
    
     private int[] countLetters(String encrypt) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i = 0; i < encrypt.length(); i++) {
            char ch = Character.toLowerCase(encrypt.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != - 1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
     private int maxIndex(int[] freqs) {
        int maxDex = 0;
        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] > freqs[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }
    
    public void breakCaesarCipher(String input) {
        int[] freqs = countLetters(input);
        int[] freqs1 = countLetters(input);
        int key1 = maxIndex(freqs);
        int key2 = maxIndex(freqs1);
    }
    
    public void simpleTests(){
       FileResource f = new FileResource();
       String fAsString = f.asString();
       CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
       String fEncryptedTwo = cc.encrypt(fAsString);
       System.out.println("Encrypted message = " + fEncryptedTwo);
       String fDecryptedTwo = cc.decrypt(fEncryptedTwo);
       System.out.println("Decrypted message = " + fDecryptedTwo);
    }
}
