public class Cat extends Animal {
static int countCat;
    public Cat(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
        countCat++;
    }

    @Override
    public void run(int lengthRun) {
        System.out.print("Кот ");
        super.run(lengthRun);
    }

    @Override
    public void swim(int lengthSwim) {
        System.out.println ("Кот " + name + " не умеет плавать");
    }
}
