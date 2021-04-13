public class MaxwellHealer01 extends People {
    MaxwellHealer01(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tMax's Healer 01";
    }

    public int encounterStrategy(People otherPerson) {
      return -5;
    }       //The best healer

}
