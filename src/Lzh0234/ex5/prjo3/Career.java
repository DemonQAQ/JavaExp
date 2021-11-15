package Lzh0234.ex5.prjo3;

/*
 * JavaExp Lzh0234.ex5.prjo3
 * @Author:Demon
 * @Date:2021/11/15 0:01
 * @Description:
 */
public enum Career
{
    COURIER("快递员", 1), PROGRAMMER("007程序猿", 2), DRIVER("开滴滴", 3), VENDOR("路边炒粉", 4), OLCELEBRITY(
        "网红",
        5),
    STAR(
            "明星", 6), BOSS("老板", 7), OFFICER("官", 8), LANDLORD("新时代地主", 9), TRADER("华尔街只狼", 10);

    // 成员变量

    private String name;

    private int index;

    // 构造方法

    Career(String name, int index)
    {

        this.name = name;

        this.index = index;

    }

    // 普通方法

    public static String getName(int index)
    {

        for (Career c : Career.values())
        {

            if (c.getIndex() == index)
            {

                return c.name;

            }

        }

        return null;

    }

    // get set 方法

    public String getName()
    {

        return name;

    }

    public void setName(String name)
    {

        this.name = name;

    }

    public int getIndex()
    {

        return index;

    }

    public void setIndex(int index)
    {

        this.index = index;

    }
}
