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
        ThreeStageSquare.execute(square,2,0);
        //16ms,18ms,17ms,16ms,15ms,18ms,17ms,15ms,16ms,18ms
        //ThreeStageMagicSquare.test(square);
        //1000ms,1200ms,500ms,2800ms,1000ms,300ms,100ms,1100ms,400ms,200ms
        long endMili=System.nanoTime();
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
