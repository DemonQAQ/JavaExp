package Lzh0234.ex5.prjo3;

import java.util.Objects;
import java.util.Random;

/*
 * JavaExp Lzh0234.ex5.prjo3
 * @Author:Demon
 * @Date:2021/11/14 23:15
 * @Description:
 */
public abstract class Human
{
    private String name;
    private int age;
    private int maxAge = 100;
    private String career = "无业";
    private String avocation = "无业";
    private int value;
    private static Random random = new Random();
    private boolean isLive = true;
    public <T extends Human> void display(T people)
    {
        System.out.println("------------------------");
        System.out.println("你的姓名是["+people.getName()+"]");
        System.out.println("你"+people.getAge()+"岁了");
        System.out.println("你的主业是:"+people.getCareer()+"  你的副业是:"+people.getAvocation());
        System.out.println("你的财富:"+people.getValue());
        System.out.println("------------------------");
    }

    public boolean isLive()
    {
        return isLive;
    }

    public void setLive(boolean live)
    {
        isLive = live;
    }

    public String getAvocation()
    {
        return avocation;
    }

    public void setAvocation(String avocation)
    {
        this.avocation = avocation;
    }

    public String getCareer()
    {
        return career;
    }

    public void setCareer(String career)
    {
        this.career = career;
    }

    public static Random getRandom()
    {
        return random;
    }

    private int lucky;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getMaxAge()
    {
        return maxAge;
    }

    public void setMaxAge(int maxAge)
    {
        this.maxAge = maxAge;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public int getLucky()
    {
        return lucky;
    }

    public void setLucky(int lucky)
    {
        this.lucky = lucky;
    }
}
