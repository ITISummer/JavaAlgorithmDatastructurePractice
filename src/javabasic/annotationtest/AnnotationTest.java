package javabasic.annotationtest;

/**
 * 注解使用
 */
public class AnnotationTest {

}

/**
 * Person
 */
@MyAnnotation(value = "hello")
class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void walk() {
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }
}

/**
 * Student
 */
class Student extends Person{

    public Student(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("学生走路");
    }
}
