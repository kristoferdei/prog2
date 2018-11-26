//javac l334d14.java
//java l334d14

public class l334d14 {

    public static String toLeet(String s){
        for(int i=0; i < alphabetLength; i++){
             s = s.replace(norm[i].toLowerCase(), leet[i]);
             s = s.replace(norm[i], leet[i]);
        }
        return s;
    }

    public static String toNorm(String s){
        for(int i=0; i < alphabetLength; i++){
            s = s.replace(leet[i], norm[i]);
            s = s.replace(leet[i], norm[i].toLowerCase());
        }
        return s;
    }
    public static void main(String args[]){
        String[] testWords = {"Erdei", "Kristof"};
        String[] testLeets = {"|_337", "45|)"};
        for(int i=0; i < testWords.length; i++){
            System.out.println(testWords[i] + " -> " + toLeet(testWords[i]));
        }
        for(int i=0; i < testLeets.length; i++){
            System.out.println(testLeets[i] + " -> " + toNorm(testLeets[i]));
        }
    }
    private static final String[]   norm = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[]   leet = {"4", "8", "<", "|)", "3", "|=", "[", "4", "1", "_|", "|<", "|_", "44", "/V", "0", "|o", "O_", "|2", "5", "7", "|_|", "V", "W", "%", "`/", "2"};
    private static int alphabetLength = 26;
}
