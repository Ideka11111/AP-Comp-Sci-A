import javafx.scene.image.Image;

public class Region {
    // add private instance variables for the name, capital, language, and image file.
    private String name;
    private String image;

    // add constructors
    public Region(String n, String img) {
        name = n;
        image = img;

    }
    // Write accessor/get methods for each instance variable that returns it.
    public String getname() {
        return name;
    }
    public String getimage() {
        return image;
    }
    // Write a toString() method that returns a concatenated String of 3 of the instance 
    // variables in a sentence like "The region is ..."
    public String toString() {
        String concatinated = ("The region is " + name);
        return concatinated;
    }

}