package Lzh0234.ex4;

import java.util.Locale;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:18
 * @Description:
 */
public class ReverseString
{
    public static String reverse(String string)
    {
        return new StringBuffer(string).reverse().toString().toUpperCase(Locale.ROOT);
    }
}
