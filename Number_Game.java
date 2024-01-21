import java.util.Random;
import java.util.Scanner;

class Number_Game {
    public static void main(String[] args) {

          boolean playAgain = true;
          int total_round = 0, total_attempt = 0;
        while(playAgain)
        {
          Scanner S = new Scanner(System.in);
          Random random = new Random();
          int random_num = 1 + random.nextInt(99);
  
          int user_num;
          int attempt = 0;
          
        

                  do {
                            System.out.println("Your Attempt is :"+(attempt+1));
            System.out.println("User, please enter your choice:");
            user_num = S.nextInt();
            System.out.println("The user entered number is: " + user_num);
            
            if (user_num < random_num)
            {
                      System.out.println("Too Low!");
                    } 
            else if (user_num > random_num) 
            {
                      System.out.println("Too High!");
                    }
                    attempt++;
          }while (user_num != random_num && attempt < 5);

         if(user_num == random_num)
         {
                   System.out.println("Congratulations! You guessed the correct number in " +attempt+" attempts.");
                   total_round+=1;
                   total_attempt+=1;
          }
          else
          {
                    System.out.println("Sorry You Cant Not guset the Number in "+attempt+" attempt.\n The Random Number was:"+random_num);
          }
          
          System.out.println("Do You Want to Play Again!\nYes\nNo");
          String playAgain_user = S.next().toLowerCase();
         playAgain = playAgain_user.equals("yes");
          
         S.close();
}
System.out.println("Thanks for Playing! Your Total number of Rounds are :"+total_round+" and your Attemps are :"+total_attempt);
}
}