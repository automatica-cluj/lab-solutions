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

    public void removeAnimalFromHerbivores(int index) {
        Herbivorous[] herbivorousArray = new Herbivorous[this.getHerbivores().length - 1];
        for (int i = 0, k = 0; i < this.getHerbivores().length; i++) {
            if (i == index) {
                continue;
            }
            herbivorousArray[k++] = this.getHerbivores()[i];
        }
        this.setHerbivores(herbivorousArray);
    }

    public void removeAnimalFromCarnivores(int index) {
        Carnivorous[] carnivoreArray = new Carnivorous[this.getCarnivores().length - 1];
        for (int i = 0, k = 0; i < this.getCarnivores().length; i++) {
            if (i == index) {
                continue;
            }
            carnivoreArray[k++] = this.getCarnivores()[i];
        }
        this.setCarnivores(carnivoreArray);
    }
}
