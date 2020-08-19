package tictactoe;

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

    public char getSymbol() {
        return symbol;
    }

    public abstract Symbol opposite();
}
