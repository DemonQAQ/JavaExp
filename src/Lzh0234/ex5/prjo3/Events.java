package Lzh0234.ex5.prjo3;


import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/*
 * JavaExp Lzh0234.ex5.prjo3
 * @Author:Demon
 * @Date:2021/11/14 23:23
 * @Description:
 */
public class Events
{
    private static Event[] events;
    private static Random random = new Random();
    private static UnaryOperator<Human> event0 = Events::Dead;
    private static UnaryOperator<Human> event1 = Events::gainCareer;
    private static UnaryOperator<Human> event2 = Events::gainAvocation;
    private static UnaryOperator<Human> event3 = Events::transfer;
    private static UnaryOperator<Human> event4 = Events::beFiredOnCareer;
    private static UnaryOperator<Human> event5 = Events::beFiredOnAvocation;
    private static UnaryOperator<Human> event6 = Events::fallILl;
    private static UnaryOperator<Human> event7 = Events::winPrice;
    private static UnaryOperator<Human> event8 = Events::losePrice;

    //回合更新
    public static <T extends Human> void check(T people)
    {
        if (people.getAge() == people.getMaxAge())
        {
            Dead(people);
            return;
        } else
        {
            //更新事件触发概率
            people.setAge(people.getAge() + 1);
            events[0].chance += (people.getAge() - 50) > 0 ?
                    (int) ((people.getAge() - 50) * 0.75) : 0;
            if (people.getCareer().equals("无业"))
                events[1].chance += 100 - (people.getAge() / 2);
            else events[1].chance = 20;
            if (people.getAvocation().equals("无业"))
                events[2].chance += 90 - (people.getAge() / 2);
            else events[2].chance = 20;
            events[4].chance += people.getAge() * 0.05;
            events[5].chance += people.getAge() * 0.05;
            events[6].chance += people.getAge() * 0.05;
            if (random.nextInt(20) < people.getLucky()) events[7].chance += 3;
            if (random.nextInt(20) < people.getLucky()) events[8].chance += 3;
            if (random.nextInt(20) < people.getLucky()) events[3].chance += 1;
        }
    }

    //初始化事件
    public static void initializeEvents()
    {
        events = new Event[9];
        for (int i = 0; i < events.length; i++) events[i] = new Event();
        events[0].event = event0;//死
        events[0].chance = 1;
        events[1].event = event1;//获得主业
        events[1].chance = 20;
        events[2].event = event2;//获得副业
        events[2].chance = 20;
        events[3].event = event3;//转换身份
        events[3].chance = 5;
        events[4].event = event4;//被主业开除
        events[4].chance = 20;
        events[5].event = event5;//被副业开除
        events[5].chance = 20;
        events[6].event = event6;//生病
        events[6].chance = 5;
        events[7].event = event7;//中奖
        events[7].chance = 30;
        events[8].event = event8;//倒霉
        events[8].chance = 30;
    }

    //随机事件
    public static <T extends Human> Event randomEvent()
    {
        int index = 0, chance = 0, i = 0;
        for (Event e : events) index += e.chance;
        index = random.nextInt(index);
        for (i = 0; i < events.length; i++)
        {
            chance += events[i].chance;
            if (index <= chance)
            {
                return events[i];
            }
        }
        return null;
    }

    //死掉了
    private static <T extends Human> Human Dead( T people)
    {
        people.setLive(false);
        System.out.println("你死了");
        return people;
    }

    //设置职业
    public static <T extends Human> Human gainCareer( T people)
    {
        int index;
        if (people.getClass() == CowHouse.class) index = random.nextInt(5) + 1;
        else index = random.nextInt(5) + 6;
        people.setCareer(Career.getName(index));
        System.out.println("你找到了份主业，工作是["+people.getCareer()+"]");
        return people;
    }

    //设置副业
    public static <T extends Human> Human gainAvocation( T people)
    {
        int index;
        if (people.getClass() == CowHouse.class) index = random.nextInt(5) + 1;
        else index = random.nextInt(5) + 6;
        people.setAvocation(Career.getName(index));
        System.out.println("你找到了份副业，工作是["+people.getAvocation()+"]");
        return people;
    }

    //增加财富
    public static <T extends Human> Human addValue( T people)
    {
        if (people.getCareer().equals("无业") || people.getAvocation().equals("无业"))
        {
            if (people.getCareer().equals("无业"))
            {
                people.setValue(people.getValue() - 50000 - random.nextInt(40000));
                System.out.println("你没有主业");
            }
            if (people.getAvocation().equals("无业"))
            {
                people.setValue(people.getValue() - 50000 - random.nextInt(40000));
                System.out.println("你没有副业");
            }
        }
        if (people.getCareer().equals("快递员") || people.getAvocation().equals("快递员"))
        {
            if (people.getCareer().equals("快递员"))
            {
                people.setValue(people.getValue() + 100000 + random.nextInt(30000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("快递员"))
            {
                people.setValue(people.getValue() + 100000 + random.nextInt(30000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("007程序员") || people.getAvocation().equals("007程序员"))
        {
            if (people.getCareer().equals("007程序员"))
            {
                people.setValue(people.getValue() + 200000 + random.nextInt(500000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("007程序员"))
            {
                people.setValue(people.getValue() + 200000 + random.nextInt(500000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("开滴滴") || people.getAvocation().equals("开滴滴"))
        {

            if (people.getCareer().equals("开滴滴"))
            {
                people.setValue(people.getValue() + 150000 + random.nextInt(50000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("开滴滴"))
            {
                people.setValue(people.getValue() + 150000 + random.nextInt(50000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("路边炒粉") || people.getAvocation().equals("路边炒粉"))
        {

            if (people.getCareer().equals("路边炒粉"))
            {
                people.setValue(people.getValue() + 120000 + random.nextInt(50000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");

            }
            if (people.getAvocation().equals("路边炒粉"))
            {
                people.setValue(people.getValue() + 120000 + random.nextInt(50000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("网红") || people.getAvocation().equals("网红"))
        {
            people.setValue(people.getValue() + 500000 + random.nextInt(1000000));
            if (people.getCareer().equals("网红"))
            {
                people.setValue(people.getValue() + 500000 + random.nextInt(1000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("网红"))
            {
                people.setValue(people.getValue() + 500000 + random.nextInt(1000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("明星") || people.getAvocation().equals("明星"))
        {
            if (people.getCareer().equals("明星"))
            {
                people.setValue(people.getValue() + 50000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("明星"))
            {
                people.setValue(people.getValue() + 50000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("老板") || people.getAvocation().equals("老板"))
        {
            if (people.getCareer().equals("老板"))
            {
                people.setValue(people.getValue() + 10000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("老板"))
            {
                people.setValue(people.getValue() + 10000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("官") || people.getAvocation().equals("官"))
        {
            if (people.getCareer().equals("官"))
            {
                people.setValue(people.getValue() + 1000000 + random.nextInt(5000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("官"))
            {
                people.setValue(people.getValue() + 1000000 + random.nextInt(5000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("新时代地主") || people.getAvocation().equals("新时代地主"))
        {
            if (people.getCareer().equals("新时代地主"))
            {
                people.setValue(people.getValue() + 1000000 + random.nextInt(5000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
            if (people.getAvocation().equals("新时代地主"))
            {
                people.setValue(people.getValue() + 1000000 + random.nextInt(5000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");
            }
        }
        if (people.getCareer().equals("华尔街只狼") || people.getAvocation().equals("华尔街只狼"))
        {
            if (people.getCareer().equals("华尔街只狼"))
            {
                people.setValue(people.getValue() + 5000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getCareer() + "]发工资了，你的余额为" + people.getValue() + "元");

            }
            if (people.getAvocation().equals("华尔街只狼"))
            {
                people.setValue(people.getValue() + 5000000 + random.nextInt(100000000));
                System.out.println("你的工作[" + people.getAvocation() + "]发工资了，你的余额为" + people.getValue() + "元");

            }
        }
        return people;
    }

    public static <T extends Human> Human transfer( T people)
    {
        Human human;
        if (people.getClass() == CowHouse.class)
        {
            System.out.println("你变成了天龙人");
            human = new Childe(people.getName());
            human.setValue(people.getValue());
            human.setLucky(people.getLucky() + 5);
        } else
        {
            System.out.println("你变成了牛马");
            human = new CowHouse(people.getName());
            human.setValue(100000);
            human.setLucky((people.getLucky() - 5) > 0 ? people.getLucky() - 5 : 5);
        }
        human.setAge(people.getAge());
        Events.gainCareer(human);
        Events.gainAvocation(human);
        return human;
    }

    public static <T extends Human> Human beFiredOnCareer( T people)
    {
        if (people.getCareer().equals("无业"));
        else
        {
            people.setCareer("无业");
            System.out.println("你丢失了你的主业");
        }
        return people;
    }

    public static <T extends Human> Human beFiredOnAvocation( T people)
    {
        if (people.getAvocation().equals("无业"));
        else
        {
            people.setAvocation("无业");
            System.out.println("你丢失了你的副业");
        }
        return people;
    }

    public static <T extends Human> Human fallILl( T people)
    {
        int cost = random.nextInt((1000000));
        System.out.println("你生病了");
        if (cost > people.getValue())
        {
            System.out.println("你没钱治病");
            Events.Dead(people);
        } else
        {
            int chance = 1;
            chance += (people.getAge()-60)>0?(int)((people.getAge()-60)*0.5):0;
            chance = Math.max((chance - people.getLucky()), 0);
            if (random.nextInt(100) + 1 > chance)
            {
                people.setValue(people.getValue() - cost);
                System.out.println("你治好了你的病，花了" + cost + "元");
            } else
            {
                System.out.println("没治好");
                Events.Dead(people);
            }
        }
        return people;
    }

    public static <T extends Human> Human winPrice(T people)
    {
        int price = random.nextInt(6) + 1;
        if (price == 1)
        {
            people.setValue(people.getValue() + 50);
            System.out.println("你在路上捡到了50块");
        }
        if (price == 2)
        {
            people.setValue(people.getValue() + 5000000);
            System.out.println("你中了500w彩票");
        }
        if (price == 3)
        {
            people.setValue(people.getValue() + 4000000);
            System.out.println("你在翻斗小区1栋101的房子升值了，你卖出房子赚了400w");
        }
        if (price == 4)
        {
            people.setLucky(people.getLucky()+5);
            System.out.println("你过马路扶老奶奶，幸运值+5");
        }
        if (price == 5)
        {
            System.out.println("你沉迷二次元，每天练习Wota艺");
        }
        if (price == 6)
        {
            people.setValue(people.getValue() + 3000000);
            System.out.println("你屯的显卡卖出去了，赚了300w");
        }
        return people;
    }

    public static <T extends Human> Human losePrice(T people)
    {
        int price = random.nextInt(6) + 1;
        if (price == 1)
        {
            people.setLucky(Math.max((people.getLucky() - 5), 0));
            System.out.println("你走路踩屎，摔了一跤摔坏了手机，幸运值-5");
        }
        if (price == 2)
        {
            people.setValue(people.getValue() - 5000000);
            System.out.println("你的投资失败了，加了10倍杠杆，血本无归，亏了500w");
        }
        if (price == 3)
        {
            people.setValue(people.getValue() - 2999990);
            System.out.println("你在翻斗小区1栋101的房子贬值了，你贷款花了300w买的，现在还欠银行299w");
        }
        if (price == 4)
        {
            people.setValue(people.getValue() - 10000000);
            System.out.println("你花钱了1000w买了量子波动速读仪");
        }
        if (price == 5)
        {
            people.setMaxAge(people.getMaxAge()-20);
            System.out.println("你玩的游戏[原魔]一次十连抽到了9个五星，献祭了你20年阳寿");
        }
        if (price == 6)
        {
            people.setValue(people.getValue() - 10000000);
            System.out.println("银行数据库被黑了，你损失了1000w");
        }
        return people;
    }
}

class Event
{
    UnaryOperator<Human> event;
    int chance;
}
