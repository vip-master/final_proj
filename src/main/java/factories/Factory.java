package factories;

import commands.*;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    private static final Map<String, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put("/login", new Login());
        commandMap.put("/admin", new Admin());
        commandMap.put("/client", new Client());
    }

    public static Command getCommand(String action) {
        return commandMap.getOrDefault(action, new Base());
    }

}
