package Lzh0234.ex5.prjo4;

import java.util.ArrayList;
import java.util.List;

/*
 * JavaExp Lzh0234.ex5.prjo4
 * @Author:Demon
 * @Date:2021/11/14 20:55
 * @Description:
 */
public class Computer implements Usb
{
    private ArrayList usbEquipmentList;
    private boolean power=false;

    Computer(){};

    @Override
    public <T> boolean usbOn(T equipment)
    {
        if (usbEquipmentList.contains(equipment)) return true;
        else if (checkDevice(equipment.getClass()))
        {
            usbEquipmentList.add(equipment);
            return true;
        }
        return false;
    }

    @Override
    public <T> boolean usbOff(T equipment)
    {
        if (usbEquipmentList.contains(equipment))
        {
            usbEquipmentList.remove(equipment);
            return true;
        }
        return false;
    }

    public boolean openComputer()
    {
        power=true;
        usbEquipmentList=new ArrayList();
        return true;
    }

    public boolean closeComputer()
    {
        power=false;
        usbEquipmentList.clear();
        usbEquipmentList=null;
        return true;
    }

    public <T> void plugInDevice(T device)
    {
        if (power)
        {
            if (usbOn(device))System.out.println("已经插入usb设备");
            else System.out.println("无法识别");
        }
        else System.out.println("请先开机");
    }

    public <T> void pullOutDevice(T device)
    {
        if (power)
        {
            if (usbOff(device))System.out.println("成功卸载usb设备");
            else System.out.println("没有该设备");
        }
        else System.out.println("请先开机");
    }

    public boolean checkDevice(Class device)
    {
        //获得类上的所有接口
        Class[] interfaces = device.getInterfaces();
        for (Class anInterface : interfaces)
        {
            //如果接口名称符合返回true
            if (anInterface.getName().equals("Lzh0234.ex5.prjo4.Usb")) return true;
            else
            {
                if (checkDevice(anInterface)) return true;
            }
        }
        if (device.getSuperclass() != null)
        {
            return checkDevice(device.getSuperclass());
        }
        return false;
    }
}
