package Lzh0234.ex2.proj1_4;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/4 17:27
 * @Description:
 */
public class PrimeNumberOutput
{
    private static final int ARRAY_LENGTH = 1000;
    private static boolean[] PrimeNumberFlag = new boolean[ARRAY_LENGTH];

    public static void PrimeNumberDisplay()
    {
        System.out.println();
        PrimeNumberJudge();
        System.out.println("0-1000内的素数为:");
        System.out.print("2  ");
        for (int i=3;i<ARRAY_LENGTH;i+=2)
        {
            if (PrimeNumberFlag[i])System.out.print(i+"  ");
        }
    }

    private static void PrimeNumberJudge()
    {
        for (int i = 1; i < ARRAY_LENGTH; i += 2) PrimeNumberFlag[i] = true;
        for (int i = 3; i < Math.sqrt(ARRAY_LENGTH); i += 2)
        {
            if (PrimeNumberFlag[i])
                for (int j = i + i; j < ARRAY_LENGTH; j += i) PrimeNumberFlag[j] = false;
        }
    }
}
