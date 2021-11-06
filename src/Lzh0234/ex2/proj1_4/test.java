package Lzh0234.ex2.proj1_4;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.shape.Circle;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/10 23:37
 * @Description:
 */
public class test
{
    public static void main(String[] args) throws Exception
    {
        //获取类上的注解
        Class<User> testClass = User.class;
        MyAnnotation annotationOnClass = testClass.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getValue());

        //获取变量上的注解
        Field name = testClass.getField("name");
        MyAnnotation annotationOnField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnField.getValue());

        //获取方法上的注解
        Method hello = testClass.getMethod("hello", null);
        MyAnnotation annotationOnMethod = hello.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.getValue());

        //获取方法上的注解
        Method helloD = testClass.getMethod("defaultMethod",null);
        MyAnnotation annotationOnDefaultMethod = helloD.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnDefaultMethod.getValue());
    }
}
