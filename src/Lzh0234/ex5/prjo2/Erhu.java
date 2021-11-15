package Lzh0234.ex5.prjo2;

import java.io.InputStream;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 17:53
 * @Description:
 */
public class Erhu extends Instrument
{
    Erhu(String[] loc)
    {
        setString(loc);
    }
    @Override
    public void makeSound(InputStream inputStream)
    {
        super.makeSound(inputStream);
    }
}
