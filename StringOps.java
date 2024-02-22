public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String s = "   Hello     to";
        System.out.println(camelCase(s));
    }

    public static String capVowelsLowRest (String string) {
        char[] small = {'a', 'e', 'i', 'o', 'u'};
        char[] capital = {'A', 'E', 'I', 'O', 'U'};
        String toPrint = "";
        boolean flag;
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            flag = true; 
            for (int j = 0; j < small.length; j++) {
                if (currentChar == small[j] || currentChar == capital[j]) {
                    toPrint += capital[j];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if ((currentChar >= 'A' && currentChar <= 'Z')) {
                    toPrint += (char) (currentChar + 32);
                } 
                else {
                    toPrint += currentChar;
                }
            }
        }
        
        return toPrint;
    }

    public static String camelCase (String string) {
            String toPrint ="";
            boolean letter1=false; //encountered first letter
            boolean newWord=true;
            for (int i=0; i<string.length(); i++) {
                char c=string.charAt(i);
                if (c==32) {
                    newWord=true;
                } else {
                    if (letter1) {
                        if (newWord) {
                            toPrint+=cap(c);
                            newWord=false;
                        } else {
                            toPrint+=unCap(c);
                        }
                    } else {
                        toPrint+=unCap(c);
                        newWord=false;
                        letter1=true;
                    }
                }
            }
            return toPrint;
    }
    public static char unCap (char c) {
        if (65<c && c<90) return(char)(c+32);
        return c;
    }
    public static char cap (char c) {
        if (97<c && c<122) return(char)(c-32);
        return c;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count =0;
        for (int i=0; i<string.length(); i++)
            if (string.charAt(i) == chr)
                count++;
        int [] toPrint = new int [count];
        count =0;
        for (int j=0; j<string.length(); j++)
            if (string.charAt(j) == chr){
                toPrint[count] = j;
                count++;
            }
        return toPrint;
    }
}
