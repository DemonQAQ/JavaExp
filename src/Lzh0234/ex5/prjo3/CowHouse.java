package Lzh0234.ex5.prjo3;

/*
 * JavaExp Lzh0234.ex5.prjo3
 * @Author:Demon
 * @Date:2021/11/14 23:23
 * @Description:
 */
public class CowHouse extends Human
{
    CowHouse(String name)
    {
        this.setName(name);
        this.setAge(20);
        this.setLucky(getRandom().nextInt(10));
        this.setValue(getRandom().nextInt(20000));
    }
}
