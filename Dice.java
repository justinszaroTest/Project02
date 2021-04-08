import java.util.Random;

/**
 * Class represents a dice.
 */
public class Dice {

    Random generator;
    Random faceGenerator;

    /**
     * Creates a dice.
     * @param date the seed.
     */
    public Dice(long date) {
        generator = new Random(date);
        faceGenerator = new Random();
    }

    /**
     * Creates a dice.
     */
    public Dice() {
        generator = new Random();
        faceGenerator = new Random();
    }

    /**
     * Rolls a number between 0 and 1.
     * @return a random number between 0 and 1.
     */
    public float roll()  {
        return generator.nextFloat();
    }

    /**
     * Rolls a dice 1-faces.
     * @param faces the number of faces on the die.
     * @return a number between 1-faces.
     */
    public int rollFaces(int faces) {
       int number = faceGenerator.nextInt(faces + 1);
       if (number == 0)
           return 1;
       return number;
    }
}
