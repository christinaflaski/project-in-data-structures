import java.util.Scanner;
import java.util.NoSuchElementException;
public class DNAPalindrome {
    private static Scanner sc;
    private static boolean isDna(char c) {
        if (c == 'A' || c == 'T' || c == 'C' || c == 'G')
            return true;
        return false;
    }
    public static void main(String[] args) {
        DNAPalindrome obj = new DNAPalindrome();
        sc = new Scanner(System.in);
        System.out.println("Give DNA: ");
        String dna = sc.nextLine();
        StringDoubleEndedQueueImpl pal = new StringDoubleEndedQueueImpl();
        boolean b1=false;
        for (int i = 0; i < dna.length(); i++) {
            char c = dna.charAt(i);
            String s = Character.toString(c);
            if (isDna(c)) {
                if (s.equals("A")) {
                    pal.addFirst("T");
                } else if (s.equals("T")) {
                    pal.addFirst("A");
                } else if (s.equals("G")) {
                    pal.addFirst("C");
                } else if (s.equals("C")) {
                    pal.addFirst("G");
                }
                b1=true;
            } else {
                System.out.println("error!");
                b1=false;
                break;
            }
        }
        String s0="";
        Node current = pal.head;
        while (current != null){
            s0 += current.getItem();
            current = current.next;
        }
        if(b1==true) {
            if (s0.equals(dna))
                System.out.println("Is palindrome!");
            else
                System.out.println("Is not palindrome!");
        }
    }
}
