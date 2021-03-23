public class MaxwellWarrior02 extends People {


    public MaxwellWarrior02(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        String myDescription = "\tMax's Warrior";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

