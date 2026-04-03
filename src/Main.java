import com.herogame.dao.PlayerDao;
import com.herogame.entity.Player;

public class Main {
    public static void main(String[] args) {

        PlayerDao dao = new PlayerDao();


        dao.addPlayer(new Player(10, 10, "Dat", 999, 5));
        dao.addPlayer(new Player(20, 20, "An", 500, 3));

        System.out.println("=== ALL PLAYERS ===");
        for (String p : dao.getAllPlayers()) {
            System.out.println(p);
        }

        System.out.println("=== TOP 10 ===");
        for (String p : dao.top10Players()) {
            System.out.println(p);
        }

        System.out.println("=== SEARCH 'Dat' ===");
        for (String p : dao.searchByName("Dat")) {
            System.out.println(p);
        }
    }
}