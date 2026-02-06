import javafx.scene.image.Image;

public class Country {
    // add private instance variables for the name, capital, language, and image file.
    private String name;
    private String capital; 
    private String language; 
    private String image;
    // add constructors
    public Country() {


    }
    public Country(String n, String c, String l, String img) {
        name = n;
        capital = c;
        language = l;
        image = img;
    }
    // Write accessor/get methods for each instance variable that returns it.
    public String getname() {
        return name;
    }
    public String getcapital() {
        return capital;
    }
    public String getlanguage() {
        return language;
    }
    public String getimage() {
        return image;
    }
    // Write a toString() method that returns a concatenated String of 3 of the instance 
    // variables in a sentence like "..'s capital is .. and its primary language is ..."
    public String toString() {
        String concatinated = (name + "'s capital is " + capital + " and its primary language is " + language);
        return concatinated;
    }


}