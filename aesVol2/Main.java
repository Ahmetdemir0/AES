package aesVol2;
import javax.crypto.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {

        BufferedReader ch = new BufferedReader(new InputStreamReader(System.in));
        char[] toCode;
        byte[] toCode2;
        byte[] Coded;
        char[] Coded2;
        byte[] decoded;
        char[] deco2;

        try{
            System.out.print("Sifrelenecek Mesajı Giriniz : ");
            String toMake = ch.readLine();


            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            SecretKey aesKey = keyGen.generateKey();


            Cipher aesCipher = Cipher.getInstance("AES");


            aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
            System.out.println("Anahtar : " + aesKey.getEncoded());


            toCode = toMake.toCharArray();
            toCode2 = new byte[toCode.length];
            Coded = new byte[toCode.length];
            for(int i=0;i<toCode.length;i++)
                toCode2[i] = (byte)toCode[i];


           Coded = aesCipher.doFinal(toCode2);


            Coded2 = new char[Coded.length];
            for(int i=0;i<Coded.length;i++)
                Coded2[i] = (char)Coded[i];
            System.out.println("Sifrelenmis Mesaj : " + new String(Coded2));


            Cipher aesCipher2 = Cipher.getInstance("AES");


            aesCipher2.init(Cipher.DECRYPT_MODE, aesKey);

            decoded = aesCipher2.doFinal(Coded);

            deco2 = new char[decoded.length];
            for(int i=0;i<decoded.length;i++)
                deco2[i] = (char)decoded[i];
            System.out.println("Cözümlenmis Mesaj : " + new String(deco2));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}