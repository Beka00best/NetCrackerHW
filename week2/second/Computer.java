package week2.second;

public class Computer implements Player {
    private int count = 0;
    private int winCount = 0;
    private static Computer computer = new Computer();

    private Computer(){}

    public static Computer getInstance(){
        return computer;
    }

    @Override
    public void incrementWinCount(){
        winCount++;
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public String getWinnerSpeech() {
        return "Это восстание машин!";
    }

    @Override
    public String toString() {
        return "!!COMPUTER!! " + '\'' +
                ", count=" + count +
                ", winCount=" + winCount +
                '}';
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int getWinCount() {
        return winCount;
    }
}
