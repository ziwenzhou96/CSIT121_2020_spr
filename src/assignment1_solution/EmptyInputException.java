package assignment1_solution;

public class EmptyInputException extends Exception {
    private String fieldName;

    public EmptyInputException(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String getMessage() {
        return "The "+fieldName+" is needed!";
    }
}

