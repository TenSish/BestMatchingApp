import javax.swing.JToggleButton;

public class Comparingtiles extends JFrame {    /**
     * 
    

    class GameButton extends JToggleButton{

        private static final long serialVersionUID = 1L;
        private JToggleButton gameButton;
        private Icon icon;

        public GameButton(JToggleButton gameButton,Icon icon){

            this.gameButton = gameButton;
            this.icon = icon;
        }

         public void setState() {
                if (this.isSelected() || !this.isEnabled()) {
                    this.setIcon(icon);
                } else {
                    this.setIcon(hidden);
                }
            }
        }

    private void buttonActionPerformed(ActionEvent e, GameButton button) throws InterruptedException {
        if(button.isSelected()){
            buttoncounter++;

            if(buttoncounter==1){
                buttonFirst = (GameButton) e.getSource();
            }
            else if(buttoncounter==2){
                buttonSecond = (GameButton) e.getSource();
                buttoncounter=0;

                    if( checkPairs(buttonFirst,buttonSecond) ) {
                        retirePair(buttonFirst,buttonSecond);
                    }

                    else{
                            Thread.sleep(2000);
                            buttonFirst.setIcon(hidden);
                            buttonFirst.setSelected(false);
                            buttonSecond.setIcon(hidden);
                            buttonSecond.setSelected(false);

                    }

            }
        }
    }

    private void retirePair(GameButton a, GameButton b){
        a.setSelected(true);
        a.setEnabled(false);
        b.setSelected(true);
        b.setEnabled(false);
    }

    private boolean checkPairs(GameButton first, GameButton second){

        if(first.getIcon().equals(second.getIcon()))
            return true;
        else
            return false;

    }

    private void createArray(){

        Random rnd = new Random();

        while(i<4){

            random = rnd.nextInt(3)+1;

            if(!includes(random)){
                arr[i]=random;
                iconList[i] = img[random-1];
                i++;
            }
        }
    }

    public boolean includes(int rnd){

        counter=0;

        for(j=0; j<arr.length; j++){

            if(arr[j] == rnd){
                counter++;
                if(counter>1)
                    return true;
            }
        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        new ConcentrationGame3();

    }

}
	