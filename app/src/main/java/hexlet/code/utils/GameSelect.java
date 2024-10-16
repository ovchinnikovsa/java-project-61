package hexlet.code.utils;

import hexlet.code.app.games.Calculator;
import hexlet.code.app.games.Even;
import hexlet.code.app.games.GCD;
import hexlet.code.app.games.Progression;
import hexlet.code.app.games.common.Game;
import hexlet.code.app.games.Prime;

import java.util.Objects;

public enum GameSelect {
    NULL(null, null, null),

    GREET(1, "Greet", null),
    EVEN(2, "Even", new Even()),
    CALC(3, "Calculator", new Calculator()),
    GCD(4, "GCD", new GCD()),
    PROGRESS(5, "Progression", new Progression()),
    PRIME(6, "Prime", new Prime()),

    EXIT(0, "Exit", null);

    private final Integer id;
    private final String title;
    private final Game game;

    GameSelect(Integer id, String title, Game game) {
        this.id = id;
        this.title = title;
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Game getGame() {
        return game;
    }

    public static GameSelect getFromId(Integer id) {
        for (GameSelect option : GameSelect.values()) {
            if (Objects.equals(option.getId(), id)) {
                return option;
            }
        }
        return NULL;
    }
}
