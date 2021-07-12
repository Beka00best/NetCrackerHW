package week1;

import java.util.Random;

public class Craps {

    public static void main(String[] args) {
        int N = 4;
        int K = 4;

        Craps game = new Craps();
        Сube[] cubes = new Сube[K];
        Player[] players = new Player[N];

        for(int i = 0; i < K; i++){
            cubes[i] = game.new Сube();
        }
        for(int i = 0; i < N-1; i++){
            players[i] = game.new Player(String.valueOf(i+1));
        }
        players[N-1] = game.new Player("Computer");

        int first = 0;
        while(true){
            System.out.println("------------------------------------------------");
            System.out.println("Бросает предыдущий победитель");
            System.out.println("Игрок: " + players[first]);
            int sum = 0;
            for(int i = 0; i < K; i++){
                int cube = cubes[i].throwСube();
                System.out.print(cube + "  ");
                sum += cube;
            }
            players[first].count = sum;
            System.out.println("\nСумма очков = " + sum);
            System.out.println();
            int Max = sum;
            int MaxIndex = first;
            for(int i = 0; i < N; i++){
                if(i != first){
                    System.out.println("Бросает игрок: " + players[i]);
                    sum = 0;
                    for(int j = 0; j < K; j++){
                        int cube = cubes[j].throwСube();
                        System.out.print(cube + "  ");
                        sum += cube;
                    }
                    players[i].count = sum;
                    System.out.println("\nСумма очков = " + sum);
                    System.out.println();
                    if(sum > Max){
                        MaxIndex = i;
                        Max = sum;
                    }
                }
            }

            System.out.println("Победитель: " + players[MaxIndex] + " с суммой очков " + Max);
            first = MaxIndex;
            players[first].winCount += 1;
            System.out.println();
            int maxWinCounts = players[first].winCount;
            Player winner = players[first];
            System.out.println("Статистика игроков:");
            for(int i = 0; i < N; i++){
                System.out.println(players[i]);
                if(maxWinCounts < players[i].winCount){
                    maxWinCounts = players[i].winCount;
                    winner = players[i];
                }
            }
            if(maxWinCounts >= 7){
                System.out.println();
                System.out.println("У нас есть победитель!");
                System.out.println(winner);
                break;
            }
        }
    }

    public class Player{
        private String name;
        private int count = 0;
        private int winCount = 0;

        private Player(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    ", winCount=" + winCount +
                    '}';
        }
    }

    public class Сube{
        final Random random = new Random();

        int throwСube(){
            return random.nextInt(6) + 1;
        }
    }
}
