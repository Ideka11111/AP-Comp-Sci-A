package petiti;

public class Game {
    private int Happiness;
    private int WeightLoss;
    private String Description; 

    public Game(int happiness, int weightLoss, String description) {
        Happiness = happiness;
        WeightLoss = weightLoss;
        Description = description;
    }
    
    public boolean IsWInner() {
        int num = (int) (Math.random()*10);
        //establish rand and choose a number
        if (num == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {

        return Description;
    }

    public int getHappiness() {

        return Happiness;
    }

    public int getWeightLoss() {

        return WeightLoss;
    }
}
