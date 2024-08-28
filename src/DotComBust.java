import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Sizning vazifangiz 3 ta saytni buzib kirish");
        System.out.println("Pets.com, eToys.com, Go2.com");

        for(DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Yurish qiling");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Yaqin kelgan edingiz";

        for(DotCom dotComTest : dotComsList){
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("Siz toptingiz")){
                break;
            }
            if(result.equals("Siz saytni buzdingiz")){
                dotComsList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("Barcha saytlar buzildi");
        if(numOfGuesses <= 18){
            System.out.println("Bu boryogi shuncha " + numOfGuesses + "urinishlarni oldi");

        }else{
            System.out.println("Bu judayam kop vaqtingizni oldi" + numOfGuesses );
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
