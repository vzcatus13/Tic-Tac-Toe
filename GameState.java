package tictactoe;

/**
 * Enum class which represents states of game.
 */
enum GameState {
    X_WIN("X wins"), O_WIN("O wins"), DRAW("Draw"), IMPOSSIBLE("Impossible"), UNFINISHED("Game not finished");

    public final String state;

    GameState(String state) {
        this.state = state;
    }

    /**
     * Get string representation of specified state.
     * @return String object.
     */
    String getState() {
        return state;
    }
}
