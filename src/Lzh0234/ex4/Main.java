package Lzh0234.ex4;

/*
 * JavaExp Lzh0234.ex4
 * @Author:Demon
 * @Date:2021/11/5 17:26
 * @Description:
 */
public class Main
{
    public static void main(String[] args)
    {
        int[][] square=new int[][]{{1,0,0},{0,5,0},{0,0,0}};
        long startMili=System.nanoTime();
        ThreeStageMagicSquare.lock(square);
        ThreeStageMagicSquare.thricePoint(square,0,0,false);
        //ThreeStageMagicSquare.create(square,0,1);//1760400
        //ThreeStageMagicSquare.lock(square);
        //ThreeStageMagicSquare.twicePoint(square,0,1);
        //ThreeStageMagicSquare.lock(square);
        //ThreeStageMagicSquare.twicePoint(square,1,0);
        //ThreeStageMagicSquare.lock(square);
        //boolean flag = ThreeStageMagicSquare.thricePoint(square,0,0,false);
        //ThreeStageMagicSquare.test(square);
        long endMili=System.nanoTime();
        //if (!flag)System.out.println("failed");
        //else
        System.out.println(endMili-startMili);
        {
            for (int i=0;i<3;i++)
            {
                for (int j=0;j<3;j++)
                {
                    System.out.print(square[i][j]+"  ");
                }
                System.out.println();
            }
        }

    }
}
