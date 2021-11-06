package Lzh0234.ex2.proj1_4;

import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2
 * @Author:Demon
 * @Date:2021/10/4 17:22
 * @Description:
 */
public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static int Select;
    private static String choice;
    private static boolean Flag;
    public static void main(String[] args)
    {
        main:
        while (true)
        {
            System.out.println("请输入数字选择功能");
            System.out.print("0.退出\n1.回文数判断\n2.剪刀石头布\n3.猜数字游戏\n4.输出1-1000内的素数");
            do
            {
                Flag = false;
                choice = scanner.next();
                if (!choice.matches("\\d+?"))
                {
                    Flag = true;
                    System.out.println("提示:请输入数字");
                }
            }while (Flag);
            Select=Integer.parseInt(choice);
            switch (Select)
            {
                case 0:
                    break main;
                case 1:
                    PalindromicNumber.PalindromicNumberGame(scanner);
                    break;
                case 2:
                    FingerGuessing.GameStart(scanner);
                    break;
                case 3:
                    GuessNumber.GameStart(scanner);
                    break;
                case 4:
                    PrimeNumberOutput.PrimeNumberDisplay();
                    break;
                default:
                    break;
            }
        }
    }
}
