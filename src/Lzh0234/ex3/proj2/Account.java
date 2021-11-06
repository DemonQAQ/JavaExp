package Lzh0234.ex3.proj2;

/*
 * JavaExp Lzh0234.ex3.proj2
 * @Author:Demon
 * @Date:2021/11/4 18:05
 * @Description:
 */
public class Account
{
    private int number;
    private String name;
    private double balance = 0;

    public Account()
    {

    }

    public Account(int number,String name)
    {
        this.number=number;
        this.name=name;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double withdrawal(double withdrawalNum)
    {
        if (withdrawalNum<=0)
        {
            System.out.println("输入数据有误，请输入大于0的数据");
            return 0;
        }
        else
        {
            if (balance>=withdrawalNum)
            {
                balance-=withdrawalNum;
                System.out.println("取款成功");
                return withdrawalNum;
            }
            else
            {
                System.out.println("余额不足");
                return 0;
            }
        }
    }

    public void deposit(double depositNum)
    {
        balance+=depositNum;
        System.out.println("存款成功");
    }

    public boolean transfer(double transferNum,Account goal)
    {
        if (transferNum<=0)
        {
            System.out.println("输入数据有误，请输入大于0的数据");
            return false;
        }
        else
        {
            if (transferNum>balance)
            {
                System.out.println("余额不足");
                return false;
            }
            else
            {
                balance-=transferNum;
                goal.setBalance(goal.getBalance()+transferNum);
                System.out.println("转账成功");
                return true;
            }
        }
    }

    public void displayBalance()
    {
        System.out.println("账户余额:"+this.balance);
    }
}
