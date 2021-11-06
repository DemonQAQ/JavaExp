package Lzh0234.ex3.proj1;

/*
 * JavaExp Lzh0234.ex3
 * @Author:Demon
 * @Date:2021/11/3 20:07
 * @Description:
 */
public class Banji
{
    private String majorName;
    private String className;
    private int peopleNumber;
    private GHStudent[] students;
    private double avgGpa[];


    public double[] getAvgGpa()
    {
        return avgGpa;
    }

    public void setAvgGpa(double[] avgGpa)
    {
        this.avgGpa = avgGpa;
    }


    public String getMajorName()
    {
        return majorName;
    }

    public void setMajorName(String majorName)
    {
        this.majorName = majorName;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public int getPeopleNumber()
    {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber)
    {
        this.peopleNumber = peopleNumber;
    }

    public GHStudent[] getStudents()
    {
        return students;
    }

    public void setStudents(GHStudent[] students)
    {
        this.students = students;
    }

    public void updateGpa()
    {
        for (int i=0;i<students.length;i++)
        {
            avgGpa[i]=students[i].calculateAvgGPA();
        }
    }
}
