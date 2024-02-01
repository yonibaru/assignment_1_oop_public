public class ConcretePlayer implements Player{

    private final boolean isAttacker;
    private int wins;



    public ConcretePlayer(boolean isAttacker){
        this.isAttacker = isAttacker;
        this.wins = 0;
    }

    @Override
    public boolean isPlayerOne() { // returns true if the player is the defender
        return !isAttacker;
    }

    public void increaseWins() {
        this.wins++;
    }

    @Override
    public int getWins() {
        return this.wins;
    }
}
