package Lzh0234.ex5.prjo1;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/12 17:04
 * @Description:
 */
public class Rectangle extends Shape
{
    //a，b为长方形的长，宽
    public Rectangle(double a,double b) throws Exception
    {
        super();
        if (a<0||b<0)
        {
            throw new Exception("边长不能小于0");
        }
        else setSide(new double[]{a,b});
    }

    @Override
    public double area()
    {
        return getSide()[0]*getSide()[1];
    }
}
