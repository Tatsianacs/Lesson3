import exceptions.NoCaloriesException;
import exceptions.NoSuchSeedsSizeException;

public class VegetableFactory {
    private static int generativeVegCount = 0;
    private static int vegetativeVegCount = 0;
    private static int bigLeafVegCount = 0;
    private static int smallSeedsVegCount = 0;
    private static int importedVegCount = 0;

    public static Vegetable createVegetable(VegetableType vegetableType, String name, int calories, int protein, int carbs, int fat, boolean status, String size) throws NoCaloriesException, NoSuchSeedsSizeException {
        switch (vegetableType) {
            case GENERATIVE:
                generativeVegCount++;
                return new GenerativeVegetable(name, calories, protein, carbs, fat, status, size);
            case VEGETATIVE:
                vegetativeVegCount++;
                return new VegetativeVegetable(name, calories, protein, carbs, fat, status, size);
            case BIGLEAFVEGETABLE:
                bigLeafVegCount++;
                return new VegetativeVegetable(name, calories, protein, carbs, fat, status, "big");
            case SMALLSEEDSVEGETABLE:
                smallSeedsVegCount++;
                return new GenerativeVegetable(name, calories, protein, carbs, fat, status, "small");
            case IMPORTEDVEGVEGETABLE:
                importedVegCount++;
                return new VegetativeVegetable(name, calories, protein, carbs, fat, true, size);
            default:
                throw new IllegalArgumentException("Wrong vegetable type " + vegetableType);
        }
    }

    public static void printVegCount() {
        System.out.println("Number of vegetables created (by type):");
        System.out.println("Generative vegetables:" + generativeVegCount);
        System.out.println("Vegetative vegetables:" + vegetativeVegCount);
        System.out.println("Big leaf vegetables:" + bigLeafVegCount);
        System.out.println("Small seeds vegetables:" + smallSeedsVegCount);
        System.out.println("Imported vegetative vegetables:" + importedVegCount);
    }
}

enum VegetableType {
    GENERATIVE,
    VEGETATIVE,
    BIGLEAFVEGETABLE,
    SMALLSEEDSVEGETABLE,
    IMPORTEDVEGVEGETABLE
}