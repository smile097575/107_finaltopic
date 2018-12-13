import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame2 extends JFrame {
    Container cp;
    private JLabel jlb = new JLabel();
    private JLabel jlblank = new JLabel();
    private JLabel jlbP1HP = new JLabel("剩餘生命");
    private JLabel jlbP2HP = new JLabel("剩餘生命");
    private JLabel jlbP1NumberHP = new JLabel("100");
    private JLabel jlbP2NumberHP = new JLabel("100");
    private JLabel jlbP1 = new JLabel();
    private JLabel jlbP2 = new JLabel();
    private JPanel jpnN = new JPanel(new GridLayout(1,5,3,3));
    private JPanel jpnC = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpnS = new JPanel(new GridLayout(1,3,3,3));
    ImageIcon icon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\untitled1\\src\\bg.JPG");
    ImageIcon iconP11right = new ImageIcon("");
    ImageIcon iconP11left = new ImageIcon("");
    ImageIcon iconP12right = new ImageIcon("");
    ImageIcon iconP12left = new ImageIcon("");
    ImageIcon iconP21right = new ImageIcon("");
    ImageIcon iconP21left = new ImageIcon("");
    ImageIcon iconP22right = new ImageIcon("");
    ImageIcon iconP22left = new ImageIcon("");
    private int jlbP1x, jlbP1y, jlbP2x, jlbP2y, P1HP, P2HP;     //預留P1Power, P2Power
    private int dirflog;                                        //攻擊判斷
    private int P1x, P1y, P2x, P2y;
    Frame1 frm2;
    public Frame2(Frame1 frm3){
        frm2 = frm3;
        ex();
    }private void ex(){
        cp = this.getContentPane();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100,100,960,650);
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm2.setVisible(true);
            }
        });
        cp.add(jpnN,BorderLayout.NORTH);
        jpnN.add(jlbP1HP);
        jpnN.add(jlbP1NumberHP);
        jpnN.add(jlblank);
        jpnN.add(jlbP2HP);
        jpnN.add(jlbP2NumberHP);

        cp.add(jpnC,BorderLayout.CENTER);
        jpnC.add(jlb);
        jlb.add(jlbP1);
        jlb.add(jlbP2);

        cp.add(jpnS,BorderLayout.SOUTH);

        jlb.setIcon(icon);                                                      //BG
        Image img1 = icon.getImage();
        Image img2 = img1.getScaledInstance(960,600,50);
        icon.setImage(img2);

        jlbP1.setIcon(iconP11right);                                                   //P1 right normal
        Image imgp11 = iconP11right.getImage();
        Image imgp13 = imgp11.getScaledInstance(100,200,50);
        iconP11right.setImage(imgp13);

        jlbP1.setIcon(iconP11left);                                                   //P1 left normal
        Image imgp15 = iconP11left.getImage();
        Image imgp17 = imgp15.getScaledInstance(100,200,50);
        iconP11left.setImage(imgp17);

        jlbP1.setIcon(iconP12right);                                                    //P1 right attack
        Image imgp12 = iconP12right.getImage();
        Image imgp14 = imgp12.getScaledInstance(100,200,50);
        iconP12right.setImage(imgp14);

        jlbP1.setIcon(iconP12left);                                                    //P1 left attack
        Image imgp16 = iconP12left.getImage();
        Image imgp18 = imgp16.getScaledInstance(100,200,50);
        iconP12left.setImage(imgp18);

        jlbP2.setIcon(iconP21right);                                                      //P2 right normal
        Image imgp21 = iconP21right.getImage();
        Image imgp23 = imgp21.getScaledInstance(100,200,50);
        iconP21right.setImage(imgp23);

        jlbP2.setIcon(iconP21left);                                                      //P2 left normal
        Image imgp25 = iconP21left.getImage();
        Image imgp27 = imgp25.getScaledInstance(100,200,50);
        iconP21left.setImage(imgp27);

        jlbP2.setIcon(iconP22right);                                                      //P2 right attack
        Image imgp22 = iconP22right.getImage();
        Image imgp24 = imgp22.getScaledInstance(100,200,50);
        iconP22right.setImage(imgp24);

        jlbP2.setIcon(iconP22left);                                                      //P2 left attack
        Image imgp26 = iconP22left.getImage();
        Image imgp28 = imgp26.getScaledInstance(100,200,50);
        iconP22left.setImage(imgp28);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch (e.getKeyCode()){
                    case 87:                //W
                        break;
                    case 65:                //A
                        break;
                    case 83:                //S
                        break;
                    case 68:                //D
                        break;
                    case 38:                //up
                        break;
                    case 40:                //dowm
                        break;
                    case 39:                //right
                        break;
                    case 37:                //left
                        break;
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 90:                //Z   P1攻擊

                        dirflog = 1;
                        check();
                        break;
                    case 17:                //Ctrl  P2攻擊
                        dirflog = 2;
                        check();
                        break;
                }
            }
        });
    }
    private void check(){

        int P2HP = Integer.parseInt(jlbP2HP.getText());
        int P1HP = Integer.parseInt(jlbP1HP.getText());

        if (P1HP != 0 || P2HP != 0){
            if (P1x == P2x&&P1y == P2y&&dirflog == 1){
                P2HP = P2HP - 5;
                String P2hp = Integer.toString(P2HP);
                jlbP2HP.setText(P2hp);
            }else if(P2x == P1x&&P2y == P1y&&dirflog == 2){
                P1HP = P1HP - 5;
                String P1hp = Integer.toString(P1HP);
                jlbP2HP.setText(P1hp);
            }
            dirflog = 0;
        }else {
            Frame3 frm4 = new Frame3(Frame2.this);
            frm4.setVisible(true);
        }
    }
}
