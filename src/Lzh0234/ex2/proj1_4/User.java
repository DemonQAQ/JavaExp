package Lzh0234.ex2.proj1_4;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/25 19:25
 * @Description:
 */
@MyAnnotation(getValue = "in class")
public class User
{
    @MyAnnotation(getValue = "in field")
    public String name;

    @MyAnnotation(getValue = "in method")
    public void hello(){}

    @MyAnnotation
    public void defaultMethod(){}
}
