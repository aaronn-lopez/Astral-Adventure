import java.util.ArrayList;

public class Scoreboard {
    ArrayList<Integer> scores;

    // adding scores to the scoreboard
    public void updateScoreboard(int score){
        if(scores.isEmpty()){
            scores.add(score);
            return;
        }

        int i;
        for(i = 0; i < scores.size(); i++){
            if(score < scores.get(i)){
                break;
            }
        }
        scores.add(i, score);
    }

    public void displayScores(){
        // Only display top N scores
    }
}
