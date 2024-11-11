public abstract class Pet {
    String name;
    Integer age;
    public void hello(String name){
        System.out.println("Hello " + name);
    }

    public abstract void sound();
}

class Cat extends Pet{
    public void sound(){
        System.out.println("Meow");
    }
}
