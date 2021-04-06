import java.util.Random;

public class Dice {

    Random generator;
    Random faceGenerator;

    public Dice(long date) {
        generator = new Random(date);
        faceGenerator = new Random();
    }

    public Dice() {
        faceGenerator = new Random();
    }

    public float roll()  {
        return generator.nextFloat();
    }

    public int rollFaces(int faces) {
       int number = faceGenerator.nextInt(faces + 1);
       if (number == 0)
           return 1;
       return number;
    }
}
