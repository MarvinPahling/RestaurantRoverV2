package de.restaurantRover.main.dataClasses;


import de.restaurantRover.main.enums.Category;
import de.restaurantRover.main.enums.Place;
import de.restaurantRover.main.enums.Veggie;

public class Item {
    String name;
    float preis;
    Category kategorie;
    Veggie veggie;
    Place place;
    String description;





    public Item(String name, float preis, Category kategorie, Veggie veggie, Place place, String description) {
        setName(name);
        setPreis(preis);
        setKategorie(kategorie);
        setVeggie(veggie);
        setPlace(place);
        setDescription(description);
    }

    @Override
    public  String toString(){

        return "Name: " + getName() + "\n" +
                "Preis: " + getPreis() + "\n" +
                "Kategorie: " + getKategorie() + "\n" +
                "Veggie: " + getVeggie() + "\n" +
                "Place: " + getPlace() + "\n" +
                "Beschreibung: " + getDescription() + "\n";
    }

    // Getter and Setter
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {  this.description = description;}
        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public Category getKategorie() {
        return kategorie;
    }

    public void setKategorie(Category kategorie) {
        this.kategorie = kategorie;
    }

    public Veggie getVeggie() {
        return veggie;
    }

    public void setVeggie(Veggie veggie) {
        this.veggie = veggie;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
