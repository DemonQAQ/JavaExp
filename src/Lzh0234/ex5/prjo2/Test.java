package Lzh0234.ex5.prjo2;

import java.net.URL;
import java.util.Scanner;
/*
 * JavaExp Lzh0234.ex5.prjo2
 * @Author:Demon
 * @Date:2021/11/12 18:10
 * @Description:
 */
public class Test
{
    static Musician player = null;

    public static void main(String[] args){
        int select ;

        Piano piano = new Piano(new String[]{"/piano.mp3"});
        Erhu erhu = new Erhu(new String[]{"/erhu.mp3"});
        Suona suona = new Suona(new String[]{"/suona.mp3"});
        Violin violin = new Violin(new String[]{"/violin.mp3"});
        Scanner scanner = new Scanner(System.in);
        System.out.println("给你的音乐家起个名字");
        String name = scanner.nextLine();
        player=new Musician(name);
        end:
        while (true)
        {
            System.out.println(name+":请问想听点什么");
            System.out.println("我会钢琴，二胡，小提琴，唢呐\n");
            System.out.println("[提示]请选择输入数字选择 1.钢琴 2.二胡 3.小提琴 4.唢呐 0.退出");
            System.out.println("[提示]音量调小，有声音");
            select = scanner.nextInt();
            switch (select)
            {
                case 1:
                    player.play(piano,0);
                    flashCache(scanner);
                    break;
                case 2:
                    player.play(erhu,0);
                    flashCache(scanner);
                    break;
                case 3:
                    player.play(violin,0);
                    flashCache(scanner);
                    break;
                case 4:
                    player.play(suona,0);
                    flashCache(scanner);
                    break;
                case 0:
                    break end;
                default:
                    break;
            }
        }
    }
    public static void flashCache(Scanner scanner)
    {
        while (scanner.hasNext())scanner.next();
    }
}
