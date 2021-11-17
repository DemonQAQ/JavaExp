package Lzh0234.ex6.prjo3;

import Lzh0234.ex6.prjo2.IllegalArgumentException;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入待计算整数数量");
        int length = -1;
        while (length <= 0)
        {
            length = scanner.nextInt();
            if (length <= 0) try
            {
                throw new IllegalSymbolException("要大于0");
            } catch (IllegalSymbolException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("请输入所有待计算的数");
        int[] num=new int[length];
        for (int i=0;i<num.length;i++)
        {
            do
            {
                num[i] = scanner.nextInt();
                if (num[i]<=0) try
                {
                    throw new IllegalSymbolException("请输入大于0的整数");
                } catch (IllegalSymbolException e)
                {
                    e.printStackTrace();
                }
            }while (num[i]<=0);
        }
        int temp=0;
        for (int i:num)temp+=i;
        System.out.println("平均数为"+temp/length);
    }
}
