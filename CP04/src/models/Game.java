package models;


import enums.GameGenreEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;



public class Game {
    private int id;
    private String title;
    private String developer;
    private String publisher;
    private String release_year;
    private GameGenreEnum gameGenre;
    private GameGenreEnum gameGenre2 = GameGenreEnum.NA;
    private GameGenreEnum gameGenre3 = GameGenreEnum.NA;
    private List<GameGenreEnum> genresList = new ArrayList<>() {
    };
    private static List<Game> games = new ArrayList<>();


    public Game(){

    }


    public Game(int id, String title, String release_year, String developer, String publisher, GameGenreEnum gameGenre,
                GameGenreEnum gameGenre2, GameGenreEnum  gameGenre3) {

        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.developer = developer;
        this.publisher = publisher;
        this.gameGenre = gameGenre;
        this.gameGenre2 = gameGenre2;
        this.gameGenre3 = gameGenre3;
        this.genresList.addAll(Arrays.asList(this.gameGenre, this.gameGenre2, this.gameGenre3));
    }
    public Game(int id, String title, String release_year, String developer, String publisher, GameGenreEnum gameGenre,
                GameGenreEnum gameGenre2) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.developer = developer;
        this.publisher = publisher;
        this.gameGenre = gameGenre;
        this.gameGenre2 = gameGenre2;
        this.genresList.addAll(Arrays.asList(this.gameGenre, this.gameGenre2));
        System.out.println(genresList);

    }
    public Game(int id, String title, String release_year, String developer, String publisher, GameGenreEnum gameGenre) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.developer = developer;
        this.publisher = publisher;
        this.gameGenre = gameGenre;
        this.genresList.add(this.gameGenre);
        System.out.println(genresList);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public GameGenreEnum getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(GameGenreEnum gameGenre) {
        this.gameGenre = gameGenre;
    }

    public GameGenreEnum getGameGenre2() {
        return gameGenre2;
    }

    public void setGameGenre2(GameGenreEnum gameGenre2) {
        this.gameGenre2 = gameGenre2;
    }

    public GameGenreEnum getGameGenre3() {
        return gameGenre3;
    }

    public void setGameGenre3(GameGenreEnum gameGenre3) {
        this.gameGenre3 = gameGenre3;
    }

    public static List<Game> getGames() {
        return games;
    }

    private static void setGames(List<Game> games) {
        Game.games = games;
    }

    public List<GameGenreEnum> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<GameGenreEnum> genresList) {
        this.genresList = genresList;
    }

    @Override
    public String toString() {
        return "Game : {" +
                "\n Id="+ this.id +
                "\n Title = " + this.title + '\'' +
                "\n , Release Year = " + this.release_year +
                "\n , Developer = " + this.developer+
                "\n , Publisher = " + this.publisher+
                "\n , Genre = " + this.gameGenre +
                "\n , Genre 2 = " + this.gameGenre2 +
                "\n , Genre 3 = " + this.gameGenre3 +
                "}\n";
    }

    public static void addGame(Game game) {
        games.add(game);
    }

    public static void writeGamesToCSV(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Game game : games) {
                writer.append(String.valueOf(game.getId())).append(",");
                writer.append(game.getTitle()).append(",");
                writer.append(game.getDeveloper()).append(",");
                writer.append(game.getPublisher()).append(",");
                writer.append(game.getRelease_year()).append(",");
                writer.append(game.getGameGenre().toString()).append(",");
                writer.append(game.getGameGenre2().toString()).append(",");
                writer.append(game.getGameGenre3().toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void readGamesFromCSV(String fileName) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Game game = new Game(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        GameGenreEnum.valueOf(values[5]),
                        GameGenreEnum.valueOf(values[6]),
                        GameGenreEnum.valueOf(values[7])
                );
                games.add(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//
}
