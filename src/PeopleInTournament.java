import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class PeopleInTournament {
    List<String> peopleInTournament = new ArrayList<>();

    void savePeople(List<String> people) {
        peopleInTournament = people;
    }

    HashMap<String, HashMap<String, String>> generateTeams() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> peopleInTeam = new HashMap<>();
        Random random = new Random();
        HashMap<String, HashMap<String, String>> teams = new HashMap<>();
        int count = 0;
        int randomKey = random.nextInt(peopleInTournament.size()-1)+1;
        int team_mmr = scanner.nextInt();
        int j = 0;

        while (j != 2) {
            j++;
            for (int i = 1; i < peopleInTournament.size(); i++) {
                String[] lineContents = peopleInTournament.get(randomKey).split(" ");

                if (!peopleInTeam.containsKey(lineContents[0])) {
                    if (count < 5) {
                        if (Integer.parseInt(lineContents[1]) >= (team_mmr - 300) && Integer.parseInt(lineContents[1]) <= (team_mmr + 300)) {
                            if (lineContents[3].equals("4/5")) {
                                peopleInTeam.put(lineContents[0], lineContents[3]);
                                count++;
                            } else if (lineContents[3].equals("3")) {
                                peopleInTeam.put(lineContents[0], lineContents[3]);
                                count++;
                            } else if (lineContents[2].equals("2")) {
                                peopleInTeam.put(lineContents[0], lineContents[3]);
                                count++;
                            } else {
                                peopleInTeam.put(lineContents[0], lineContents[3]);
                                count++;
                            }
                        }
                    } else {
                        teams.put("team" + j, peopleInTeam);
                        break;
                    }
                } else break;
            }
        }
        return teams;
    }
}
