
public class TanishqCurseArtifact extends People {
    public static final int MAX_DAMAGE = 123456789;
    private final Dice dice;

    public TanishqCurseArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.curse, lifePoints);

        myDescription = "\tCursed Artifact";
        dice = new Dice();
    }

    /**
     * Implements Encounter Strategy for the Cursed Artifact.
     * @param other the friend or enemy in the encounter.
     * @return positive for damage, negative for healing.
     */
    @Override
    public int encounterStrategy(People other) {
        boolean isSameNation = this.getNation().equals(other.getNation());
        return isSameNation ?
                sameNationStrategy(other) :
                differentNationStrategy(other);
    }

    private int sameNationStrategy(People friend) {
        return 0;
    }

    private int differentNationStrategy(People enemy) {
        float roll = dice.roll();

        return switch (enemy.getType()) {
            case wizard -> roll < 0.05 ? MAX_DAMAGE : 0;
            case warrior -> roll < 0.15 ? MAX_DAMAGE : 0;
            case cleric -> roll < 0.01 ? MAX_DAMAGE : 0;
            default -> 0;
        };
    }
}
