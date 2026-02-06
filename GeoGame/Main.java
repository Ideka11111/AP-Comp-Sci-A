import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {
    // GUI elements
    private JFrame jFrame = new JFrame("Countries");
    private ImageIcon img;
    private JLabel imageLabel;
    private JLabel outputLabel;
    
    // array of 10 Country objects
    private Country[] countryArray = new Country[10];
    // index of current shown country
    private int cindex = 0;
    
    // array of Region objects
    private Region[] regionsArray = new Region[8];
    private int rindex = 0;
    
    private static String type;

    public static void main(String[] args) {
        // Create the GUI
        Main gui = new Main();
        gui.loadCountries();
        gui.loadRegions();
        gui.showCountry();
        type = "country";
    }

    public void loadCountries() {
        // Open the data file - do not change
        File file = new File("countries-data.csv");
        Scanner scan = null;
        try {
          scan = new Scanner(file);
        } catch(FileNotFoundException e) { 
            System.out.println("File not found");     
        }
    
        // Write a for loop that goes through the countryArray.
        for(int i=0; i<=4; i++) {
        // Do the following inside the loop
        String input = scan.nextLine();
        String[] data = input.split(",");
        System.out.println("Read in " + data[0]);
        // inside the loop, create a new Country using your constructor with 3 arguments and pass in data[0], data[1], data[2], data[3] as arguments.
        // inside the loop, set countryArray[i] to the created Country object
        countryArray[cindex] = new Country(data[0],data[1],data[2],data[3]);
        }
    }



    public void loadRegions(){
        // use mustache notation to create an array for the names of the regions
        String[] regarr = {"africa", "americas", "asia-pacific", "europe", "middle-east", "north-america", "south-america"};
        // use mustache notation to create an array for the image names
        String[] imgarr = {"africa.jpeg","americas.png","asia-pacific.png","central-america.png","china,jpeg","cow.jpeg","dog.jpeg","egypt.jpeg","europe.png","france.jpeg","germany.jpeg","india.jpeg","japan.jpeg","kenya.jpeg","kitten.jpeg","mexico.jpeg","middle-east.png","north-america.png","pig.jpeg","reindeer.jpeg","south-america.png","uk.jpeg","usa.jpeg","world.jpeg"};
        // Write a loop to create a region object for each region and store it in the array
        for(int i=0; i <= 7; i++) {
            regionsArray[i] = new Region(regarr[i], imgarr[i]);
        }
    
    }

    /* showCountry() will show the image associated with the current country. 
    * It should get the country at the index from the countryArray. It should use 
    * its get method to get its image file name and use the code below to put 
    * the image in the GUI.
    */
    public void showCountry() {
        // Get the country at index from countryArray
        Country countryObj = countryArray[cindex];
        // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
        String imagefile = countryObj.getimage();
        // Use the following code to create an new Image Icon and put it into the GUI
        img = new ImageIcon("C:\Users\Tyler\OneDrive\Desktop\Comp Sci A\placeholder\src\GeoGame\images\\" + imagefile);
        imageLabel.setIcon(img);
    }


    /* showRegion() will show the image associated with the current region.
    * It should get the region at the index from the regionsArray.  It should
    * use its get method to get its image file name and use the code bellow to put
    * the image in the GUI
    */
    public void showRegion() {
        // Get the region at index from regionsArray
        Region regionObj = regionsArray[rindex];
        // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
        String imagefile = regionObj.getimage();
        img = new ImageIcon("C:\Users\Tyler\OneDrive\Desktop\Comp Sci A\placeholder\src\GeoGame\images\\" + imagefile);
        // create a label to display image
        imageLabel.setIcon(img);
    }

    /* reviewButton should get the country/region at index from the corresponding array, 
    * call its toString() method and save the result, print it out with 
    * System.out.println and as an argument to outputLabel.setText( text to print out ); 
    */
    public void reviewButtonClick() {
        // get the country and region objects from their corresponding array
        Region regionObjforReviewBtn = regionsArray[rindex];
        Country countryObjforReviewBtn = countryArray[cindex];
        // call toString for each and save the value
        String countrytoString = countryObjforReviewBtn.toString();
        String regiontoString = regionObjforReviewBtn.toString();
        //print 
        System.out.println(countrytoString);
        System.out.println(regiontoString);
        //save to outputLabel
        outputLabel.setText(countrytoString);
        outputLabel.setText(regiontoString);

    }

    /* quizButton should clear the outputLabel (outputLabel.setText to empty string),
    * get the country or region at index from their array, print out a question about it like 
    * What country is this? and/or What's this country's capital?. and/or What region is this? 
    * Get the user's answer using scan.nextLine() and check if it is equal to the country's data 
    * using its get  methods and print out correct or incorrect.
    */
    public void quizButtonClick() {
        Scanner scan = new Scanner(System.in); 
        // clear outputLabel and  establish the specific country or region obj get grabing it from the respective array
        outputLabel.setText("");
        Region regionObjforQuiz = regionsArray[rindex];
        Country countryObjforQuiz = countryArray[cindex];
        // array with quewstions and code to randomize the question
        String[] questions = {
            "What country is this?",
            "What's this country's capital?",
            "What region is this in?",
            "what is the country's language?"
        };
        int num = (int) (Math.random()*4);
        String question = (questions[num]);
        System.out.print(question);
        //scan for user's answer to question and cross reference 
        String ans = scan.nextLine();
        if (question.indexOf(" country ") >= 0) {
            if (countryObjforQuiz.getname().equalsIgnoreCase(ans)) {
                System.out.println("Correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
        else if (question.indexOf("capital") >= 0) {
            if (countryObjforQuiz.getcapital().equalsIgnoreCase(ans)) {
                System.out.println("Correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
        else if (question.indexOf("region") >= 0) {
            if (regionObjforQuiz.getname().equalsIgnoreCase(ans)) {
                System.out.println("Correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
        else if (question.indexOf("language") >= 0) {
            if (countryObjforQuiz.getlanguage().equalsIgnoreCase(ans)) {
                System.out.println("Correct");
            }
            else {
                System.out.println("Incorrect");
            }
        }
        else {
            
        }

    }


    public void newButtonClick() {
        //  incriment the index values make sure they do not go out of range
        // make the thing go to the next object
        cindex++;
        rindex++;
        // make sure the indexes don't go over 
        if (cindex == 10) {
            cindex = 0;
        }
        if (rindex == 8) {
            rindex = 0;
        }

    }

    public Main() {
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton regionButton = new JButton("Region");
        JButton countryButton = new JButton("Country");
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(countryButton);
        jFrame.add(regionButton);
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
    
        // create a new image icon
        img = new ImageIcon("C:\Users\Tyler\OneDrive\Desktop\Comp Sci A\placeholder\src\GeoGame\images\world.jpeg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);
        
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) 
        {
            reviewButtonClick();
        }
        });
        
        quizButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) 
        {
            quizButtonClick();
        }
        });
    
        newButton.addActionListener(new ActionListener()  {
        public void actionPerformed(ActionEvent e) 
        {
            newButtonClick();
        }
        });
        
        regionButton.addActionListener(new ActionListener()  {
        public void actionPerformed(ActionEvent e) 
        {
            //switch to regions
        
        }
        });
        
        countryButton.addActionListener(new ActionListener()  {
        public void actionPerformed(ActionEvent e) 
        {
            //switch to countries
        
        }
        });
        
    }
    
    
}