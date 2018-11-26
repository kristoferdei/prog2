import java.awt.EventQueue;
import javax.swing.JFrame;

public class Snake extends JFrame {
    
    public Snake() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            
            final int screen_Width = dim.width;
	    final int screen_Height = dim.height;
            
            JFrame ex = new Snake();
            
            frame.setSize(screen_Width , screen_Height);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
	    frame.setLayout( null );
	    frame.setVisible(true);
        });
    }
}
