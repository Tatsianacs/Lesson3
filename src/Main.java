import exceptions.EmptySaladException;
import exceptions.NoCaloriesException;
import exceptions.NoSuchSeedsSizeException;

public class Main {

    public static void main(String[] args) {
        VegetativeVegetable broccoli = null;
        VegetativeVegetable onion = null;
        GenerativeVegetable pumpkin = null;
        GenerativeVegetable tomato = null;
        GenerativeVegetable corn = null;
        Salad belarusianSalad = null;

        try {
            broccoli = new VegetativeVegetable("broccoli", 10, 3, 7, 0, true, "no");
            onion = new VegetativeVegetable("onion", 40, 1, 9, 0, false, "small");
            pumpkin = new GenerativeVegetable("pumpkin", 26, 1, 7, 0, false, "average");
            corn = new GenerativeVegetable("corn", 96, 3, 21, 2, true, "small");
            tomato = new GenerativeVegetable("tomato", 18, 1, 4, 0, true, "small");

        }
        catch(NoCaloriesException | NoSuchSeedsSizeException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Salad summerSalad = new Salad("Summer best", broccoli);
        }
        catch(EmptySaladException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            belarusianSalad = new Salad("Healthy7 Diet *12", broccoli, tomato, onion, pumpkin);
        }
        catch(EmptySaladException ex) {
            System.out.println(ex.getMessage());
        }

        belarusianSalad.removeIngredientFromSalad("broccoli");

        belarusianSalad.writeSaladInfo();
        belarusianSalad.readSaladInfo();

        try {
            Vegetable potatoes = VegetableFactory.createVegetable(VegetableType.VEGETATIVE, "potatoes", 10, 3, 7, 0, true, "no");
            Vegetable cucumber = VegetableFactory.createVegetable(VegetableType.GENERATIVE, "cucumber", 10, 3, 7, 0, true, "no");

        }
        catch(NoCaloriesException | NoSuchSeedsSizeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
