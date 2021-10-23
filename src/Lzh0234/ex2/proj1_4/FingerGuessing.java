package Lzh0234.ex2.proj1_4;

import java.util.Random;
import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/4 17:27
 * @Description:
 */
public class FingerGuessing
{
    private static final int GAME_TIME = 5;
    private static final String[] FINGER = {"狄萌萌", "石头", "剪刀", "布"};

    public static void GameStart(Scanner scanner)
    {
        System.out.println("电脑:来和我猜拳吧，五局三胜制");
        System.out.println("电脑:输入数字决定你要出的手势，1是石头，2是剪刀，3是布");
        System.out.println("电脑:来吧！");
        int WinFlag = Guessing(scanner);
        if (WinFlag == 0) System.out.println("电脑：人类，竟然能和我打成平手");
        else if (WinFlag == 1) System.out.println("电脑:怎么可能，你竟然赢了");
        else if (WinFlag == 2) System.out.println("电脑:你输了哈哈哈");
    }

    private static int Guessing(Scanner scanner)
    {
        int PlayerGuessNum = 0;
        int ComputerNum = 0;
        int PlayerWinTime = 0;
        int ComputerWinTime = 0;
        boolean Flag;
        for (int i = 0; i < GAME_TIME; i++)
        {
            do
            {
                Flag = false;
                PlayerGuessNum = scanner.nextInt();
                if (PlayerGuessNum < 1 || PlayerGuessNum > 3)
                {
                    Flag = true;
                    System.out.println("请输入数字1(石头)/2(剪刀)/3(布)代表出的手势");
                }
            } while (Flag);
            System.out.println("你出了" + FINGER[PlayerGuessNum]);
            Random Random = new Random();
            ComputerNum = Random.nextInt(2) + 1;
            System.out.println("电脑出了" + FINGER[ComputerNum]);
            if (PlayerGuessNum == ComputerNum)
            {
                System.out.println("电脑：这局打平了，再来");
            }
            else if ((ComputerNum + 1) % 3 == PlayerGuessNum)
            {
                ComputerWinTime++;
                System.out.println("电脑：是我赢了哈哈哈哈哈哈哈哈哈");
            } else
            {
                PlayerGuessNum++;
                System.out.println("电脑：你怎么敢赢的，你怎么敢的");
            }
        }
        if (PlayerGuessNum == ComputerNum) return 0;
        else return PlayerGuessNum > ComputerNum ? 1 : 2;
    }
}
