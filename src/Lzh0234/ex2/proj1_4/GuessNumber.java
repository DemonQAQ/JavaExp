package Lzh0234.ex2.proj1_4;

import java.util.Random;
import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/4 17:27
 * @Description:
 */
public class GuessNumber
{
    private static final int GAME_TIMES = 5;
    public static void GameStart(Scanner scanner)
    {
        System.out.println("电脑:来玩猜数字游戏吧，我会出一个0-100内的数字，你有五次机会猜");
        Guessing(scanner);
    }
    private static void Guessing(Scanner scanner)
    {
        Random Random = new Random();
        int PlayerGuessNum;
        int ComputerNum = Random.nextInt(100);
        for (int i=0;i<GAME_TIMES;i++)
        {
            System.out.println("电脑:请输入你猜的数字");
            PlayerGuessNum = scanner.nextInt();
            if (PlayerGuessNum == ComputerNum)
            {
                System.out.println("电脑:猜对啦!");
                break;
            }
            else if (PlayerGuessNum-ComputerNum>0&&PlayerGuessNum-ComputerNum<20)System.out.println(
                   "电脑:猜大了，很接近了");
            else if (ComputerNum-ComputerNum>0&&ComputerNum-ComputerNum<20)System.out.println(
                    "电脑:猜小了，很接近了");
            else if (PlayerGuessNum-ComputerNum>20)System.out.println("电脑:太大啦，你猜辣么大干甚么嘛");
            else if (ComputerNum - PlayerGuessNum>20)System.out.println("电脑:太小了，能不能大气点");
        }
        System.out.println("电脑:五次机会用完了，你失败了");
    }
}
