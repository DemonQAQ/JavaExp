package Lzh0234.ex4;

import java.util.Date;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/7 12:38
 * @Description:
 */
public class test
{
    public static void main(String[] args)
    {
        String name = new String("Demonmon");
        String nameError = new String("Demon12138");
        String password = new String("Demonmon@20141001");
        String passwordError = new String("Demonmon@201410011");
        System.out.println("检查name和nameError是否符合格式\n"+"name:"+Login.checkUsername(name)+"  "+
                "nameError:"+Login.checkUsername(nameError));
        System.out.println("检查password和passwordError是否符合格式\n"+"password:"+Login.checkPassword(password)+
                "  "+
                "passwordError:"+Login.checkPassword(passwordError));
    }
}
