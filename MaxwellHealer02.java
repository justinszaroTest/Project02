public class MaxwellHealer02 extends People {
    MaxwellHealer02(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        String myDescription = "\tMax's Healer";
    }

    public int encounterStrategy(People otherPerson) {
        return -5;
    }

}
