package be.pxl.ja.exercise;

public class Pet {

    private static final int MAX_ENERGY = 100;
    private static final int MIN_ENERGY = 0;
    private int energy;

    public Pet(int energy) {
        setEnergy(energy);
    }

    public void feed(String food){
        if ("chocolate".equals(food)){
            throw new WrongFoodException("You can't feed the pet chocolate");
        }
        setEnergy(energy + 20);
    }

    public void play() throws PetTiredException {
        if (energy < 20){
            throw new PetTiredException("Pet doesn't have the energy to play");
        }
        setEnergy(energy - 30);
    }

    private void setEnergy(int energy){
        this.energy = Math.max(MIN_ENERGY, Math.min(energy, MAX_ENERGY));
    }

    public int getEnergy(){
        return energy;
    }

    @Override
    public String toString() {
        return "Pet's energy level is " + energy;
    }
}
