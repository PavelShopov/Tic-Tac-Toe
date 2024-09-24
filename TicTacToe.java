
import java.util.Scanner;
import java.util.ArrayList;

public class TicTacToe {
    private static char turn = 'O';
    private char[][] board;
    private ArrayList<Integer> moves = new ArrayList<>();

    public static char getTurn() {
        return turn;
    }

    public TicTacToe() {
        this.board = new char[][] {
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' }
        };
    }
    private int[] posConverter(int pos){
        int [] positions = new int[2];
        switch (pos) {
            case 1:
                positions[0] = 0;
                positions[1]= 0;
                break;
            case 2:
            positions[0]= 0;
            positions[1]= 2;
                break;
            case 3:
                positions[0]= 0;
                positions[1]= 4;
                break;
            case 4:
                positions[0] = 2;
                positions[1]= 0;
                break;
            case 5:
            positions[0] = 2;
            positions[1] = 2;
                break;
            case 6:
            positions[0] = 2;
            positions[1] = 4;
                break;
            case 7:
            positions[0] = 4;
            positions[1]= 0;
                break;
            case 8:
                positions[0]= 4;
                 positions[1]= 2;
                break;
            case 9:
            positions[0]= 4;
            positions[1]= 4;
                break;
            default: 
            positions[0]=-1;
        }
        return positions;
    }
    public boolean MakeMove(int pos) {
        int i, j;
        int positions[]=posConverter(pos);
        if (positions[0]==-1) {
            return false;
        }
        if (moves.contains(pos)) {
            return false;
        }
        moves.add(pos);
        board[positions[0]][positions[1]] = turn;
        print();

        return true;
    }

    public void changeTurn() {
        switch (turn) {
            case 'X':turn = 'O';break;
            case 'O':turn = 'X';break;
        }
    }

    public void print() {
        for (char[] row : this.board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public boolean checker(int pos, int move) {
        if (move < 5) {
            return false;
        }
       int[] positions=posConverter(pos);
       int k,i=positions[0],j=positions[1];
        boolean check = true;
        for (k = 0; k < 5; k += 2) {
            for{
                
            }
            if (board[i][k] == turn) {
                continue;
            }
            check = false;
        }
        if (check) {
            return check;
        }
        check = true;
        for (k = 0; k < 5; k += 2) {
            if (board[k][j] == turn) {
                continue;
            }
            check = false;
        }
        if (check) {
            return check;
        }
        check = true;
        if (i == j) {
            for (k = 0; k < 5; k += 2) {
                if (board[k][k] == turn) {
                    continue;
                }
                check = false;
            }
            if (check) {
                return check;
            }
            check = true;
           
        }
        if (i+j==2) {
            
        }
        return false;
    }
}

class GameLauncher {

    public static void main(String[] args) {
        // Create an instance of TicTacToe

        TicTacToe game = new TicTacToe();
        game.print();
        Scanner scan = new Scanner(System.in);
        int pos = -1;
        int moves = 0;
        while (!game.checker(pos, moves) && moves <= 9) {
            game.changeTurn();
            System.out.println("Enter your move");
            pos = scan.nextInt();
            if (!game.MakeMove(pos)) {
                System.out.println("Wrong move please enter again.");
                game.changeTurn();
                continue;
            }
            moves++;
        }
        if (moves==10) {

            System.out.println("DRAW!! play again");
            
        }
        else{System.out.println("Congrats " + game.getTurn() + ", you win!!");
        }
        
}
}
