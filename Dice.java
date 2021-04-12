import java.util.Random;

/**
 * The Dice object generates a random numbers based on the number of faces or a long.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class Dice {

    Random generator;
    Random faceGenerator;

    /**
     * Creates a dice object.
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
     * Rolls a dice with int faces.
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
