import exceptions.EmptySaladException;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Salad {
    private String name;
    ArrayList<Vegetable> ingredients;
    private int saladCalories = 0;

    Salad(String name, Vegetable... ingredient) throws EmptySaladException {
        if (ingredient.length < 2) {
            throw new EmptySaladException("Salad should contain at least 2 ingredients");
        }
        this.name = name;
        ingredients = new ArrayList<Vegetable>();
        for (Vegetable specificVeg : ingredient) {
            this.saladCalories += specificVeg.getVegetableCalories();
            this.ingredients.add(specificVeg);
        }
    }

    public String getSaladName() {
        return name;
    }

    public Salad setSaladName(String name) {
        this.name = name;
        return this;
    }

    public int getSaladCalories() {
        return saladCalories;
    }

    public void addIngredientToSalad(Vegetable ing) {
        System.out.println("New ingredient is added.");
        this.ingredients.add(ing);
        this.saladCalories += ing.getVegetableCalories();
    }

    public void removeIngredientFromSalad(String name) {
        Iterator itr = ingredients.iterator();
        while (itr.hasNext()) {
            Vegetable veg = (Vegetable) itr.next();
            String vegNameToBeRemoved = veg.getVegetableName();
            if (vegNameToBeRemoved.equals(name)) {
                System.out.println("Ingredient is removed");
                this.saladCalories -= veg.getVegetableCalories();
                itr.remove();
                break;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public void printSaladInfo() {
        System.out.printf("This is salad with the name [%s]. It has calories: [%d]. Now the salad consists of the following ingredients: \n", name, saladCalories);
        for (Vegetable specificVeg : ingredients) {
            System.out.println(specificVeg.getVegetableName());
        }
    }

    public void sortVegetablesInSalad() {
        System.out.println("Vegs are sorted in Salad.");
        ingredients.sort(Comparator.comparingInt(Vegetable::getVegetableCalories).reversed());
    }

    public void findAndPrintIngredientsByNutrition(int minCal, int maxCal, int maxCarbs) {
        ingredients.stream()
                .filter(el -> el.getVegetableCalories() >= minCal && el.getVegetableCalories() <= maxCal && el.getVegetableCarbs() <= maxCarbs)
                .forEach(el -> System.out.println("Required vegetable is " + el.getVegetableName()));

    }

    public void findIngredientByNutrition(int minCal, int maxCal, int maxCarbs) {
        ingredients.stream()
                .filter(el -> el.getVegetableCalories() >= minCal && el.getVegetableCalories() <= maxCal && el.getVegetableCarbs() <= maxCarbs)
                .findFirst().orElseThrow(() -> new RuntimeException("No ingredient can be found by required criteria"));

    }

    public void writeSaladInfo() {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\data.bin")))
        {
            dos.writeUTF(this.getSaladName());
            dos.writeInt(this.getSaladCalories());
            dos.writeUTF("The Salad has the following number of ingredients: " + Integer.toString(this.ingredients.size()));
            System.out.println("File with Salad Info has been written");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void readSaladInfo() {
        try(DataInputStream dos = new DataInputStream(new FileInputStream("D:\\data.bin")))
        {
            this.name = dos.readUTF().replaceAll("[^a-zA-Z]", "");
            this.saladCalories = dos.readInt();
            int numberOfIngredients = Integer.parseInt(dos.readUTF().replaceAll("[\\D]", ""));
            System.out.printf("Salad Name: [%s] . It has the following number of calories in Salad: [%d]. It consists of [%d] ingredients",
                    this.name, this.saladCalories, numberOfIngredients);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
