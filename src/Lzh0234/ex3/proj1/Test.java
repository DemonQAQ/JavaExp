package Lzh0234.ex3.proj1;

/*
 * JavaExp Lzh0234.ex3
 * @Author:Demon
 * @Date:2021/11/3 20:48
 * @Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        Randomf random =new Randomf();
        String[] courseTitle = new String[]{"大学英语","概率论与数理统计","数据库系统原理","面向对象程序设计"};
        String[] name=new String[]{"梁梓浩","曾鸭鸭","曾小号","积积斌","坚毅猪"};
        GHStudent[] students=new GHStudent[5];
        for (int i=0;i<students.length;i++)
        {
            students[i]=new GHStudent();
            students[i].setName(name[i]);
            students[i].setNumber(random.nextInt(40)+1);
            Grade temp=new Grade();
            temp.setCourseTitle(courseTitle);
            temp.setCredit(new double[]{random.nextDouble(3),random.nextDouble(3),
                    random.nextDouble(3),random.nextDouble(3)});
            temp.setPeacetimeGrade(new double[]{random.nextDouble(100),random.nextDouble(100),
                    random.nextDouble(100),random.nextDouble(100)});
            temp.setTestGrade(new double[]{random.nextDouble(100),random.nextDouble(100),
                    random.nextDouble(100),random.nextDouble(100)});
            temp.setFinalGrade(new double[4]);
            temp.setGpa(new double[4]);
            students[i].setGrade(temp);
            temp.calculateFinalGrade();
            temp.calculateGPA();
        }

        Banji se=new Banji();
        se.setStudents(students);
        se.setClassName("202班");
        se.setMajorName("软件工程");
        se.setPeopleNumber(students.length);
        se.setAvgGpa(new double[students.length]);
        se.updateGpa();

        double[] tempAvgGpa = se.getAvgGpa();
        GHStudent[] tempStudent =se.getStudents();
        for (int i=0;i<tempAvgGpa.length-1;i++)
        {
            for (int j=i+1;j<tempAvgGpa.length;j++)
            {
                if (tempAvgGpa[i]<tempAvgGpa[j])
                {
                    double temp = tempAvgGpa[j];
                    tempAvgGpa[j]=tempAvgGpa[i];
                    tempAvgGpa[i] = temp;

                    GHStudent temp_ = tempStudent[j];
                    tempStudent[j]=tempStudent[i];
                    tempStudent[i]=temp_;
                }
            }
        }
        se.setStudents(tempStudent);
        se.setAvgGpa(tempAvgGpa);

        for (int i=0;i<students.length;i++)
        {
            Print(students[i],se.getAvgGpa()[i]);
        }
    }
    public static void Print(GHStudent ghStudent,double avgGpa)
    {
        System.out.println(ghStudent.getName()+"的学号是"+ghStudent.getNumber());
        System.out.printf("平均绩点为:"+"%2.2f"+"\n",avgGpa);
        Grade grade = ghStudent.getGrade();
        System.out.print("课程名:");
        for (String s:grade.getCourseTitle()) System.out.print(s+"   ");
        System.out.print("\n");
        System.out.print("学分:");
        for (double s:grade.getCredit()) System.out.print(s+"   ");
        System.out.print("\n");
        System.out.print("平时成绩:");
        for (double s:grade.getPeacetimeGrade()) System.out.print(s+"   ");
        System.out.print("\n");
        System.out.print("考试成绩");
        for (double s:grade.getTestGrade()) System.out.print(s+"   ");
        System.out.print("\n");
        System.out.print("期末成绩:");
        for (double s:grade.getFinalGrade()) System.out.print(s+"   ");
        System.out.print("\n");
        System.out.print("GPA:");
        for (double s:grade.getGpa()) System.out.print(s+"   ");
        System.out.print("\n\n");

    }
}
