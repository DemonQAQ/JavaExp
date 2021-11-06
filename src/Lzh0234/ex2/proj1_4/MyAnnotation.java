package Lzh0234.ex2.proj1_4;

/*
 * JavaExp Lzh0234.ex2.proj1_4
 * @Author:Demon
 * @Date:2021/10/25 21:15
 * @Description:
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 注解类用于提供标记
* 注解的行为需要额外的监听类来执行
* 运行逻辑: 由注解类提供注解 -> 使用注解 -> 监听器监听到注解后执行操作
* */

// @Documented 制作文档用的注解

// @Target 标注注解生效的范围，TYPE代表可绑定在数据类型上、FIELD(成员变量)、METHOD(方法)

//@Retention 标注注解的保存范围，标记为RUNTIME代表保存在jvm上，CLASS和SOURCE代表保存在.class和.java
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    //注解的属性值
    String getValue() default "demon";
}
