package Lzh0234.ex5.prjo3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;

/*
 * JavaExp Lzh0234.ex5.prjo3
 * @Author:Demon
 * @Date:2021/11/14 23:39
 * @Description:
 */
public class Main
{
    public static void main(String[] args)
    {
        while (true)
        {
            int times;
            Human human;
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            System.out.println("请输入姓名");
            String name = scanner.next();
            Events.initializeEvents();
            if (random.nextInt(2)==0)human = new CowHouse(name);
            else human = new Childe(name);
            if (human.getClass()==CowHouse.class)System.out.println("你是牛马");
            else System.out.println("你是天龙人");
            start:
            while (human.isLive())
            {
                human.display(human);
                System.out.print("\n");
                times = random.nextInt(5) + 1;
                for (int i=0;i<times;i++)
                {
                    human=Objects.requireNonNull(Events.randomEvent()).event.apply(human);
                    if (!human.isLive())break start;
                }
                Events.addValue(human);
                System.out.print("\n");
                Events.check(human);
                System.out.println("输入任意并回车继续");
                scanner.next();
            }
            System.out.println("继续玩吗？输入0退出");
            if (scanner.next().equals("0"))break;
        }
    }
}
