package memory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import static org.eclipse.swt.events.SelectionListener.*;
import org.eclipse.swt.events.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Memory 
{
		
	public static void main(String args[])
	{
	    File folder = new File("C:\\Users\\Anton\\Desktop\\Code\\Java\\New\\Memory new try\\myPictures"); 
	    File[] pictures = folder.listFiles();
	    String[] name = new String[pictures.length];
	    Image[] image = new Image[pictures.length];
	    Display display = new Display();		
		Shell shell = new Shell(display);
		Boolean[] hidden = new Boolean[16];
		Button[] button = new Button[16];
		Layout layout = new GridLayout(4, true);
	    for(int i = 0; i < pictures.length; i++)
	    { 
	      name[i] = pictures[i].getPath();	     
	      image[i] = new Image(display, name[i]);	         
	    }
	    for(int i = 0; i < 16; i++)
	    {
	    	button[i] = new Button(shell, SWT.PUSH);
	    	button[i].setImage(image[i]);
	    	button[i].setEnabled(true);
	    }
	    		
					
			button[0].addSelectionListener(new SelectionAdapter() 
			{
				public void
				widgetSelected(SelectionEvent e) 
				{
					if (button[0].getEnabled()) 
					{
						//button[0].setImage(image[0]);
						button[0].setEnabled(false);
					}
					else 
					{
						//button[0].setImage(image[0]);
						button[0].setEnabled(true);
					}
				}
			});
			
			
			/*button[i].addListener(SWT.Selection, new Listener() {
			      public void handleEvent(Event e[i]) {
			        switch (e.type) {
			        case SWT.Selection:
			        	button[i].setImage(image[i]);
			        	break;
			        } hidden[i] = true;	
			      }
			    });*/
					
		
		
		
		shell.setLayout(layout);		

		shell.open();
		while(!shell.isDisposed()) 
		{
			if(!display.readAndDispatch() )
			{
				display.sleep();
			}
		}
		
		display.sleep();		
	}
}
