package Repository;

import models.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class GameDB {
    private List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame (String title) {
        games.removeIf(game -> game.getTitle().equals(title));
    }

    public void updateGame(String title, Game updatedGame) {
        for (int i = 0; i < games.size(); i++ ) {
            if (games.get(i).getTitle().equals(title)) {
                games.set(i, updatedGame);
                return;
            }
        }
    }

    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    public String findGame(String title) {
        String gameTitle = "None";
        for (int i = 0; i < games.size(); i++ ) {
            if (games.get(i).getTitle().equals(title)) {
                gameTitle = games.get(i).getTitle();
            }
        }
        return gameTitle;
    }







}
