package Lzh0234.ex4;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:20
 * @Description:
 */
public class Login
{
    public static boolean checkUsername(String username)
    {
        String regex = "[a-zA-Z]{6,}";
        return username.matches(regex);
    }

    public static boolean checkPassword(String password)
    {
        String regex = "[a-zA-Z]{6,}[@]([1-2][0-9][0-9][0-9])(((0[13578]|1[02])" +
                "([0-3][0-9]|31))|02[0-2][0-9]|((0[469]|11)[0-3][0-9]))";
        return password.matches(regex);
    }
}
