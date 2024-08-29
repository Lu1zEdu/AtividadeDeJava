package tests;

import dao.ConnectionFactory;
import dao.GameDao;
import enums.GameGenreEnum;
import models.Game;

import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        System.out.println("Testing connection with database");
        if(ConnectionFactory.getConnection() == null){
            System.out.println("Error on establishing connection.");
        }else{
            System.out.println("Connection successfully established.");
        }

        // SEARCHING GAMES BY ID
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        GameDao dao = new GameDao();
        System.out.println("Type the ID of the game: ");
        int id = scanner.nextInt();
        try {
            game = dao.searchByID(id);
            System.out.println(game.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // ADDING GAMES
        Game wukong = new Game(29102, "Wukong",  "2024", "Game Science", "Game Science", GameGenreEnum.SOULS_LIKE);
        Game hollowKnight = new Game(98124, "Hollow Knight", "2017", "Team Cherry", "Team Cherry", GameGenreEnum.METROIDVANIA);
        Game eldenRing = new Game(72819, "Elden Ring", "2022", "FromSoftware", "Bandai Namco", GameGenreEnum.SOULS_LIKE, GameGenreEnum.ACTION);
        Game ghostTsushima = new Game (82192, "Ghost of Tsushima", "2019", "Sucker Punch", "Sony", GameGenreEnum.ACTION, GameGenreEnum.THIRD_PERSON, GameGenreEnum.ASIAN);
        Game subnautica = new Game (37216, "Subnautica", "2014", "Unknown Worlds Entertainment", "Unknown Worlds Entertainment", GameGenreEnum.SURVIVAL, GameGenreEnum.OCEAN, GameGenreEnum.FIRST_PERSON);


        GameDao SQLConnection = new GameDao();
        SQLConnection.registerGame(subnautica);



    }
}

