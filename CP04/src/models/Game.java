package models;

import enums.GameGenreEnum;

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

    }
    public Game(int id, String title, String release_year, String developer, String publisher, GameGenreEnum gameGenre) {
        this.id = id;
        this.title = title;
        this.release_year = release_year;
        this.developer = developer;
        this.publisher = publisher;
        this.gameGenre = gameGenre;
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
                '}';
    }
//
}