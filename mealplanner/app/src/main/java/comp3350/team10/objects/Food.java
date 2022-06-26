package comp3350.team10.objects;

import java.io.IOException;

public class Food extends Edible {
    private boolean vegan;
    private boolean vegetarian;
    private boolean spicy;
    private boolean breakfast;
    private boolean lunch;
    private boolean supper;
    private boolean alcoholic;
    
    public Food() {
        super();

        this.vegan = false;
        this.vegetarian = false;
        this.spicy = false;
        this.breakfast = false;
        this.lunch = false;
        this.supper = false;
        this.alcoholic = false;
    }


    public void init(ListItem.FragmentType view) throws IOException {   //used for add card
        super.init(view);
    }

    public void init(int id, String name, String desc, int qty, Unit unit, imageView photo, ListItem.FragmentType view,
            boolean isVegan, boolean isVegetarian, boolean isSpicy, boolean isBreakfastFood, boolean isLunchFood,
            boolean isSupperFood, boolean isAlcoholic) throws IOException {
        super.init(id, name, desc, qty, unit, photo, view);
        this.setVegan(isVegan);
        this.setVegetarian(isVegetarian);
        this.setSpicy(isSpicy);
        this.setBreakfast(isBreakfastFood);
        this.setLunch(isLunchFood);
        this.setSupper(isSupperFood);
        this.setAlcoholic(isAlcoholic);
    }

    private void setVegan(boolean isVegan) {
        this.vegan = isVegan;
    }

    private void setVegetarian(boolean isVegetarian) {
        this.vegetarian = isVegetarian;
    }

    private void setSpicy(boolean isSpicy) {
        this.spicy = isSpicy;
    }

    private void setBreakfast(boolean isBreakfastFood) {
        this.breakfast = isBreakfastFood;
    }

    private void setLunch(boolean isLunchFood) {
        this.lunch = isLunchFood;
    }

    private void setSupper(boolean isSupperFood) {
        this.supper = isSupperFood;
    }

    private void setAlcoholic(boolean isAlcoholic) {
        this.alcoholic = isAlcoholic;
    }

    public boolean isVegan() {
        return this.vegan;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public boolean isSpicy() {
        return this.spicy;
    }

    public boolean isBreakfast() {
        return this.breakfast;
    }

    public boolean isLunch() {
        return this.lunch;
    }

    public boolean isSupper() {
        return this.supper;
    }

    public boolean isAlcoholic() {
        return this.alcoholic;
    }
}