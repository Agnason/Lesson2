public abstract class Animal {
    static int countAnimal;
    protected String name;
    protected int limitRun;
    protected int limitSwim;

    public Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        countAnimal++;
    }

    public int getLimitRun() {
        return limitRun;
    }

    public void setLimitRun(int limitRun) {
        this.limitRun = limitRun;
    }

    public int getLimitSwim() {
        return limitSwim;
    }

    public void setLimitSwim(int limitSwim) {
        this.limitSwim = limitSwim;
    }

    public void run(int lengthRun) {
        if (limitRun >= lengthRun) {
            System.out.println(name + " пробежал " + lengthRun + " м");
        } else {
            System.out.println(name + " не пробежит. " + "Максимум может - " + getLimitRun() + "м" );
        }
    }

    public void swim(int lengthSwim) {
        if (limitSwim >= lengthSwim) {
            System.out.println(name + " проплыл " + lengthSwim + " м");
        } else {
            System.out.println(name + " не проплывёт. " +"Максимум может - " + getLimitSwim() + "м" );
        }
    }
}

