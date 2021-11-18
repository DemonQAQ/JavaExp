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

    public void start()
    {
        gainPoints(this.tree);
        dividePoints();
        //writeToTree(tree.points.toArray(new String[0][0])[0],0);
        System.out.println("多边形面积为" + sumTotal());
    }

    private void gainPoints(PointTree tree)
    {

        if (tree.getLength() == 0)
        {
            inputPoints(tree);
            System.out.println("是否有岛洞?t/f");
            if (SCANNER.next().equals("t"))
            {
                tree.createChild();
                gainPoints(tree.next);
            }
        } else
        {
            System.out.println("当前层数" + (tree.getLength() + 1) + ",请输入岛洞数量");
            int length = SCANNER.nextInt();
            for (int i = 0; i < length; i++)
            {
                System.out.println("正在输入第" + i + "个岛洞");
                inputPoints(tree);
                System.out.println("当前岛洞内是否有岛洞？t/f");
                if (SCANNER.next().equals("t"))
                {
                    tree.createChild();
                    gainPoints(tree.next);
                }
            }
        }
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
        for (int i = 0; i < points.length; i++)
        {
            if (points[i].getName().equals(name)) return points[i];
        }
        return null;
    }

    private void inputPoints(PointTree tree)
    {
        String name;
        double x;
        double y;
        ArrayList<String> pointSet = new ArrayList<>();
        System.out.println("当前层数:第" + (tree.getLength() + 1) + "层");
        System.out.println("请按顺时针输入全部顶点");
        while (true)
        {
            System.out.println("请输入点名称(唯一)");
            name = SCANNER.next();
            if (name.equals("end")) break;
            System.out.println("请输入坐标x");
            x = SCANNER.nextDouble();
            System.out.println("请输入坐标y");
            y = SCANNER.nextDouble();
            if (havePoint(name))
            {
                Point temp = findPoint(name);
                if (temp.getX() != x || temp.getY() != y)
                {
                    System.out.println("已存在点" + name + "," +
                            "请为每个坐标赋予唯一标识符");
                    continue;
                }
            } else
            {

                Point point = new Point(name, x, y);
                this.points.add(point);
            }
            pointSet.add(name);
            System.out.println("继续输入点，如输入完毕输入“end”结束");
        }
        tree.points.add(pointSet.toArray(new String[0]));

    }

    private void dividePoints()
    {
        divide(tree.points.toArray(new String[0][0])[0], 0);
        if (tree.next != null)
        {
            PointTree root = tree.next;
            while (root != null)
            {
                String[][] strings = root.points.toArray(new String[0][0]);
                for (int i = 0; i < strings.length; i++)
                {
                    divide(strings[i], root.getLength());
                }
                root = root.next;
            }
        }
    }

    private void divide(String[] points, int length)
    {
        boolean rootFlag = true;
        for (int i = 0; i < points.length - 1; i++)
        {
            for (int j = i + 1; j < points.length; j++)
            {

                if (points[i].equals(points[j]))
                {
                    if (i == 0 && j == points.length - 1) continue;
                    String[] points1 = new String[points.length - j + i];
                    String[] points2 = new String[j - i];
                    rootFlag = false;
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
                    divide(points1, length + 1);
                    //中间
                    index = i + 1;
                    for (int i1 = 0; i1 < points2.length; i1++)
                    {
                        if (index > j) break;
                        points2[i1] = points[index];
                        index++;
                    }
                    divide(points2, length + 1);
                }
            }
        }
        if (rootFlag) writeToTree(points, Math.max(length - 1, 0));

    }

    private void writeToTree(String[] points, int length)
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

    private double sumTotal()
    {
        double s = 0, temp = 0;
        PointTree root = tree;
        while (root != null)
        {
            temp = 0;
            Point[][] points = root.pointsDivided.toArray(new Point[0][0]);
            for (int i = 0; i < points.length; i++)
            {
                temp += Shoelace(points[i]);
            }
            if (root.getLength() % 2 == 1) s += (-1 * temp);
            else s += temp;
            root = root.next;
        }
        return s;
    }

    //需要有序的点集
    private double Shoelace(Point[] points)
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
