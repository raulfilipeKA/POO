package testeExIntercalar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> team; private String name;
    public Team(String name) {
        this.name = name;
        team = new ArrayList<>();
    }
    public void addPlayer(Player p) {
        team.add(p);
    }
    public int size() {
        return team.size();
    }
    public Player getPlayer(int number) {
        for (Player p : team) {
            if (p.getNumber() == number) {
                return p;
            }
        }
        return null;
    }

    public void exportPlayers(File file) throws IOException {
        ObjExplorer<Player> exporter = new ObjExplorer(file);
        exporter.export(team, p -> p.getNumber() + ',' + p.getName()); //o p é do tipo
    }
}
