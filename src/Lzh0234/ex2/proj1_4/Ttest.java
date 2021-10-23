package Lzh0234.ex2.proj1_4;

import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/10 23:37
 * @Description:
 */
public class Ttest
{
    public static void main(String[] args)
    {
        System.out.println("pleases enter a nunmber from 1 to 99999");
        Scanner in = new Scanner(System.in);
        int shu = in.nextInt();
        int f = 0;
        if (shu < 0 || shu > 99999)

            System.out.println("number is error");


        else
        {
            for (; shu != 0; f++)
                shu = shu / 10;
            System.out.println("number is " + f + " digits");
        }
        switch (f)
        {
            case 1:
                System.out.println("it is a palindrome number");
                break;
            case 2:
                if (shu / 10 == shu % 10)
                    System.out.println("it is  a palindrome number ");
                else
                    System.out.println("it is not a palindrome number");
                break;
        }
    }
}
