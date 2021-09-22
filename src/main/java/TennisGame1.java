public class TennisGame1 implements TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1Name;
    private String player2Name;


    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            scorePlayer1 += 1;
        if (playerName.equals(player2Name))
            scorePlayer2 += 1;
    }

    public String selectScoresWhenAreEqual(int scorePlayer){
        String score = "";
        switch (scorePlayer) {
            case 0:
                score = "Love-All";
                return score;
            case 1:
                score = "Fifteen-All";
                return score;
            case 2:
                score = "Thirty-All";
                return score;
            default:
                score = "Deuce";
                return score;
        }
    }

    public String selectScoreByAdvantage(int minusResult){
        String score = "";
        switch (minusResult){
            case 1:
                score = "Advantage player1";
                return score;
            case -1:
                score = "Advantage player2";
                return score;
            default:
                return selectPlayerWinner(minusResult);
        }
    }

    public String selectPlayerWinner(int minusResult) {
        if (isMinusToTwo(minusResult)) return "Win for "+this.player1Name;
        return "Win for "+this.player2Name;
    }

    private boolean isMinusToTwo(int minusResult) {
        return minusResult>=2;
    }

    public int calculateDifference(int scorePlayer1, int scorePlayer2){
        return scorePlayer1 - scorePlayer2;
    }


    public String selectScoreForEachPlayer(int scorePlayer){
        String score = "";
        switch(scorePlayer)
        {
            case 0:
                score+="Love";
                return score;
            case 1:
                score+="Fifteen";
                return score;
            case 2:
                score+="Thirty";
                return score;
            default:
                score+="Forty";
                return score;
        }
    }
    public boolean isThereAnyAdvantage (){return scorePlayer1 >=4 || scorePlayer2 >=4;}
    public boolean areEqual(){return scorePlayer1 == scorePlayer2;}

    public String getScore() {
        String score = "";
        if (areEqual()) {
            score = selectScoresWhenAreEqual(scorePlayer1);
        }
        else if (isThereAnyAdvantage()) {
            int minusResult = calculateDifference(scorePlayer1, scorePlayer2);
            score = selectScoreByAdvantage(minusResult);
        }
        else {
            score = selectScoreForEachPlayer(scorePlayer1) + "-" + selectScoreForEachPlayer(scorePlayer2);
        }
        return score;
    }
}