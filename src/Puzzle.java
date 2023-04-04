import java.io.Serializable;
import java.util.Scanner;

public class Puzzle implements Serializable {
    private final int puzzId;
    private final String puzzName;
    private final String puzzAnswer;
    private final String puzzDesc;
    private final int numAttempts;
    private boolean hasBeenSolved;
    //TODO need to add hasBeenSolved to the puzzles.txt file for saving purposes later

    public Puzzle(int puzzId, String puzzName, String puzzDesc, String puzzAnswer, int numAttempts) {
        this.puzzId = puzzId;
        this.puzzName = puzzName;
        this.puzzDesc = puzzDesc;
        this.puzzAnswer = puzzAnswer;
        this.numAttempts = numAttempts;
        this.hasBeenSolved = false;
    }



    public int getPuzzId() {
        return puzzId;
    }

    public boolean getHasBeenSolved() {
        return hasBeenSolved;
    }

    public void solvePuzzle(){
        Scanner scan = new Scanner(System.in);
        //temp num of attempts so that when the user returns the num of attempts resets to the original amount
        int tempAttempts = this.numAttempts;
        //puzzle intro
        System.out.println("You have found the "+this.puzzName+" puzzle!");
        System.out.println(this.puzzDesc);
        //puzzle solve loops runs until puzzle is solved or if user runs out of attempts
        while((tempAttempts != 0) && (!this.hasBeenSolved)){
            String answerInput = scan.nextLine().toLowerCase();
            //checks to see if answer is correct
            if (answerInput.equalsIgnoreCase(this.puzzAnswer)){
                this.hasBeenSolved = true;
                System.out.println("You solved the puzzle correctly!");
            }else{
                tempAttempts -= 1;
                //if its the last attempt the and the user didn't sovlve the puzzle failed msg is displayed
                if(tempAttempts > 0){
                    System.out.println("The answer you provided is wrong, you still have "+tempAttempts+" attempts left. Try one more time: ");
                }else{
                    System.out.println("You failed to solve the puzzle! :(");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzId=" + puzzId +
                ", puzzName='" + puzzName + '\'' +
                ", puzzAnswer='" + puzzAnswer + '\'' +
                ", puzzDesc='" + puzzDesc + '\'' +
                ", numAttempts=" + numAttempts +
                ", hasBeenSolved=" + hasBeenSolved +
                '}';
    }
}
