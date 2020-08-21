package tictactoe;

/**
 * Enum class which represents symbols.
 */
enum Symbol {
    X('X') {
        @Override
        public Symbol opposite() {
            return O;
        }
    },
    O('O') {
        @Override
        public Symbol opposite() {
            return X;
        }
    },
    EMPTY(' ') {
        @Override
        public Symbol opposite() {
            return EMPTY;
        }
    };

    private final char symbol;

    Symbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Get char representation of symbol.
     * @return symbol in char.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get opposite symbol for specified.
     * @return opposite Symbol object for specified.
     */
    public abstract Symbol opposite();
}
