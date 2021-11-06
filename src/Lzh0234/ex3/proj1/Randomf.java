package Lzh0234.ex3.proj1;

import java.util.Random;

/*
 * JavaExp Lzh0234.ex3
 * @Author:Demon
 * @Date:2021/11/3 21:50
 * @Description:
 */
public class Randomf extends java.util.Random
{
    private java.util.Random random;
    Randomf()
    {
        random = new java.util.Random();
    }
    public double nextDouble(int bound)
    {
        int temp = bound *10;
        temp = random.nextInt(temp);
        return (temp<0)?-(temp/10.0):temp/10.0;
    }
}
