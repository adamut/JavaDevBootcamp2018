package com.bootcamp;

public enum StringFunction {

    TO_UPPER_FUNCTION {
        @Override
        public String appy(String input) {
            return input.toUpperCase();
        }
    },
    TO_LOWER_FUNCTION {
        @Override
        public String appy(String input) {
            return input.toLowerCase();
        }
    },
    TO_CHAR_FUNCTION {
        @Override
        public String appy(String input) {
            final String EMPTY = "";
            return input.replace("", EMPTY);
        }
    };/*,
    REMOVE_CHAR_FUNCTION(' ') {
        @Override
        public String appy(String input) {
            final char EMPTY =' ';
            return input.replace(char)
        }
    };*/


    private char charToReplace;

    StringFunction() {
    }

    StringFunction(char charToReplace) {
        this.charToReplace = charToReplace;
    }

    public abstract String appy(String input);
}
