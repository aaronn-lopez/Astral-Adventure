import java.util.ArrayList;
import java.util.Comparator;

public class Scoreboard {
    ArrayList<Integer> level1Scores;
    ArrayList<Integer> level2Scores;
    ArrayList<Integer> level3Scores;
    ArrayList<Integer> level4Scores;
    ArrayList<Integer> level5Scores;

    Scoreboard(){
        level1Scores = new ArrayList<Integer>();
        level2Scores = new ArrayList<Integer>();
        level3Scores = new ArrayList<Integer>();
        level4Scores = new ArrayList<Integer>();
        level5Scores = new ArrayList<Integer>();
    }

    // adding scores to the scoreboard
    public void updateScoreboard(int score, int level){
        switch(level){
            case 1:
                level1Scores.add(score);
                level1Scores.sort(Comparator.reverseOrder());
                break;
            case 2:
                level2Scores.add(score);
                level2Scores.sort(Comparator.reverseOrder());
                break;
            case 3:
                level3Scores.add(score);
                level3Scores.sort(Comparator.reverseOrder());
                break;
            case 4:
                level4Scores.add(score);
                level4Scores.sort(Comparator.reverseOrder());
                break;
            case 5:
                level5Scores.add(score);
                level5Scores.sort(Comparator.reverseOrder());
                break;
            default:
                break;
        }
    }

    String getScores(int level){
        String output = "";
        switch (level){
            case 1:
                for(int i = 0; i < Math.min(level1Scores.size(), 3); i++){
                   output += level1Scores.get(i) + "\n";
                }
                break;
            case 2:
                for(int i = 0; i < Math.min(level2Scores.size(), 3); i++){
                    output += level2Scores.get(i) + "\n";
                }
                break;
            case 3:
                for(int i = 0; i < Math.min(level3Scores.size(), 3); i++){
                    output += level3Scores.get(i) + "\n";
                }
                break;
            case 4:
                for(int i = 0; i < Math.min(level4Scores.size(), 3); i++){
                    output += level4Scores.get(i) + "\n";
                }
                break;
            case 5:
                for(int i = 0; i < Math.min(level5Scores.size(), 3); i++){
                    output += level5Scores.get(i) + "\n";
                }
                break;
            default:
                break;
        }
        return output;
    }
}
