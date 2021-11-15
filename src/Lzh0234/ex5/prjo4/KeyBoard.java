package Lzh0234.ex5.prjo4;

/*
 * JavaExp Lzh0234.ex5.prjo4
 * @Author:Demon
 * @Date:2021/11/14 20:55
 * @Description:
 */
public class KeyBoard implements Usb
{
    @Override
    public <T> boolean usbOn(T equipment)
    {
        return false;
    }

    @Override
    public <T> boolean usbOff(T equipment)
    {
        return false;
    }
}
