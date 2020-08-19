package tictactoe;

enum GameState {
    X_WIN("X wins"), O_WIN("O wins"), DRAW("Draw"), IMPOSSIBLE("Impossible"), UNFINISHED("Game not finished");

    public final String state;

    GameState(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}
