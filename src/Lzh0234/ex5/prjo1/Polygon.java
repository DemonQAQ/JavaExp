package Lzh0234.ex5.prjo1;

import java.util.*;

/*
 * JavaExp Lzh0234.ex5.prjo1
 * @Author:Demon
 * @Date:2021/11/14 16:45
 * @Description:
 */
public class Polygon
{
    private ArrayList<Point> points;
    private PointTree tree;
    private static final Scanner SCANNER = new Scanner(System.in);

    Polygon()
    {
        points = new ArrayList<>();
        tree = new PointTree();
    }

    public ArrayList<Point> getPoints()
    {
        return points;
    }

    public void setPoints(Point point)
    {
        this.points.add(point);
    }

    private boolean havePoint(String name)
    {
        Point[] points = this.points.toArray(new Point[this.points.size()]);
        for (int i = 0; i < points.length; i++)
        {
            if (points[i].getName().equals(name)) return true;
        }
        return false;
    }

    private Point findPoint(String name)
    {
        Point[] points = this.points.toArray(new Point[this.points.size()]);
        for (int i=0;i< points.length;i++)
        {
            if (points[i].getName().equals(name))return points[i];
        }
        return null;
    }

    public void inputPoints()
    {
        PointTree root = tree;
        int length = 0;
        String name;
        double x;
        double y;
        System.out.println("请输入多边形的坐标，如有岛洞则从最外层坐标按层输入");
        System.out.println("当前层数:第" + length+1 + "层");
        while (root.getLength()!=length)root=root.next;
        while (true)
        {
            name = SCANNER.next();
            if (name.equals("end")) break;
            x = SCANNER.nextDouble();
            y = SCANNER.nextDouble();
            if (havePoint(name))
            {
                Point temp = findPoint(name);
                if (temp.getX()!=x||temp.getY()!=y)
                {
                    System.out.println("已存在点"+name+"," +
                            "请为每个坐标赋予唯一标识符");
                    continue;
                }
            } else
            {

                Point point = new Point(name, x, y);
                points.add(point);
            }
            root.points.add(name);
        }
    }

    public void dividePoints(String[] points, int length)
    {
        for (int i = 0; i < points.length - 1; i++)
        {
            for (int j = i + 1; j < points.length; j++)
            {

                if (points[i].equals(points[j]))
                {
                    if (i == 0 && j == points.length - 1) continue;
                    String[] points1 = new String[points.length - j + i];
                    String[] points2 = new String[j - i];
                    int index = 0;
                    //两边
                    for (int i1 = 0; i1 < points1.length; i1++)
                    {
                        points1[i1] = points[index];
                        if (index == i)
                        {
                            if (index + 1 == points1.length) break;
                            else index = j + 1;
                        } else index++;
                    }
                    dividePoints(points1, length + 1);
                    //中间
                    for (int i1 = i + 1; i <= j; i1++)
                    {
                        points2[i1] = points[i1];
                    }
                    dividePoints(points2, length + 1);
                }
            }
        }
        writeToTree(points, length);

    }

    public void writeToTree(String[] points, int length)
    {
        Point[] temp = this.points.toArray(new Point[this.points.size()]);
        Point[] divide = new Point[points.length];
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < this.points.size(); j++)
            {
                if (temp[j].getName().equals(points[i]))
                {
                    divide[i] = temp[j];
                }
            }
        }
        PointTree root = tree;
        while (root.getLength() != length) root = root.next;
        root.pointsDivided.add(divide);
    }

    //需要有序的点集
    public double Shoelace(Point[] points)
    {
        double s = 0;
        int j;
        for (int i = 0; i < points.length; i++)
        {
            j = (i + 1) % points.length;
            s += (points[i].getX() * points[j].getY()) - (points[j].getX() * points[i].getY());
        }
        return s > 0 ? s / 2.0 : (-s) / 2.0;
    }
}
