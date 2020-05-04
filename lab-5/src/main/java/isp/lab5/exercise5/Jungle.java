package isp.lab5.exercise5;

public class Jungle {

    private Herbivorous[] herbivores;
    private Carnivorous[] carnivores;

    public Jungle(Herbivorous[] herbivores, Carnivorous[] carnivores) {
        this.herbivores = herbivores;
        this.carnivores = carnivores;
    }

    public Herbivorous[] getHerbivores() {
        return herbivores;
    }

    public Carnivorous[] getCarnivores() {
        return carnivores;
    }

    public void setHerbivores(Herbivorous[] herbivores) {
        this.herbivores = herbivores;
    }

    public void setCarnivores(Carnivorous[] carnivores) {
        this.carnivores = carnivores;
    }

    /**
     * This method remove an {@link Herbivorous} from the herbivores at the corresponding index
     *
     * @param index position of the {@link Herbivorous} in herbivores array
     */
    public void removeAnimalFromHerbivores(int index) {
        Herbivorous[] herbivorousArray = new Herbivorous[this.getHerbivores().length - 1];
        int k = 0;
        for (int i = 0; i < this.getHerbivores().length; i++) {
            if (i == index) {
                continue;
            }
            herbivorousArray[k++] = this.getHerbivores()[i];
        }
        this.setHerbivores(herbivorousArray);
    }

    /**
     * This method remove an {@link Carnivorous} from the carnivores at the corresponding index
     *
     * @param index position of the {@link Carnivorous} in carnivores array
     */
    public void removeAnimalFromCarnivores(int index) {
        Carnivorous[] carnivoreArray = new Carnivorous[this.getCarnivores().length - 1];
        int k = 0;
        for (int i = 0; i < this.getCarnivores().length; i++) {
            if (i == index) {
                continue;
            }
            carnivoreArray[k++] = this.getCarnivores()[i];
        }
        this.setCarnivores(carnivoreArray);
    }
}
