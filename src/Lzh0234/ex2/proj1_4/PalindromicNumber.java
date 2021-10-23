package Lzh0234.ex2.proj1_4;

import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/4 17:26
 * @Description:回文数判断
 */
public class PalindromicNumber
{
    public static void PalindromicNumberGame(Scanner scanner)
    {
        String Num;
        int Length;
        int Number;
        boolean Flag;
        do
        {
            Flag = false;
            Num = scanner.next();
            Length = Num.length();
            Number = Integer.parseInt(Num);
            if (Length>5||Number==0)
            {
                Flag=true;
                System.out.println("请输入范围在[1-99999]的数字");
                scanner.next();
            }
        }while (Flag);
        Flag = PalindromicNumber.JudgePalindromicNumber(Number, Length);
        if (Flag) System.out.println(Num + "是" + Length + "位的" + "回文数");
        else System.out.println(Num + "是" + Length + "位的" + "非回文数");
    }

    private static boolean JudgePalindromicNumber(int NumberIn, int length)
    {
        if (NumberIn < 0)
            return false;
        else
            return Judge(NumberIn, length);
    }

    private static boolean Judge(int Number, int length)
    {
        int CutNumber = 0;
        boolean flag = false;
        if (length % 2 == 1)
        {
            length--;
            flag = true;
        }
        int time = length >> 1;
        for (int i = 0; i < time; i++)
        {
            CutNumber += Number % 10 * Math.pow(10, flag ? time - i : time - i - 1);
            Number /= 10;
        }
        if (flag) Number -= Number % 10;
        return Number == CutNumber;
    }
}
