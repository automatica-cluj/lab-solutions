package isp.lab5.exercise5;

public class Tiger extends Animal implements Carnivorous {
    private int chanceToHuntSuccessfully;

    public Tiger(String name, int age, int chanceToHuntSuccessfully) {
        super(name, age);
        this.chanceToHuntSuccessfully = chanceToHuntSuccessfully;
    }

    @Override
    public void eat() {
        System.out.println("Tiger eats meat");
    }

    @Override
    public void huntSuccessfully() {
        System.out.println("Tiger " + this.name + " hunt successfully at age " + this.age + " with a chance of " + this.chanceToHuntSuccessfully + "%");
    }

    @Override
    public void huntFailed() {
        System.out.println("Tiger " + this.name + " hunt failed at age " + this.age + " with a chance of " + this.chanceToHuntSuccessfully + "%");
    }

    @Override
    public int getChancesToHuntSuccessfully() {
        return this.chanceToHuntSuccessfully;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "chanceToHuntSuccessfully=" + chanceToHuntSuccessfully +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
