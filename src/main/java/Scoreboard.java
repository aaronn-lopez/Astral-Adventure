import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * <p>A simple scoreboard for storing information about top scores on each level.</p>
 */
public class Scoreboard {
    ArrayList<Integer>[] levelScores;

    /**
     * <p>Create a new scoreboard.</p>
     */
    Scoreboard() {
        // load scoreboard scores on creation (in setup)
        levelScores = new ArrayList[6];
        for (int i = 0; i < 6; i++) {
            levelScores[i] = new ArrayList<>();
            loadScoresFromFile(i + 1);
        }
    }

    /**
     * <p>Update the scoreboard of the appropriate level with the new score.</p>
     * @param score The score to be added
     * @param level The level the score was achieved in
     */
    public void updateScoreboard(int score, int level) {
        if (level >= 1 && level <= 6 && score > 0) {
            levelScores[level - 1].add(score);
            levelScores[level - 1].sort(Comparator.reverseOrder());
            saveScoresToFile(level);
        }
    }

    String getScores(int level) {
        // get and format the top three scores
        StringBuilder output = new StringBuilder();
        if (level >= 1 && level <= 6) {
            for (int i = 0; i < Math.min(levelScores[level - 1].size(), 3); i++) {
                output.append(levelScores[level - 1].get(i)).append("\n");
            }
        }
        return output.toString();
    }

    // save the scores whenever a new score is added to the 'scores' folder
    private void saveScoresToFile(int level) {
        try {
            BufferedWriter writer;
            if(level == 6) {
                writer = new BufferedWriter(new FileWriter("src/main/scores/tester_scores.txt"));
            }
            else {
                writer = new BufferedWriter(new FileWriter("src/main/scores/level" + level + "_scores.txt"));
            }
            // add the score to the text file
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
            BufferedReader reader;
            if(level == 6) {
                reader = new BufferedReader(new FileReader("src/main/scores/tester_scores.txt"));
            }
            else {
                reader = new BufferedReader(new FileReader("src/main/scores/level" + level + "_scores.txt"));
            }
            String line;
            // read the score from the text file
            while ((line = reader.readLine()) != null) {
                levelScores[level - 1].add(Integer.parseInt(line));
            }
            reader.close();
        } catch (IOException e) {

        }
    }
    public void clearTestFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/scores/tester_scores.txt"));
            writer.write("");
            writer.close();
        } catch (IOException e) {

        }

    }
}