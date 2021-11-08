package Lzh0234.ex4;

import java.util.Date;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/7 12:38
 * @Description:
 */
public class test
{
    public static void main(String[] args)
    {
        Date date = new Date();
        Object o=date;
        Date d=(Date)o;
        System.out.println(d==date);
    }
}
