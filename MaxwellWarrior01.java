public class MaxwellWarrior01 extends People {


    public MaxwellWarrior01(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, person, lifePoints);
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

