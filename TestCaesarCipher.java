import edu.duke.*;
import java.io.File;
import java.util.Arrays;

/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    public int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i=0; i<message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if(dex != -1){
                counts[dex] +=1;
            }
        }
        return counts;
    }
 
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int i =0; i<vals.length ; i++){
            if(vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }
    
    public void breakCaesarCipher(String input) {
        int[] freqs = countLetters(input);
        int key = maxIndex(freqs);
        CaesarCipher cc = new CaesarCipher(key);
        String decrypted = cc.decrypt(input);
        System.out.println(decrypted);
        
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String frAsString = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String frEncrypted = cc.encrypt(frAsString);
        System.out.println("Encrypted message = " + frEncrypted );
        String frDecrypted = cc.decrypt(frEncrypted);
        System.out.println("Decrypted message = " + frDecrypted );

       
    }

}
