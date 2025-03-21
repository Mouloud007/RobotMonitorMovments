

public class RobotMonitor {



    // Public constants (VDM-SL: values), accessible to RobotGUI
    public static final int MAX = 6;
    public static final int MIN = 1;

    // State variables (VDM-SL: state RobotMonitor of)
    private int row;
    private int col;
    private Move move; // Nullable to represent [Moves] with nil

    // Constructor (VDM-SL: init RM == RM = mk_RobotMonitor(MIN, MIN, nil))
    public RobotMonitor() {
        this.row = MIN;
        this.col = MIN;
        this.move = null;
        checkInvariant(); // Ensure initial state satisfies invariant
    }

    // Invariant check (VDM-SL: inv mk_RobotMonitor(X, Y, M) == ...)
    private void checkInvariant() throws VDMException {
        boolean rowInRange = (row >= MIN && row <= MAX);
        boolean colInRange = (col >= MIN && col <= MAX);
        boolean moveValid = (move == null ||
                move == Move.LEFT ||
                move == Move.RIGHT ||
                move == Move.UP ||
                move == Move.DOWN);
        if (!(rowInRange && colInRange && moveValid)) {
            throw new VDMException("Invariant violated: " +
                    "row=" + row + ", col=" + col + ", move=" + move);
        }
    }

    // Operation: MoveRight (VDM-SL: MoveRight())
    public void MoveRight() throws VDMException {
        // Precondition check
        if (col >= MAX || (move != null && move == Move.RIGHT)) {
            throw new VDMException("Precondition failed for MoveRight: " +
                    "col=" + col + ", move=" + move);
        }
        // Post condition: col = col~ + 1 and move = <RIGHT>
        col = col + 1;
        move = Move.RIGHT;
        checkInvariant();
    }

    // Operation: MoveLeft (VDM-SL: MoveLeft())
    public void MoveLeft() throws VDMException {
        // Precondition check
        if (col <= MIN || (move != null && move == Move.LEFT)) {
            throw new VDMException("Precondition failed for MoveLeft: " +
                    "col=" + col + ", move=" + move);
        }
        // Post condition: col = col~ - 1 and move = <LEFT>
        col = col - 1;
        move = Move.LEFT;
        checkInvariant();
    }

    // Operation: MoveUp (VDM-SL: MoveUp())
    public void MoveUp() throws VDMException {
        // Precondition check
        if (row <= MIN || (move != null && move == Move.UP)) {
            throw new VDMException("Precondition failed for MoveUp: " +
                    "row=" + row + ", move=" + move);
        }
        // Post condition: row = row~ - 1 and move = <UP>
        row = row - 1;
        move = Move.UP;
        checkInvariant();
    }

    // Operation: MoveDown (VDM-SL: MoveDown())
    public void MoveDown() throws VDMException {
        // Precondition check
        if (row >= MAX || (move != null && move == Move.DOWN)) {
            throw new VDMException("Precondition failed for MoveDown: " +
                    "row=" + row + ", move=" + move);
        }
        // Post condition: row = row~ + 1 and move = <DOWN>
        row = row + 1;
        move = Move.DOWN;
        checkInvariant();
    }

    // Operation: GetRow (VDM-SL: GetRow() currentRow: nat1)
    public int GetRow() throws VDMException {
        checkInvariant();
        return row; // 1-based, matches GUI expectation
    }

    // Operation: GetCol (VDM-SL: GetCol() currentCol: nat1)
    public int GetCol() throws VDMException {
        checkInvariant();
        return col; // 1-based, matches GUI expectation
    }

    // Operation: GetMove (VDM-SL: GetMove() lastMove: [Moves])
    public Move GetMove() throws VDMException {
        checkInvariant();
        return move; // Returns null if move is nil, compatible with GUI
    }

    // Operation: Exit (VDM-SL: Exit())
    public void Exit() throws VDMException {
        // Precondition check
        if (row != MAX || col != MAX) {
            throw new VDMException("Precondition failed for Exit: " +
                    "row=" + row + ", col=" + col);
        }
        // Post condition: row = MIN and col = MIN and move = nil
        row = MIN;
        col = MIN;
        move = null;
        checkInvariant();
    }

    // Optional: toString for debugging
    @Override
    public String toString() {
        return "RobotMonitor[row=" + row + ", col=" + col + ", move=" + move + "]";
    }
}