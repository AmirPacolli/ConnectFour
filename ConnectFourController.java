import java.util.*;

public class ConnectFourController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConnectFourModel model = new ConnectFourModel();
        ConnectFourView view = new ConnectFourView();

        int[][] matrix = new int[6][7];

        boolean running = true;
        boolean firstPlayer = true;
        int players;

        // Validation
        do{
            System.out.println("Enter 1 for one player | Enter 2 for two players ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
             players = sc.nextInt();
        }while (players > 2 || players < 1);



        if(players == 1){
            boolean human = true;
            while (running) {

                int col;
                String player = human ? "Human": "Computer";

                view.displayMatrix(matrix);


                if(human) {

                    do {
                        System.out.println(player + " player  turn");
                        System.out.print("Enter a number (0-6): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a number!");
                            sc.next();
                        }
                        col = sc.nextInt();
                        if (col > 6 || col < 0) {
                            System.out.println("Please enter a number in range (0-6)");
                        }

                    } while (col > 6 || col < 0);

                    model.fillColumn(col, matrix, human ? 1 : 0);


                }else {
                    int computer = (int)(Math.random() * 7);
                    model.fillColumn(computer, matrix, human ? 1 : 0);

                }


                if (model.hasWinner(human ? 1 : 2, matrix)) {
                    view.displayMatrix(matrix);
                    System.out.println("The " + player + "  player won");
                    running = false;
                } else if (model.draw(matrix)) {
                    view.displayMatrix(matrix);
                    System.out.println("Draw game");
                    running = false;
                } else {
                    human = !human;

                }




            }
        }else {
            while (running) {

                String player = firstPlayer ? "Red" : "Blue";
                int column;

                view.displayMatrix(matrix);

                do {
                    System.out.println(player + " player turn");
                    System.out.print("Enter a number (0-6): ");
                    while (!sc.hasNextInt()) {
                        System.out.println("That's not a number! ");
                        sc.next();
                    }
                    column = sc.nextInt();
                    if (column > 6 || column < 0) {
                        System.out.println("Please enter a number in range (0-6)");
                    }

                } while (column > 6 || column < 0);

                model.fillColumn(column, matrix, firstPlayer ? 1 : 0);

                if (model.hasWinner(firstPlayer ? 1 : 2, matrix)) {
                    view.displayMatrix(matrix);
                    System.out.println("The " + player + " player won");
                    running = false;
                } else if (model.draw(matrix)) {
                    view.displayMatrix(matrix);
                    System.out.println("Draw game");
                    running = false;
                } else {
                    firstPlayer = !firstPlayer;

                }

            }
        }
    }

}









