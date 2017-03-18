import java.util.Scanner;
import java.util.Vector;

/**
 *Write a program to encrypt and decrypt strings of characters using the following ciphers:(Minimum alphabet)
 *
 *b) Vigenere cipher
 *
 * Created by mohammad on 3/12/17.
 */
public class main {

    public static void main(String[] args) {



        System.out.print("\n**************");
        System.out.print("\nVigenere cipher ");
        System.out.print("\n**************");
        Scanner scan2 = new Scanner(System.in);
        System.out.print("\nVigenere Table:\n");
        Vigenere c = new Vigenere();
        Vector<Vector<Integer>> table = c.generateVigenereTable();
        for (Vector<Integer> v:table
             ) {
            System.out.printf("\n");
            for (Integer i:v
                 ) {
                System.out.printf(" %c", i);

            }

        }
        System.out.print("\n===============\n");
        System.out.print("\nTest 1:\n");


        System.out.print("\nPlain text:");
        String m = scan2.nextLine();
        c.set_message(m);

        scan2 = new Scanner(System.in);
        System.out.print("\nplease enter your key :");
        String key = scan2.nextLine();

        c.set_key(key);

        String ct=c.Encryption();
        System.out.print("\nEncrypted text: "+ct+"\n");

        System.out.print("\nTest 2:\n");


        System.out.print("\nCipher text:");
        m = scan2.nextLine();
        c.set_cipherMessage(m);

        scan2 = new Scanner(System.in);
        System.out.print("\nplease enter your key :");
        key = scan2.nextLine();

        c.set_key(key);

        ct=c.Decryption();
        System.out.print("\nDecripted text: "+ct+"\n");


    }
}
