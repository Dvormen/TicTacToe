import java.util.Scanner;

/**
 * This class starts the game
 */
public class Start {
    private static boolean loop = true;

    /**
     * This method lets the player choose the difficulty and starts the game
     */
    public static void startedGame(){
    System.out.println("What difficulty do you wish to play?");
    System.out.println("Type 1 for 3x3 grid");
    System.out.println("or type 2 for 5x5 grid");
    while(loop){
        try{
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if(n == 1){
                Difficulty1 d1 = new Difficulty1();
                loop = false;
            } else if (n == 2) {
                Difficulty2 d2 = new Difficulty2();
                loop = false;
            }else{
                System.out.println("Type 1 for 3x3 grid or type 2 for 5x5 grid");
            }
        }catch(Exception e){
            System.out.println("Type 1 for 3x3 grid or type 2 for 5x5 grid");
        }
    }
}
}
