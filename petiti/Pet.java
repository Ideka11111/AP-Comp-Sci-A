package petiti;
public class Pet {
    private String name;
    private int age;
    private int energy;
    private int hungry;
    private int happiness;
    private int weight;


    public Pet(String n, int a, int h, int e, int H, int w) {
        name = n;
        age = a;
        hungry = h;
        energy = e;
        happiness = H;
        weight = w; 
    }


    public int feed() {
        energy += 1;
        hungry += 1;
        weight += 1;


    }

    public int play(){
        happiness += 1;
        energy -= 1;
        hungry -= 1;
        if (happiness >= 10){
            happiness = 10;
        }

    
    }
}