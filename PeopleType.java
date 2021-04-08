
public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    cleric ("Healer"),
    angel ("Angel");



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
