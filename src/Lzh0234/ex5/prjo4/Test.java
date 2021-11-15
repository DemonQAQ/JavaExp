package Lzh0234.ex5.prjo4;

/*
 * JavaExp Lzh0234.ex5.prjo4
 * @Author:Demon
 * @Date:2021/11/14 23:02
 * @Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        Computer computer = new Computer();
        KeyBoard keyBoard = new KeyBoard();
        Mouse mouse = new Mouse();
        Object o = new Object();
        computer.openComputer();
        computer.plugInDevice(keyBoard);
        computer.plugInDevice(mouse);
        computer.plugInDevice(o);
        computer.pullOutDevice(keyBoard);
    }
}
