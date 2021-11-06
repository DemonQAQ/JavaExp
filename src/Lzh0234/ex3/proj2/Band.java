package Lzh0234.ex3.proj2;

/*
 * JavaExp Lzh0234.ex3.proj2
 * @Author:Demon
 * @Date:2021/11/4 18:02
 * @Description:
 */
public class Band
{
    public static void main(String[] args)
    {
        Account[] accounts = new Account[]{new Account(20234, "lzh"), new Account(20236, "zyy")};
        accounts[0].setBalance(50000.50);
        accounts[1].setBalance(1000000);
        System.out.println("卡号:" + accounts[0].getNumber() + "  " + "姓名:" + accounts[0].getName());
        accounts[0].displayBalance();
        System.out.println("卡号:" + accounts[1].getNumber() + "  " + "姓名:" + accounts[1].getName());
        accounts[1].displayBalance();
        accounts[0].deposit(233.5);
        accounts[0].withdrawal(1000);
        accounts[0].displayBalance();
        System.out.println("卡号:" + accounts[1].getNumber() + "  " + "姓名:" + accounts[1].getName());
        accounts[1].displayBalance();
        transfer(accounts,accounts[0],20236,10000.25 );
        System.out.println("卡号:" + accounts[1].getNumber() + "  " + "姓名:" + accounts[1].getName());
        accounts[1].displayBalance();

    }

    public static boolean transfer(Account[] accounts, Account user, int goalNumber,
                                   double transferNum)
    {
        for (int i = 0; i < accounts.length; i++)
        {
            if (accounts[i].getNumber() == goalNumber)
            {
                user.transfer(transferNum, accounts[i]);
                return true;
            }
        }
        System.out.println("未查询到该卡号对应用户，转账失败");
        return false;
    }
}

