package hexlet.code;

public enum EntranceOptions {
    NULL(null, null),
    GREET(1, "Greet"),
    EXIT(0, "Exit");

    private final Integer id;
    private final String title;

    EntranceOptions(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static EntranceOptions getFromId(Integer id) {
        for (EntranceOptions option : EntranceOptions.values()) {
            if (option.getId().equals(id)) {
                return option;
            }
        }
        return NULL;
    }


}
