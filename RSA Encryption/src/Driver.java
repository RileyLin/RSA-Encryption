import javax.swing.*;
import javax.swing.text.html.Option;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Riley on 9/30/2015.
 */
public class Driver {
    public static void main(String args[]) {
        String text = JOptionPane.showInputDialog("Enter text to encrypt", JOptionPane.ERROR_MESSAGE);
        Object[] options = {"Yes", "No"};
        JOptionPane.showOptionDialog(null, "Is this the message you want to encrypt : " + "\n" + "                             " +
                "" + text, "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("a.ico"), options, "");
        String number;
        number = toNumber(text);//get the number after encrypted
        String decrypt;
        decrypt = toDecrypt(number);//get the number after decrypted
        JOptionPane.showMessageDialog(null, "Message to encrypt : " + "\n" + text + "\n" + "Encrypted Numbers : " + "\n" + number);

        JOptionPane.showMessageDialog(null, "Message to encryp: " + text + "\n" + "Decrypted message: " + decrypt);
    }

    private static String toNumber(String text) {
        String su = "";
        String all = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.toCharArray()[i];//turn string into character
            int b = (int) c;//turn character into integer
            su = String.valueOf(b);
            BigInteger enc = BigInteger.valueOf(b);
            BigInteger e = new BigInteger("17");
            BigInteger n = new BigInteger("9797");//public keys
            enc = enc.modPow(e, n);
            String encrypted = "";//declare string encrypted
            encrypted = enc.toString();//turn biginteger enc into a string
            for (int k = encrypted.length(); k < 4; k++) {//if the length of the encrypted number is less than 4 then you add 0 in front of it until it is four
                encrypted = "0" + enc;
            }
            all = encrypted + all; //add number after encrypted
        }
        return all;
    }

    private static String toDecrypt(String number) {
        String dec = "";//build string
        String ch = "";//build string
        for (int op = 0; op < number.length(); op += 4) {
            String nachulai = number.substring(op, op + 4);
            BigInteger d = new BigInteger("3953");//private keys
            BigInteger n = new BigInteger("9797");
            BigInteger num = new BigInteger(nachulai);
            num = num.modPow(d, n);//decrypt the number into ascii number
            int dog = num.intValue();//turn big integer into int
            char c = (char) dog;//turn int into char
            dec = String.valueOf(c);//turn char into a string
            ch = dec + ch;
        }
        return ch;
    }
}
