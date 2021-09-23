
public class TennisGame3 implements TennisGame {

    private int pointsForPlayer1;
    private int pointsForPlayer2;
    private String player1Name;
    private String player2Name;
    private String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String p1N, String p2N) {
        this.player1Name = p1N;
        this.player2Name = p2N;
    }

    public String getPoint(int pointsForPlayer1){
        return points[pointsForPlayer1];
    }
    public boolean canBeAssignTwoScores(){
        return pointsForPlayer1 < 4 && pointsForPlayer2 < 4 && NoMoreThanSixPoints();}

    private boolean NoMoreThanSixPoints() {
        return (pointsForPlayer1 + pointsForPlayer2 != 6);
    }

    public boolean areEqualsInThree(){
        return pointsForPlayer1 == pointsForPlayer2;
    }
    public String carryTheSamePoints(String score){
        return (pointsForPlayer1 == pointsForPlayer2) ? score + "-All" : score + "-" + points[pointsForPlayer2];
    }
    public String nameOfTheCurrentWinner(){
        return pointsForPlayer1 > pointsForPlayer2 ? player1Name : player2Name;
    }

    public String advantageOrWin(String score){
        return ( difference() == 1) ? "Advantage " + score : "Win for " + score;
    }

    private int difference() {
        return (pointsForPlayer1 - pointsForPlayer2)*(pointsForPlayer1 - pointsForPlayer2);
    }

    public String getScore() {
        String score;
        if (canBeAssignTwoScores()) {
            score=getPoint(pointsForPlayer1);
            return carryTheSamePoints(score);
        } else {
            if (areEqualsInThree())
                return "Deuce";
            score = nameOfTheCurrentWinner();
            return advantageOrWin(score);
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.pointsForPlayer1 += 1;
        else
            this.pointsForPlayer2 += 1;
        
    }

}
