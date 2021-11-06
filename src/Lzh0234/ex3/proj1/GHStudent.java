package Lzh0234.ex3.proj1;

/*
 * JavaExp Lzh0234.ex3
 * @Author:Demon
 * @Date:2021/11/3 20:05
 * @Description:
 */
public class GHStudent
{
    private int number;
    private Grade Grade;
    private String name;

    GHStudent(){};

    GHStudent(int number,String name)
    {
        this.number=number;
        this.name=name;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public Lzh0234.ex3.proj1.Grade getGrade()
    {
        return Grade;
    }

    public void setGrade(Lzh0234.ex3.proj1.Grade grade)
    {
        Grade = grade;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double calculateAvgGPA()
    {
        double tempGPA=0,temp=0;
        double[] tempCredit= Grade.getCredit();
        double[] tempGpa= Grade.getGpa();
        for(int i=0;i<Grade.getGpa().length;i++)tempGPA +=tempGpa[i];
        for(int i=0;i<Grade.getGpa().length;i++)temp +=tempGpa[i]*tempCredit[i];
        return temp/tempGPA;

    }
}
