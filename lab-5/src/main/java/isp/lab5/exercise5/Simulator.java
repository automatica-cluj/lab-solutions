package isp.lab5.exercise5;

import java.util.Random;

public class Simulator {
    private final Random random = new Random();
    private Jungle jungle;


    Simulator() {
        this.jungle = new Jungle(initializeHerbivores(20), initializeCarnivores(20));
    }

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

    private void printHerbivoresLeft() {
        System.out.println("The herbivores left are " + this.jungle.getHerbivores().length + ": ");
        for (Herbivorous herbivores : this.jungle.getHerbivores()) {
            System.out.println(herbivores);
        }
    }

    private void printCarnivoresLeft() {
        System.out.println("The carnivores left are " + this.jungle.getCarnivores().length + ": ");
        for (Carnivorous carnivore : this.jungle.getCarnivores()) {
            System.out.println(carnivore);
        }
    }

//    private void removeAnimalFromHerbivores(Herbivorous[] arr, int index) {
//        Herbivorous[] herbivorousArray = new Herbivorous[arr.length - 1];
//        for (int i = 0, k = 0; i < arr.length; i++) {
//            if (i == index) {
//                continue;
//            }
//            herbivorousArray[k++] = arr[i];
//        }
//        this.jungle.setHerbivores(herbivorousArray);
//    }
//
//    private void removeAnimalFromCarnivores(Carnivorous[] arr, int index) {
//        Carnivorous[] carnivoreArray = new Carnivorous[arr.length - 1];
//        for (int i = 0, k = 0; i < arr.length; i++) {
//            if (i == index) {
//                continue;
//            }
//            carnivoreArray[k++] = arr[i];
//        }
//        this.jungle.setCarnivores(carnivoreArray);
//    }

    private Herbivorous[] initializeHerbivores(int n) {
        Herbivorous[] herbivores = new Herbivorous[n];

        for (int i = 0; i < herbivores.length; i++) {
            if (random.nextInt(2) == 1) {
                Dear dear = new Dear(i + "", 3 * i, random.nextInt(101));
                herbivores[i] = dear;
                dear.eat();
            } else {
                herbivores[i] = new Elk(i + "", 3 * i, random.nextInt(101));
            }
        }
        return herbivores;
    }

    private Carnivorous[] initializeCarnivores(int n) {
        Carnivorous[] carnivores = new Carnivorous[n];

        for (int i = 0; i < carnivores.length; i++) {
            if (random.nextInt(2) == 1) {
                carnivores[i] = new Lion(i + "", 3 * i, random.nextInt(101));
            } else {
                carnivores[i] = new Tiger(i + "", 3 * i, random.nextInt(101));
            }
        }
        return carnivores;
    }

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
