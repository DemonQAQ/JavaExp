package Lzh0234.ex6.prjo2;

public class Test
{
    public static void main(String[] args)
    {
        int[] sides = new int[]{3,4,5};
        IllegalArgumentException.checkSide(sides);
        sides=new int[]{2,2,4};
        IllegalArgumentException.checkSide(sides);
    }
}
