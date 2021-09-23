
public class
TennisGame2 implements TennisGame
{
    private int player1Point = 0;
    private int player2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String givePoints(int points){
        String score = "";
        switch (points){
            case 0:
                score = "Love";
                return score;
            case 1:
                score = "Fifteen";
                return score;
            case 2:
                score = "Thirty";
                return score;
            default:
                score = "Forty";
                return score;
        }
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

    public int scoreDifference(int p1point, int p2point){
        return p1point-p2point;
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

    private String selectPlayerWinner(int minusResult) {
        if (isMinusToTwo(minusResult)) return "Win for "+this.player1Name;
        return "Win for "+this.player2Name;
    }

    private boolean isMinusToTwo(int minusResult) {
        return minusResult>=2;
    }

        public boolean isThereAnyAdvantage (){return player1Point >=4 || player2Point >=4;}
    public boolean areEqual(){return player1Point == player2Point;}

    public String getScore(){
        String score = "";

        if (areEqual()){
            score = selectScoresWhenAreEqual(player1Point);
        }else if(isThereAnyAdvantage()){
            int diff = scoreDifference(player1Point, player2Point);
            score = selectScoreByAdvantage(diff);
        }else {
            score = givePoints(player1Point)  + "-" + givePoints(player2Point);
        }
        return score;
    }
    

    
    public void addPointToPlayer1(){
        player1Point++;
    }
    
    public void addPointToPlayer2(){
        player2Point++;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            addPointToPlayer1();
        if (playerName.equals(player2Name))
            addPointToPlayer2();
    }
}