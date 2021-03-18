
public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    cleric ("Healer");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }

    public String getDescription()
    {
        return description;
    }
}
