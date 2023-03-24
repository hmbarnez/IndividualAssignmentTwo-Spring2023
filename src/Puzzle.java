public class Puzzle {
    private int puzzId;
    private String puzzName;
    private String puzzAnswer;
    private String puzzDesc;
    private int numAttempts;

    public Puzzle(int puzzId, String puzzName, String puzzAnswer, String puzzDesc, int numAttempts) {
        this.puzzId = puzzId;
        this.puzzName = puzzName;
        this.puzzAnswer = puzzAnswer;
        this.puzzDesc = puzzDesc;
        this.numAttempts = numAttempts;
    }
}
