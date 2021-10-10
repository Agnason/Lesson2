public class AnimalTest {

    public static void main(String[] args) {

        
        Cat tvar1 = new Cat("Тосик",200, 500);
        tvar1.run(150);
        Cat cat1= new Cat("Бомбео", 200, 500);
        cat1.run (50);
        cat1.swim(40);
        Dog dog1=new Dog("Бобик", 500, 10);
        dog1.run (50);
        dog1.swim(40);
        System.out.println("Создано животных: "+ Animal.countAnimal);
        System.out.println("Создано котов: "+ Cat.countCat);
        System.out.println("Создано собак: "+ Dog.countDog);

    }
}

