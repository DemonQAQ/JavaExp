package Lzh0234.ex5.prjo2;

import java.io.InputStream;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 17:54
 * @Description:
 */
public class Violin extends Instrument
{
    Violin(String[] loc)
    {
        setString(loc);
    }
    @Override
    public void makeSound(InputStream inputStream)
    {
        super.makeSound(inputStream);
    }
}
