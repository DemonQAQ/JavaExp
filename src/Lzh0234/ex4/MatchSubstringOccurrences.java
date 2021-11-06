package Lzh0234.ex4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:20
 * @Description:
 */
public class MatchSubstringOccurrences
{
    public static int Match(String string,String subString)
    {
        int counts=0;
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find())counts++;
        return counts;
    }
}
