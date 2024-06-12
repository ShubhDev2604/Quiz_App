import java.util.Scanner;

class Quiz_App {
    public static void main(String args[]) {
        Main_Screen m1 = new Main_Screen();
        m1.display();
    }
}

class Main_Screen {
    public void display() {
        System.out.println("***************Welcome to Quiz Appliaction***************");
        //Thread.sleep is used to pause the thread and the console for 2 secs
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner Inn = new Scanner(System.in);
        int choice = 1;
        while (choice == 1) {
            //This is used to clear the console.
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter 1 to take Quiz, 0 to exit from the program");
            choice = Inn.nextInt();
            if (choice == 1) {
                Quiz q1[] = new Quiz[5];
                //This is just initialization of array that will keep the refernces of the objects. You have to instantiate each object individually.
                for (int i = 0; i < 5; i++) {
                    q1[i] = new Quiz(); //Instantiation of each object.
                }
                /*Instead of asking the user the questions or I can say keeping the program simpler, the questions have been added manually, 
                 altho it can be done using Collect_quiz() method of quiz class at the run time.*/
                /*
                 * Filling Details of Question
                 * 
                 * q1[0].s1.append("");
                 * q1[0].option[0].append("");
                 * q1[0].option[1].append("");
                 * q1[0].option[2].append("");
                 * q1[0].option[3].append("");
                 * q1[0].answer = number;
                 */
                // Question 1
                q1[0].s1.append("Who wrote the novel \"1984\"?");
                q1[0].option[0].append("George Orwell");
                q1[0].option[1].append("Aldous Huxley");
                q1[0].option[2].append("J.K. Rowling");
                q1[0].option[3].append("Charles Dickens");
                q1[0].answer = 1;
                // Question 2
                q1[1].s1.append("What is the capital of Australia?");
                q1[1].option[0].append("Brisbane");
                q1[1].option[1].append("Sydney");
                q1[1].option[2].append("Melbourne");
                q1[1].option[3].append("Canberra");
                q1[1].answer = 4;
                // Question 3
                q1[2].s1.append("Which element has the chemical symbol \'Fe\'?");
                q1[2].option[0].append("Fluorine");
                q1[2].option[1].append("Iron");
                q1[2].option[2].append("Francium");
                q1[2].option[3].append("Fermium");
                q1[2].answer = 2;
                // Question 4
                q1[3].s1.append("Who painted the Mona Lisa?");
                q1[3].option[0].append("Vincent Van Gogh");
                q1[3].option[1].append("Pablo Picasso");
                q1[3].option[2].append("Leonardo da Vinci");
                q1[3].option[3].append("Michelangelo");
                q1[3].answer = 3;
                // Question 5
                q1[4].s1.append("What is the largest planet in our solar system?");
                q1[4].option[0].append("Earth");
                q1[4].option[1].append("Saturn");
                q1[4].option[2].append("Jupiter");
                q1[4].option[3].append("Neptune");
                q1[4].answer = 3;
                Question ques1 = new Question();
                for (int i = 0; i < 5; i++) {
                    ques1.display_Ques(q1[i]);
                }
                ques1.Score();
            } else if (choice == 0) {
                //function to exit and close the program.
                System.exit(0);
            } else {
                System.out.println("Wrong input Enter Again");
                System.out.println("Enter 1 to take Quiz, 0 to exit from the program");
            }
        }
        Inn.close();
    }
}

class Quiz {
    StringBuffer s1;
    StringBuffer option[];
    int opt[];
    int answer;

    Quiz() {
        s1 = new StringBuffer();
        option = new StringBuffer[4];
        opt = new int[4];
        for (int i = 0; i <= 3; i++) {
            option[i] = new StringBuffer();
            opt[i] = i + 1;
        }

    }

    void Collect_quiz() {
        System.out.println("Enter the Question:");
        Scanner takeinput = new Scanner(System.in);
        s1.append(takeinput.nextLine());
        for (int i = 0; i < 4; i++) {

            System.out.print("Enter Option " + (i + 1) + ":");
            option[i].append(takeinput.nextLine());
            opt[i] = i + 1;
            System.out.println();
        }
        System.out.println("Enter Correct Option Code:");
        answer = takeinput.nextInt();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeinput.close();
    }
}

class Question {
    static int score;

    void display_Ques(Quiz q1) {
        int ans;
        System.out.println(q1.s1);
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + ". " + q1.option[i++] + "\t\t" + (i + 1) + ". " + q1.option[i]);
            System.out.println();
        }
        System.out.print("Enter your Answer: ");
        Scanner input = new Scanner(System.in);
        ans = input.nextInt();
        System.out.println();
        if (ans == q1.answer) {
            score++;
        }

    }

    void Score() {
        if (score > 5) {
            score = 5;
        }
        System.out.println("Your Score is : " + score + "/5");
        System.out.println("Thank You!!");
        score = 0;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
