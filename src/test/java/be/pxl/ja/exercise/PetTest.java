package be.pxl.ja.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PetTest {
    private static final int INITIAL_ENERGY = 50;
    private Pet pet;
    @BeforeEach
    public void init(){
        pet = new Pet(INITIAL_ENERGY);
    }
    @Test
    public void testConstructorWithEnergyBelowZero(){
        Pet pet = new Pet(-5);
        assertNotNull(pet);
        assertEquals(0, pet.getEnergy());
    }
    @Test
    public void testConstructorWithEnergyBetweenZeroAndOneHundred(){
        assertEquals(50, pet.getEnergy());
    }
    @Test
    public void testConstructorWithEnergyAboveOneHundred(){
        Pet pet = new Pet(Pet.MAX_ENERGY + 20);
        assertEquals(Pet.MAX_ENERGY, pet.getEnergy());
    }
    @Test
    public void feedIncreasesEnergyWithTwenty(){
        pet.feed("dogfood");
        assertEquals(INITIAL_ENERGY + 20, pet.getEnergy());
    }
    @Test
    public void feedChocolateThrowsWrongFoodException(){
        WrongFoodException exception = assertThrows(WrongFoodException.class, () -> pet.feed("chocolate"));
        assertEquals("You can't feed the pet chocolate", exception.getMessage());
        assertTrue(exception.getMessage().contains("chocolate"));
        assertEquals(50, pet.getEnergy());
    }
    @Test
    public void feedEnergyDoesNotExceedOneHundred(){
        pet.feed("dogFood");
        pet.feed("fish");
        pet.feed("anotherDog");
        assertEquals(Pet.MAX_ENERGY, pet.getEnergy());
    }
    @Test
    public void playDecreasesEnergyWithThirty() throws PetTiredException {
        pet.play();
        assertEquals(20, pet.getEnergy());
    }
    @Test
    public void playEnergyBelowTwentyThrowsPetTiredException() throws PetTiredException {
        // ARRANGE = testdata
        pet.play();
        pet.play();
        // ACT = testmethodes aanroepen
        // ASSERT = verifiëren of alles correct is
        PetTiredException exception = assertThrows(PetTiredException.class, () -> pet.play());
        assertEquals("Pet doesn't have the energy to play", exception.getMessage());
        assertTrue(exception.getMessage().contains("energy"));
        assertEquals(0, pet.getEnergy());
    }
    @Test
    public void playEnergyCannotDecreaseBelowZero() throws PetTiredException {
        pet = new Pet(20);
        pet.play();
        assertEquals(Pet.MIN_ENERGY, pet.getEnergy());
    }
    @Test
    public void testToString(){
        assertEquals("Pet's energy level is 50", pet.toString());
    }
}
