public class MaxwellWizard02 extends People {


    public MaxwellWizard02(String nation, String tribe, PeopleType person, int lifePoints) {
        super(nation, tribe, person, lifePoints);
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        return 0;
    }
}

