import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Exam2 {
    static void process(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        List<Integer> nums = new ArrayList<>();
        while((line=br.readLine())!=null){
            nums.add(Integer.parseInt(line));
        }
        for(Integer integer:nums){
            for(Integer integer1: nums){
                if(integer+integer1==2021){
                    System.out.println(integer+"+"+integer1);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        process("C:\\softwaresystems\\java\\SoftwareSystems\\src\\aaa.txt");
        String adminPasswordSHA256 =
                "e5f0d2bc06f4abc1cdcc51b99159a8285b9bf83aeb70e682bb168448d96613eb";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = "uuuuu";


        MessageDigest digest = md;
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));

        System.out.println(hex(hash));

        Challenger challenger = new Challenger();
        Guesser guesser = new Guesser();
        System.out.println(guesser.solve(challenger,0,100));

    }
    public Exam2() throws NoSuchAlgorithmException {
    }

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }


    public interface ToppingRule{
        double apply(Collection<Topping> toppings, double value);
    }
    public class OneTopping implements ToppingRule{
        public OneTopping(){}
        @Override
        public double apply(Collection<Topping> toppings, double value) {
            if(toppings.contains(Topping.MUSHROOMS)){
                value = value*1.2;
            }
            if(toppings.contains(Topping.PINEAPPLE)){
                value = value*0.2;
            }
            return value;
        }
    }
public static class Challenger{
        private int number;
        public Challenger(){
            this.number = (int)(Math.random()*100);
        }
        public int guess(int number){
            if(number==this.number){
                return 0;
            } else if ((number-this.number)<0) {
                return -1;
            }else {
                return 1;
            }
        }
}
public static class Guesser{
    public int solve(Challenger challenger, int lowest, int highest){
        int middle = (lowest+highest)/2;
        if(challenger.guess(middle)==0){
            return middle;
        } else if (challenger.guess(middle)==-1) {
            return solve(challenger,middle,highest);
        }else {
            return solve(challenger,lowest,middle);
        }
    }
}

    public static class ExampleClass extends A {
        public int a() {
            return b();
        }

        private int b() {
            return c();
        }

        protected static int c() {
            return 4;
        }

        public static void main(String[] args) {
            A ex = (A) new ExampleClass();
            ((ExampleClass) ex).b();
        }
    }

    public enum Topping {
        ONIONS,
        MOZZARELLA,
        SALAMI,
        MUSHROOMS,
        SALMON,
        OLIVES,
        PINEAPPLE,
        SPINACH,
        PEPPERS,
        CHILI,
        GARLIC
    }

    public static class A {
        public A() {
        }

        public int a() {
            return 4;
        }
    }
}

