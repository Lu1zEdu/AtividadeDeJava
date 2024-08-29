package tests;

import enums.GameGenreEnum;
import models.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Tests {
    private static void populateDefaultGames() {
        games.add(new Game(1, "The Witcher 3: Wild Hunt", "2015", "CD Projekt", "CD Projekt", GameGenreEnum.RPG, GameGenreEnum.ACTION, GameGenreEnum.OPEN_WORD));
        games.add(new Game(2, "Hollow Knight", "2017", "Team Cherry", "Team Cherry", GameGenreEnum.METROIDVANIA, GameGenreEnum.INDIE));
        games.add(new Game(3, "Celeste", "2018", "Matt Makes Games", "Matt Makes Games", GameGenreEnum.PLATFORMER, GameGenreEnum.INDIE));
        games.add(new Game(4, "Final Fantasy VII", "1997", "Square", "Square", GameGenreEnum.JRPG, GameGenreEnum.TURN_BASED));
        games.add(new Game(5, "Doki Doki Literature Club", "2017", "Team Salvato", "Team Salvato", GameGenreEnum.VISUAL_NOVEL));
        games.add(new Game(6, "League of Legends", "2009", "Riot Games", "Riot Games", GameGenreEnum.MULTIPLAYER, GameGenreEnum.PVP, GameGenreEnum.MOBA));
        games.add(new Game(7, "Call of Duty: Modern Warfare", "2019", "Infinity Ward", "Activision", GameGenreEnum.SHOOTER, GameGenreEnum.FIRST_PERSON, GameGenreEnum.MULTIPLAYER));
        games.add(new Game(8, "Dark Souls", "2011", "FromSoftware", "Namco Bandai", GameGenreEnum.SOULS_LIKE, GameGenreEnum.ACTION, GameGenreEnum.DIFFICULT));
        games.add(new Game(9, "Journey", "2012", "Thatgamecompany", "Sony Computer Entertainment", GameGenreEnum.INDIE, GameGenreEnum.CHILL));
        games.add(new Game(10, "Super Mario Odyssey", "2017", "Nintendo", "Nintendo", GameGenreEnum.PLATFORMER, GameGenreEnum.THREE_D, GameGenreEnum.ACTION));
        games.add(new Game(11, "StarCraft", "1998", "Blizzard Entertainment", "Blizzard Entertainment", GameGenreEnum.STRATEGY, GameGenreEnum.MULTIPLAYER));
        games.add(new Game(12, "Mortal Kombat", "1992", "Midway", "Warner Bros.", GameGenreEnum.FIGHTER, GameGenreEnum.MULTIPLAYER));
        games.add(new Game(13, "Persona 5", "2016", "Atlus", "Atlus", GameGenreEnum.JRPG, GameGenreEnum.TURN_BASED));
        games.add(new Game(14, "Metal Gear Solid", "1998", "Konami", "Konami", GameGenreEnum.STEALTH, GameGenreEnum.ACTION, GameGenreEnum.FIRST_PERSON));
        games.add(new Game(15, "Sakura Spirit", "2014", "Winged Cloud", "Sekai Project", GameGenreEnum.HENTAI, GameGenreEnum.VISUAL_NOVEL, GameGenreEnum.ASIAN));
        games.add(new Game(16, "HuniePop", "2015", "HuniePot", "HuniePot", GameGenreEnum.HENTAI));
        games.add(new Game(17, "Nekopara Vol. 1", "2014", "Neko Works", "Sekai Project", GameGenreEnum.HENTAI, GameGenreEnum.VISUAL_NOVEL, GameGenreEnum.ASIAN));
        games.add(new Game(18, "Monster Girl Quest", "2011", "Torotoro Resistance", "Unknown", GameGenreEnum.HENTAI, GameGenreEnum.RPG, GameGenreEnum.ASIAN));
        games.add(new Game(19, "Baldur's Gate 3", "2023", "Larian Studios", "Larian Studios", GameGenreEnum.RPG, GameGenreEnum.TURN_BASED));
        games.add(new Game(20, "Ghostrunner", "2020", "One More Level", "505 Games", GameGenreEnum.ACTION, GameGenreEnum.FIRST_PERSON));
        games.add(new Game(21, "Outer Wilds", "2019", "Mobius Digital", "Annapurna Interactive", GameGenreEnum.ADVENTURE, GameGenreEnum.EXPLORATION));
        games.add(new Game(22, "Ghost of Tsushima", "2020", "Sucker Punch", "Sony Interactive", GameGenreEnum.ACTION, GameGenreEnum.EXPLORATION, GameGenreEnum.ASIAN));
    }

    private static List<Game> games = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        populateDefaultGames();
        while (true) {
            System.out.println("Menu" +
                    "\n0- Exit" +
                    "\n1- Register" +
                    "\n2- List" +
                    "\n3- Consult by Code" +
                    "\n4- Consult by Criteria" +
                    "\n5- Update" +
                    "\n6- Delete" +
                    "\nEnter the desired operation: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Exiting");
                    return;
                case 1:
                    registerGame();
                    break;
                case 2:
                    listGames();
                    break;
                case 3:
                    consultByCode();
                    break;
                case 4:
                    consultByCriteria();
                    break;
                case 5:
                    updateGame();
                    break;
                case 6:
                    deleteGame();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void registerGame() {
        System.out.println("Register New Game:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Release Year: ");
        String releaseYear = scanner.nextLine();
        System.out.print("Developer: ");
        String developer = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();

        // Get the genre from user input
        System.out.print("Genre 1 (e.g., RPG, ACTION): ");
        String genreName1 = scanner.nextLine().toUpperCase();
        GameGenreEnum genre1 = GameGenreEnum.valueOf(genreName1);

        System.out.print("Genre 2 (optional, leave blank to skip): ");
        String genreName2 = scanner.nextLine().toUpperCase();
        GameGenreEnum genre2 = genreName2.isEmpty() ? GameGenreEnum.NA : GameGenreEnum.valueOf(genreName2);

        System.out.print("Genre 3 (optional, leave blank to skip): ");
        String genreName3 = scanner.nextLine().toUpperCase();
        GameGenreEnum genre3 = genreName3.isEmpty() ? GameGenreEnum.NA : GameGenreEnum.valueOf(genreName3);

        Game newGame = new Game(id, title, releaseYear, developer, publisher, genre1, genre2, genre3);
        games.add(newGame);
        System.out.println("Game successfully registered!");
    }


    private static void listGames() {
        System.out.println("List of Games:");
        if (games.isEmpty()) {
            System.out.println("No games registered.");
        } else {
            for (Game game : games) {
                System.out.println(game);
            }
        }
    }

    private static void consultByCode() {
        System.out.print("Enter the game ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Game game = games.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
        if (game != null) {
            System.out.println("Game found:");
            System.out.println(game);
        } else {
            System.out.println("Game not found.");
        }
    }

    private static void consultByCriteria() {
        System.out.println("Consult by Criteria:" +
                "\n1- Genre" +
                "\n2- Release Year" +
                "\n3- Title" +
                "\n4- Developer" +
                "\n5- Publisher" +
                "\nEnter the desired criterion: ");
        int criterion = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (criterion) {
            case 1:
                System.out.print("Genre: ");
                String genreName = scanner.nextLine().toUpperCase();
                GameGenreEnum genre = genreName.isEmpty() ? GameGenreEnum.NA : GameGenreEnum.valueOf(genreName);
                List<Game> byGenre = games.stream().filter(g -> g.getGameGenre() == genre || g.getGameGenre2() == genre || g.getGameGenre3() == genre).collect(Collectors.toList());
                printGames(byGenre);
                break;
            case 2:
                System.out.print("Enter the release year: ");
                String releaseYear = scanner.nextLine();
                List<Game> byYear = games.stream().filter(g -> g.getRelease_year().equalsIgnoreCase(releaseYear)).collect(Collectors.toList());
                printGames(byYear);
                break;
            case 3:
                System.out.print("Enter the title: ");
                String title = scanner.nextLine();
                List<Game> byTitle = games.stream().filter(g -> g.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
                printGames(byTitle);
                break;
            case 4:
                System.out.print("Enter the developer: ");
                String developer = scanner.nextLine();
                List<Game> byDeveloper = games.stream().filter(g -> g.getDeveloper().equalsIgnoreCase(developer)).collect(Collectors.toList());
                printGames(byDeveloper);
                break;
            case 5:
                System.out.print("Enter the publisher: ");
                String publisher = scanner.nextLine();
                List<Game> byPublisher = games.stream().filter(g -> g.getPublisher().equalsIgnoreCase(publisher)).collect(Collectors.toList());
                printGames(byPublisher);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void printGames(List<Game> gamesList) {
        if (gamesList.isEmpty()) {
            System.out.println("No games found.");
        } else {
            for (Game game : gamesList) {
                System.out.println(game);
            }
        }
    }

    private static void updateGame() {
        System.out.print("Enter the ID of the game to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Game game = games.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
        if (game != null) {
            System.out.print("New title (leave blank to keep current): ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) game.setTitle(title);

            System.out.print("New release year (leave blank to keep current): ");
            String releaseYear = scanner.nextLine();
            if (!releaseYear.isEmpty()) game.setRelease_year(releaseYear);

            System.out.print("New developer (leave blank to keep current): ");
            String developer = scanner.nextLine();
            if (!developer.isEmpty()) game.setDeveloper(developer);

            System.out.print("New publisher (leave blank to keep current): ");
            String publisher = scanner.nextLine();
            if (!publisher.isEmpty()) game.setPublisher(publisher);

            System.out.print("Genre (leave blank to keep current): ");
            String genreName = scanner.nextLine().toUpperCase();
            if (!genreName.isEmpty()) {
                GameGenreEnum genre = GameGenreEnum.valueOf(genreName);
                game.setGameGenre(genre);
            }

            System.out.print("Genre 2 (leave blank to keep current): ");
            String genreName2 = scanner.nextLine().toUpperCase();
            if (!genreName2.isEmpty()) {
                GameGenreEnum genre2 = GameGenreEnum.valueOf(genreName2);
                game.setGameGenre2(genre2);
            }

            System.out.print("Genre 3 (leave blank to keep current): ");
            String genreName3 = scanner.nextLine().toUpperCase();
            if (!genreName3.isEmpty()) {
                GameGenreEnum genre3 = GameGenreEnum.valueOf(genreName3);
                game.setGameGenre3(genre3);
            }

            System.out.println("Game successfully updated!");
        } else {
            System.out.println("Game not found.");
        }
    }

    private static void deleteGame() {
        System.out.print("Enter the ID of the game to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Game game = games.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
        if (game != null) {
            games.remove(game);
            System.out.println("Game successfully deleted!");
        } else {
            System.out.println("Game not found.");
        }
    }
}
