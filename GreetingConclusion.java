public class GreetingConclusion {
    private String[][] messages;
    private int greetingIndex;
    private int conclusionIndex;
    public GreetingConclusion() {
//Have list of greetings/conclusions
        messages = new String[][] {
            { "Welcome to the Library Management System!", "Have a great day!", "Hello! How can I assist you today?" },
            { "Thank you for using the Library Management System.", "Goodbye! Visit us again!", "See you next time!" }
        };
        greetingIndex = 0;
        conclusionIndex = 0;
    }
    public String getGreetingMessage() {
        String message = messages[0][greetingIndex];
        greetingIndex = (greetingIndex + 1) % messages[0].length;
        return message;
    }//Get 1 of the greetings
    public String getConclusionMessage() {
        String message = messages[1][conclusionIndex];
        conclusionIndex = (conclusionIndex + 1) % messages[1].length;
        return message;
    }//Get 1 of the conclusions
}

