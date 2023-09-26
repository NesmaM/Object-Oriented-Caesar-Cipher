import edu.duke.*;
/**
 * Write a description of CaeserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher (int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftedAlphaLower = shiftedAlphabet.toLowerCase();
        for(int i = 0; i< sb.length(); i++){
            char c = sb.charAt(i);
            int idx = alphabet.indexOf(c);
            int idxLower = alphaLower.indexOf(c);
            if(Character.isLowerCase(c)){
                if(idxLower != -1){
                    c = shiftedAlphaLower.charAt(idxLower);
                    sb.setCharAt(i,c);
                }
        } else {
            if(idx != -1){
                c = shiftedAlphaLower.charAt(idx);
                sb.setCharAt(i,c);
            }
        }
      }
      return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypt = cc.encrypt(input);
        return decrypt;
    }
    
    

}
