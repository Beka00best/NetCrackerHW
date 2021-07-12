package week2.second;

public class Human implements Player {
    private String name;
    private int count = 0;
    private int winCount = 0;

    public Human(String name){
        this.name = name;
    }

    @Override
    public void incrementWinCount(){
        winCount++;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getWinnerSpeech() {
        return "WINNER: Сегодня удача была на моей стороне!";
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
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
