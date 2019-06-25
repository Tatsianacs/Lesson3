import exceptions.NoCaloriesException;
import exceptions.NoSuchSeedsSizeException;

import java.util.Arrays;

public class GenerativeVegetable extends Vegetable {

    private String seedsSize;
    private String[] allPossibleSeedsSizes = {"average", "small", "big"};

    GenerativeVegetable(String name, int calories, int protein, int carbs, int fat, boolean isImported, String seedsSize) throws NoCaloriesException, NoSuchSeedsSizeException {
        super(name, calories, protein, carbs, fat, isImported);
        if (!Arrays.asList(allPossibleSeedsSizes).contains(seedsSize)) {
            throw new NoSuchSeedsSizeException("Invalid seeds size.", seedsSize);
        }
        this.seedsSize = seedsSize;
    }

    @Override
    public void printVegetableInfo() {
        System.out.printf("This is Generative Vegetable. Vegetable name is [%s], it has [%s] seeds. CPFC is [%d]/[%d]/[%d]/[%d] ",
                getVegetableName(), seedsSize, getVegetableCalories(), getVegetableProtein(), getVegetableFat(), getVegetableCarbs());
    }

    public void eatGenerativeVegetable() {
        System.out.println("Used in food: fruits, seeds, young ovaries");
    }
}
