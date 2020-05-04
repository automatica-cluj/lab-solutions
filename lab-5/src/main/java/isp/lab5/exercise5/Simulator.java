package isp.lab5.exercise5;

import java.util.Random;

public class Simulator {
    private static final Random random = new Random();
    private final Jungle jungle;


    Simulator() {
        this.jungle = new Jungle(initializeHerbivores(), initializeCarnivores());
    }


    /**
     * Simulate a "battle" between Carnivores and Herbivores<br>
     * If an animal lose that one will be eliminated from the {@link Jungle}
     * If there are 2 animals from both sides with same chances and those chances are the higher from their side than there is a draw
     */
    public void simulate() {
        while (this.jungle.getHerbivores().length > 0 && this.jungle.getCarnivores().length > 0) {
            int positionHerbivores = random.nextInt(this.jungle.getHerbivores().length);
            int positionCarnivores = random.nextInt(this.jungle.getCarnivores().length);
            Herbivorous herbivore = this.jungle.getHerbivores()[positionHerbivores];
            Carnivorous carnivore = this.jungle.getCarnivores()[positionCarnivores];

            if (herbivore.getChanceToRunSuccessfully() > carnivore.getChancesToHuntSuccessfully()) {
                herbivore.runSuccessfully();
                carnivore.huntFailed();
                this.jungle.removeAnimalFromCarnivores(positionCarnivores);
            } else if (herbivore.getChanceToRunSuccessfully() < carnivore.getChancesToHuntSuccessfully()) {
                carnivore.huntSuccessfully();
                herbivore.runFailed();
                this.jungle.removeAnimalFromHerbivores(positionHerbivores);
            } else {
                if (isDraw()) {
                    System.out.println("There is a draw !!!");
                    printCarnivoresLeft();
                    printHerbivoresLeft();
                    return;
                }
            }
        }
        if (this.jungle.getHerbivores().length == 0) {
            System.out.println("Carnivores wins !!!");
            printCarnivoresLeft();
        } else {
            System.out.println("Herbivores wins !!!");
            printHerbivoresLeft();
        }
    }

    /**
     * Method which prints all {@link Herbivorous} from the jungle
     */
    private void printHerbivoresLeft() {
        System.out.println("The herbivores left are " + this.jungle.getHerbivores().length + ": ");
        for (Herbivorous herbivores : this.jungle.getHerbivores()) {
            System.out.println(herbivores);
        }
    }

    /**
     * Method which prints all {@link Carnivorous} from the jungle
     */
    private void printCarnivoresLeft() {
        System.out.println("The carnivores left are " + this.jungle.getCarnivores().length + ": ");
        for (Carnivorous carnivore : this.jungle.getCarnivores()) {
            System.out.println(carnivore);
        }
    }

    /**
     * This method create and return an array of {@link Herbivorous} of size 20 and random distributed between {@link Dear} and {@link Elk}
     *
     * @return array of {@link Herbivorous}
     */
    protected static Herbivorous[] initializeHerbivores() {
        Herbivorous[] herbivores = new Herbivorous[20];

        for (int i = 0; i < herbivores.length; i++) {
            if (random.nextInt(2) == 1) {
                Dear dear = new Dear(i + "", 3 * i, random.nextInt(101));
                herbivores[i] = dear;
                dear.eat();
            } else {
                Elk elk = new Elk(i + "", 3 * i, random.nextInt(101));
                herbivores[i] = elk;
                elk.eat();
            }
        }
        return herbivores;
    }

    /**
     * This method create and return an array of {@link Carnivorous} of size 20 and random distributed between {@link Lion} and {@link Tiger}
     *
     * @return array of {@link Carnivorous}
     */
    protected static Carnivorous[] initializeCarnivores() {
        Carnivorous[] carnivores = new Carnivorous[20];

        for (int i = 0; i < carnivores.length; i++) {
            if (random.nextInt(2) == 1) {
                Lion lion = new Lion(i + "", 3 * i, random.nextInt(101));
                carnivores[i] = lion;
                lion.eat();
            } else {
                Tiger tiger = new Tiger(i + "", 3 * i, random.nextInt(101));
                carnivores[i] = tiger;
                tiger.eat();
            }
        }
        return carnivores;
    }

    /**
     * This method verify if there is a draw in the current "battle"
     *
     * @return true if there is Draw, false otherwise
     */
    private boolean isDraw() {
        int bestChanceOfRun = 0;
        int bestChanceOfHunt = 0;
        for (int i = 0; i < this.jungle.getHerbivores().length; i++) {
            bestChanceOfRun = Math.max(this.jungle.getHerbivores()[i].getChanceToRunSuccessfully(), bestChanceOfRun);
        }

        for (int i = 0; i < this.jungle.getCarnivores().length; i++) {
            bestChanceOfHunt = Math.max(this.jungle.getCarnivores()[i].getChancesToHuntSuccessfully(), bestChanceOfHunt);
        }

        return bestChanceOfHunt == bestChanceOfRun;
    }
}
