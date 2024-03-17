import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Scoreboard {
    ArrayList<Integer>[] levelScores;

    Scoreboard() {
        // load scoreboard scores on creation (in setup)
        levelScores = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            levelScores[i] = new ArrayList<>();
            loadScoresFromFile(i + 1);
        }
    }

    public void updateScoreboard(int score, int level) {
        if (level >= 1 && level <= 5) {
            levelScores[level - 1].add(score);
            levelScores[level - 1].sort(Comparator.reverseOrder());
            saveScoresToFile(level);
        }
    }

    String getScores(int level) {
        StringBuilder output = new StringBuilder();
        if (level >= 1 && level <= 5) {
            for (int i = 0; i < Math.min(levelScores[level - 1].size(), 3); i++) {
                output.append(levelScores[level - 1].get(i)).append("\n");
            }
        }
        return output.toString();
    }

    // save the scores whenever a new score is added to the 'scores' folder
    private void saveScoresToFile(int level) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/scores/level" + level + "_scores.txt"));
            for (Integer score : levelScores[level - 1]) {
                writer.write(score + "\n");
            }
            writer.close();
        } catch (IOException e) {

        }
    }

    // load scores for a specific level from a text file
    private void loadScoresFromFile(int level) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/scores/level" + level + "_scores.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                levelScores[level - 1].add(Integer.parseInt(line));
            }
            reader.close();
        } catch (IOException e) {

        }
    }
}