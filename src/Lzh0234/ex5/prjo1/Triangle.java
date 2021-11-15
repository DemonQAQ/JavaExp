package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:04
 * @Description:
 */
public class Triangle extends Shape
{
    //a,b,c为三角形的三条边
    Triangle(double a, double b, double c) throws Exception
    {
        super();
        if (a < 0 || b < 0 || c < 0)
        {
            throw new Exception("边长不能小于0");
        } else setSide(new double[]{a, b, c});

    }

    @Override
    public double area()
    {
        double[] side = getSide();
        if (side == null) return -1;
        else
        {
            if (side[0] + side[1] > side[2] && side[1] + side[2] > side[0] && side[0] + side[2] > side[1])
            {
                double avg = (side[0] + side[1] + side[2]) / 2.0;
                return Math.sqrt(avg * (avg - side[0]) * (avg - side[1]) * (avg - side[2]));
            } else return -1;
        }
    }
}
