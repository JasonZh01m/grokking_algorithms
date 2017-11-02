package recursion;

import javax.sound.midi.Soundbank;

/**
 * Created by JasonZh on 2017/11/2.
 * 递归求阶乘
 */
public class Factorial {

    private static int fact(int x) {
        if (x == 1) {
            System.out.print(1 + " = ");
            return 1;
        } else {
            System.out.print(x + " * ");
            return x * fact(x - 1);
        }
    }


    public static void main(String[] args) {
        System.out.print(fact(5));
    }

}
