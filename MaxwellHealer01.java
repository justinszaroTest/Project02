/**
 * The MaxwellHealer 1 will heal 5 health for when the healer encounters someone.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */




public class MaxwellHealer01 extends People {
    /**
     * Instantiates a Max's Healer 01 Object and establishes its properties.
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    MaxwellHealer01(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints, "Max's Healer");
        myDescription = "\tMax's Healer 01";
    }

    /**
     * will heal 5 health for when the healer encounters someone.
     * @param otherPerson Other Person who is involved in the encounter
     * @return
     */
    public int encounterStrategy(People otherPerson) {
      return -5;
    }       //The best healer

}
