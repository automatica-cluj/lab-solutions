package isp.lab5.exercise5;

public class Elk extends Animal implements Herbivorous {

    private final int chanceToRunSuccessfully;

    public Elk(String name, int age, int chanceToRunSuccessfully) {
        super(name, age);
        this.chanceToRunSuccessfully = chanceToRunSuccessfully;
    }

    @Override
    public void eat() {
        System.out.println("Elk eats grass");
    }

    @Override
    public void runSuccessfully() {
        System.out.println("Elk " + this.name + " run successfully at age " + this.age + " with a chance of " + this.chanceToRunSuccessfully + "%");
    }

    @Override
    public void runFailed() {
        System.out.println("Elk " + this.name + " run failed at age " + this.age + " with a chance of " + this.chanceToRunSuccessfully + "%");
    }

    @Override
    public int getChanceToRunSuccessfully() {
        return chanceToRunSuccessfully;
    }

    @Override
    public String toString() {
        return "Elk{" +
                "chanceToRunSuccessfully=" + chanceToRunSuccessfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
