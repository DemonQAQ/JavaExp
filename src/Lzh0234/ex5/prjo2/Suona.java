package Lzh0234.ex5.prjo2;

import java.io.InputStream;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 18:10
 * @Description:
 */
public class Suona extends Instrument
{
    Suona(String[] loc)
    {
        setString(loc);
    }
    @Override
    public void makeSound(InputStream inputStream)
    {
        super.makeSound(inputStream);
    }
}
