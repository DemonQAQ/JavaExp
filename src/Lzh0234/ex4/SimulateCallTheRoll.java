package Lzh0234.ex4;

import java.util.Random;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:17
 * @Description:
 */
public class SimulateCallTheRoll
{
    public static void callTheRoll(String[] students)
    {
        boolean[] flags = new boolean[students.length];
        Random random = new Random();
        int loc;
        for (int i=5;i>0;i--)
        {
            while (flags[loc=random.nextInt(students.length)]);
            flags[loc]=true;
            System.out.println(students[loc]);
        }
    }
}
