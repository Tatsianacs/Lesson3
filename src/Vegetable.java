import exceptions.NoCaloriesException;

public abstract class Vegetable {

    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private boolean isImported;
    private String name;


    Vegetable(String name, int calories, int protein, int carbs, int fat, boolean isImported) throws NoCaloriesException {
        this.name = name;
        if (calories == 0) {
            throw new NoCaloriesException("Vegetable cannot contain 0 calories");
        }
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.isImported = isImported;
    }
    abstract public void printVegetableInfo();

    public void washVegetable() {
        System.out.println("Turn on water and wash");
    }

    public String getVegetableName() {
        return name;
    }

    public int getVegetableCalories() {
        return calories;
    }

    public int getVegetableProtein() {
        return protein;
    }

    public int getVegetableCarbs() {
        return carbs;
    }

    public int getVegetableFat() {
        return fat;
    }

    public boolean getVegetableImportedStatus() {
        return isImported;
    }

}
