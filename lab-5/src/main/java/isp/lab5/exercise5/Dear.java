package isp.lab5.exercise5;

public class Dear extends Animal implements Herbivorous {
    private int chanceToRunSuccessfully;

    public Dear(String name, int age, int chanceToRunSuccessfully) {
        super(name, age);
        this.chanceToRunSuccessfully = chanceToRunSuccessfully;
    }

    @Override
    public void eat() {
        System.out.println("Dear eats grass");
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
        return "Dear{" +
                "chanceToRunSuccessfully=" + chanceToRunSuccessfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
