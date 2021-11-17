package Lzh0234.ex6.prjo1;

public class NoAgeException extends Exception
{
    NoAgeException(String message)
    {
        super(message);
    }
    public static void checkAge(int age)
    {
        if (age<0||age>150) try {
            throw new NoAgeException("年龄的范围为(0,150]");
        } catch (NoAgeException e) {
            e.printStackTrace();
        }
    }
}
