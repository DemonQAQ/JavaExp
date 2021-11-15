package Lzh0234.ex5.prjo2;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 17:53
 * @Description:
 */
public abstract class Instrument
{
    private Player player;

    public String[] getString()
    {
        return string;
    }

    public void setString(String[] string)
    {
        this.string = string;
    }

    private String[] string;

    //播放音乐，打开location为src\\lzh0234\\source\\.内的音频文件
    public void makeSound(InputStream inputStream)
    {
        new Thread(()->
        {
            try
            {
                BufferedInputStream stream =
                        new BufferedInputStream(inputStream);
                player = new Player(stream);
                player.play();
            }catch (Exception e)
            {

            }
        }).start();
        try
        {
            Thread.sleep(30000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        if (player!=null)player.close();
    }
    public void stopSound()
    {
        player.close();
    }
}
