package Lzh0234.ex5.prjo2;

import java.io.InputStream;
import java.net.URL;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 17:54
 * @Description:
 */
public class Piano extends Instrument
{
    Piano(String[] loc)
    {
        setString(loc);
    }

@Override
    public void makeSound(InputStream inputStream)
    {
        super.makeSound(inputStream);
    }
}
