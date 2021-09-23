import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Pot2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/arquivos/d12.txt");
        Scanner in = new Scanner(file);
        ArrayList<BigInteger> nums = new ArrayList<>();

        while(in.hasNextLine()) {
            nums.add(new BigInteger(in.nextLine()));
        }

        for (BigInteger i : nums) {
            int res = potenciaDe2(i);

            if (!(res == -1)) {
                System.out.printf("%s " + true + " %d\n", i, res);
            } else {
                System.out.printf("%s " + false + "\n", i);
            }
        }
    }

    public static int potenciaDe2(BigInteger num) {
        if (num.max(BigInteger.ZERO).equals(BigInteger.ZERO)) { // se menor que zero, retorna -1
            return -1;
        }

        int expoente = 0;

        while(num.mod(BigInteger.TWO).intValue() == 0) { // enquanto num mod 2 == 0
            num = num.divide(BigInteger.TWO); //num = num/2
            expoente++;
        }

        if (num.equals(BigInteger.ONE)) {
            return expoente;
        }

        return -1;
    }
}
