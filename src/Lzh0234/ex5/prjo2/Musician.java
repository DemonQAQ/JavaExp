package Lzh0234.ex5.prjo2;

import java.io.InputStream;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 18:10
 * @Description:
 */
public class Musician
{
    private String name;

    Musician(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public <T extends Instrument> void play(T instrument, int i)
    {
        //打包后无法通过绝对地址实例化File对象
        //通过getClass().getResource().getFile()获得运行时资源地址，也无法实例化
        //需要getClass().getResourceAsStream()直接获得输入流再传入
        InputStream is = this.getClass().getResourceAsStream(instrument.getString()[0]);
        instrument.makeSound(is);
    }
}
