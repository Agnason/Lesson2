public class Dog extends Animal{
    static int countDog;
    public Dog(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
        countDog++;
    }

    @Override
    public void run(int lengthRun) {
        System.out.print("Собака ");
        super.run(lengthRun);
    }

    @Override
    public void swim(int lengthSwim) {
        System.out.print("Собака ");
        super.swim(lengthSwim);
    }



}
