package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:44
 * @Description:
 */
public class Test
{
    public static void main(String[] args) throws Exception
    {
        Point[] points=new Point[]{new Point("A",-1,1),new Point("A",0,0),new Point("B",2,0),
                new Point("F",3,1), new Point("C",2,2),new Point("E",1,3), new Point("D",0,2)};
        System.out.println(new Polygon().Shoelace(points));
    }
}
