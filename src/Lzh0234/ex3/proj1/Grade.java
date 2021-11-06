package Lzh0234.ex3.proj1;

import java.util.Arrays;

/*
 * JavaExp Lzh0234.ex3
 * @Author:Demon
 * @Date:2021/11/3 20:07
 * @Description:
 */
public class Grade
{
    private String[] courseTitle;
    private double[] credit;
    private double[] gpa;
    private double[] peacetimeGrade;
    private double[] testGrade;
    private double[] finalGrade;

    public String[] getCourseTitle()
    {
        return courseTitle;
    }

    public void setCourseTitle(String[] courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public double[] getCredit()
    {
        return credit;
    }

    public void setCredit(double[] credit)
    {
        this.credit = credit;
    }

    public double[] getGpa()
    {
        return gpa;
    }

    public void setGpa(double[] gpa)
    {
        this.gpa = gpa;
    }

    public double[] getPeacetimeGrade()
    {
        return peacetimeGrade;
    }

    public void setPeacetimeGrade(double[] peacetimeGrade)
    {
        this.peacetimeGrade = peacetimeGrade;
    }

    public double[] getTestGrade()
    {
        return testGrade;
    }

    public void setTestGrade(double[] testGrade)
    {
        this.testGrade = testGrade;
    }

    public double[] getFinalGrade()
    {
        return finalGrade;
    }

    public void setFinalGrade(double[] finalGrade)
    {
        this.finalGrade = finalGrade;
    }


    public void calculateFinalGrade()
    {
        for (int i = 0; i < finalGrade.length; i++)
            this.finalGrade[i] =
                    0.3 * peacetimeGrade[i] + 0.7 * testGrade[i];
    }

    public void calculateGPA()
    {
        for (int i = 0; i < gpa.length; i++)
        {
            gpa[i] = (finalGrade[i] / 10) > 5 ? (finalGrade[i] / 10) - 5 : 0;
        }
    }

}
