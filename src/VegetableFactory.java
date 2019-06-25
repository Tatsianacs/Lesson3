import exceptions.NoCaloriesException;
import exceptions.NoSuchSeedsSizeException;

public class VegetableFactory
{
    public static Vegetable createVegetable(VegetableType vegetableType, String name, int calories, int protein, int carbs, int fat, boolean status, String size) throws NoCaloriesException, NoSuchSeedsSizeException
    {
        switch(vegetableType)
        {
            case GENERATIVE:
            return new GenerativeVegetable(name, calories, protein, carbs, fat, status, size);
            case VEGETATIVE:
            return new VegetativeVegetable(name, calories, protein, carbs, fat, status, size);
            default:
                throw new IllegalArgumentException("Wrong vegetable type " + vegetableType);
        }
    }
}

enum VegetableType
{
    GENERATIVE,
    VEGETATIVE
}