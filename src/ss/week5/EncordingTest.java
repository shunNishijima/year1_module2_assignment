package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;

public class EncordingTest {
    public static void main(String[] args) throws DecoderException {
        System.out.println(Hex.encodeHexString("Hello World".getBytes()));
        System.out.println(Hex.encodeHexString("Hello Big World".getBytes()));

        byte[] bytearray= "Hello World".getBytes();
        String string = new String(bytearray);
        System.out.println(string);

        System.out.println(Base64.encodeBase64String("Hello World".getBytes()));

        byte[] decode = Hex.decodeHex("010203040506");
        System.out.println((Base64.encodeBase64String(decode)));
        System.out.println(Arrays.toString(Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==")));

        String a = "a";
        for(int i=0;i<10;i++){
            byte[] bytea = a.getBytes();
            System.out.println(Base64.encodeBase64String(bytea));
            a = a+"a";
        }

    }

}
