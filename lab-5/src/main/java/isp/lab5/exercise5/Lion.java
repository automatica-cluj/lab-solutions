package isp.lab5.exercise5;

public class Lion extends Animal implements Carnivorous {
    private final int chanceToHuntSuccessfully;

    public Lion(String name, int age, int chanceToHuntSuccessfully) {
        super(name, age);
        this.chanceToHuntSuccessfully = chanceToHuntSuccessfully;
    }

    @Override
    public void eat() {
        System.out.println("Lion eats meat");
    }

    @Override
    public void huntSuccessfully() {
        System.out.println("Lion " + this.name + " hunt successfully at age " + this.age + " with a chance of " + this.chanceToHuntSuccessfully + "%");
    }

    @Override
    public void huntFailed() {
        System.out.println("Lion " + this.name + " hunt failed at age " + this.age + " with a chance of " + this.chanceToHuntSuccessfully + "%");
    }

    @Override
    public int getChancesToHuntSuccessfully() {
        return chanceToHuntSuccessfully;
    }

    @Override
    public String toString() {
        return "Lion{" +
                "chanceToHuntSuccessfully=" + chanceToHuntSuccessfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
