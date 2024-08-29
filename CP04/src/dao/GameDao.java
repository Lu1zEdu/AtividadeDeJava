package dao;
import enums.GameGenreEnum;
import models.Game;
import tests.Tests;

import java.sql.*;

// Class responsible for manipulating the data in the DB, implementing CRUD operations
public class GameDao {
    private Connection connection;
    public void registerGame(Game game) throws SQLException {
        connection = ConnectionFactory.getConnection();
        PreparedStatement SQLCommand = null;
        String sql = "select id from GAME where id=?";
        SQLCommand = connection.prepareStatement(sql);
        SQLCommand.setInt(1, game.getId());
        ResultSet result = SQLCommand.executeQuery();
        if (!result.next()) {
            try {
                sql = "insert into GAME(ID, TITLE, DEVELOPER, PUBLISHER, RELEASE_YEAR, GAME_GENRE, GAME_GENRE2, GAME_GENRE3)" +
                        " values (?,?,?,?,?,?,?,?)";

                SQLCommand = connection.prepareStatement(sql);
                SQLCommand.setInt(1, game.getId());
                SQLCommand.setString(2, game.getTitle());
                SQLCommand.setString(3, game.getDeveloper());
                SQLCommand.setString(4, game.getPublisher());
                SQLCommand.setString(5, game.getRelease_year());
                SQLCommand.setString(6, game.getGameGenre().toString());
                SQLCommand.setString(7, game.getGameGenre2().toString());
                SQLCommand.setString(8, game.getGameGenre3().toString());
                SQLCommand.executeUpdate();
                SQLCommand.close();
                connection.close();

            }catch (SQLException error) {
                error.printStackTrace();
            }
        } else {
            System.out.println("Game already in database.");
        }




        }


    public Game searchByID(int id) throws SQLException {
        connection = ConnectionFactory.getConnection();
        PreparedStatement SQLCommand = null;

        Game game = new Game();
        try  {
            String sql = "select * from game where id = ?";
            SQLCommand = connection.prepareStatement(sql);
            SQLCommand.setInt(1, id);
            ResultSet result = SQLCommand.executeQuery();
            if (result.next()) {
                game.setId(result.getInt(1));
                game.setTitle(result.getString(2));
                game.setDeveloper(result.getString(3));
                game.setPublisher(result.getString(4));
                game.setRelease_year(result.getString(5));
                game.setGameGenre(GameGenreEnum.valueOf(result.getString(6)));
                game.setGameGenre2(GameGenreEnum.valueOf(result.getString(7)));
                game.setGameGenre3(GameGenreEnum.valueOf(result.getString(8)));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            SQLCommand.close();
            connection.close();
        }

        return game;
    }

}
