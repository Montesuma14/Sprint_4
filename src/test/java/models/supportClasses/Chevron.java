package models.supportClasses;

public class Chevron {

    private String chevronQuestion;
    private String chevronAnswer;

    public Chevron(String chevronQuestion, String chevronAnswer) {
        this.chevronQuestion = chevronQuestion;
        this.chevronAnswer = chevronAnswer;

    }

    public String getChevronAnswer() {
        return chevronAnswer;
    }

    public void setChevronAnswer(String chevronAnswer) {
        this.chevronAnswer = chevronAnswer;
    }

    public String getChevronQuestion() {
        return chevronQuestion;
    }
}
