package Lzh0234.ex6.prjo2;

public class IllegalArgumentException extends Exception
{
    IllegalArgumentException(String message)
    {
        super(message);
    }
    public static void checkSide(int[] sides)
    {
        if (sides.length!=3)return;
        if (sides[0]+sides[1]<=sides[2]||sides[0]+sides[2]<=sides[1]||sides[1]+sides[2]<=sides[0])
        {
            try
            {
                throw new IllegalArgumentException("三边无法构成三角形");
            } catch (IllegalArgumentException e)
            {
                e.printStackTrace();
            }
        }
    }
}
