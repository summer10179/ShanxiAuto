package demo;


    class Dog {
        public void dog() {
            System.out.println("狗可以叫");
        }

    }
   class  xiaoDog extends  Dog{
        public void dog(){
            super.dog();
            System.out.println("小狗可以叫");
        }
        public void move(){
            System.out.println("小狗可以移动");
        }
    }
public class OverWriteTest {
    public static void main(String[] args) {
       Dog xiaogou=new xiaoDog();
       xiaogou.dog();
      // xiaogou.move();
       Dog dog=new Dog();
       dog.dog();



    }
}
