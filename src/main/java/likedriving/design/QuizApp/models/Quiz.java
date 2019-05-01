package likedriving.design.QuizApp.models;

import java.io.FileNotFoundException;
import java.util.*;

public class Quiz implements IQuiz {

    private List<Question> questionStore;

    public Quiz(){
        questionStore = initQuestionStore();
    }

    @Override
    public User getUser() {
        System.out.print("Welcome to Quiz App: Enter your username: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return new User(name);
    }

    @Override
    public Question loadQuestion(User user) throws FileNotFoundException {
        System.out.println("Loading Question...");


        Question question = getQuestion(questionStore);
        System.out.println(question.getText());

        int i=0;
        while (i< question.getOptions().size()){
            System.out.print(question.getOptions().get(i).getId()+". ");
            System.out.println(question.getOptions().get(i).getText());
            i++;
        }

        return question;
    }

    @Override
    public void askAnswer(User user, Question question) {
        System.out.println("Please input your answer: ");
        Scanner answerScanner = new Scanner(System.in);

        AttemptedQuestion attemptedQuestion = new AttemptedQuestion();

        Option option = new Option(answerScanner.nextInt());

        attemptedQuestion.getAttemptedQuestion().put(question, option);

        user.setAttemptedQuestions(attemptedQuestion);
    }


    static Question getQuestion(List<Question> questionStore) {
        Random random = new Random();
        int randomQuestionIndex = random.nextInt(questionStore.size());
        return questionStore.remove(randomQuestionIndex);
    }

    static List<Question> initQuestionStore(){

        List<Question> questionStore = new ArrayList<>();

        Question question = new Question();
        question.setId(1);
        question.setQuestionType(QuestionType.SINGLE_CORRECT_ANSWER);
        question.setText("What is the capital of India ?");

        question.setOptions(Arrays.asList(new Option(1, "New Delhi"), new Option(2, "Mumbai")));
        question.setAnswers(Arrays.asList(new Answer(1, "New Delhi")));

        questionStore.add(question);


        question = new Question();
        question.setId(3);
        question.setQuestionType(QuestionType.SINGLE_CORRECT_ANSWER);
        question.setText("Who is the PM of India ?");

        question.setOptions(Arrays.asList(new Option(1, "Narendra Modi"), new Option(2, "XYZ")));
        question.setAnswers(Arrays.asList(new Answer(1, "Narendra Modi")));

        questionStore.add(question);

        question = new Question();
        question.setId(2);
        question.setQuestionType(QuestionType.SINGLE_CORRECT_ANSWER);
        question.setText("What is the capital of Karanataka ?");

        question.setOptions(Arrays.asList(new Option(1, "Bangalore"), new Option(2, "Mumbai")));
        question.setAnswers(Arrays.asList(new Answer(1, "Bangalore")));

        questionStore.add(question);



        return questionStore;
    }

    @Override
    public void generateScore(User user) throws Exception {

        int score = 0;

        for(Map.Entry<Question, Option> map : user.getAttemptedQuestions().getAttemptedQuestion().entrySet()) {

            switch (map.getKey().getQuestionType()) {

                case SINGLE_CORRECT_ANSWER:
                    if (map.getValue().getId() == map.getKey().getAnswers().get(0).getId()) {
                        score = score + 1;
                    }
                    break;
                case MULTI_CORRECT_ANSWER:
                    /*if (map.getValue().getId() == map.getKey().getAnswers().get(0).getId()) {
                        score = score + 1;
                    }*/
                    break;
                case FREE_FORM:
                    if (map.getValue().getText().equals(map.getKey().getAnswers().get(0).getText())) {
                        score = score + 1;
                    }
                    break;

                default:
                    throw new Exception("Unexpected case");
            }
        }

        System.out.println("Your total Score is: "+ score);

    }


}
