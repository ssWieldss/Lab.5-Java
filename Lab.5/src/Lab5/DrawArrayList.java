package Lab5;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.*;


public class DrawArrayList extends JPanel {

	public DrawArrayList() throws IOException {


		//Формируем данные для построения графика

		ArrayList<Float> X = new ArrayList();
		X.add(0F);
		X.add(10F);
		X.add(100F);
		X.add(1000F);
		X.add(10000F);

		ArrayList<Float> Y_Add = new ArrayList();

		Properties props = new Properties();
		props.load(new FileInputStream(new File("C:\\Users\\egor1\\IdeaProjects\\Lab.5" +
				"\\src\\config\\ArrayList.ini")));

		Y_Add.add(Float.parseFloat(props.getProperty("0_ADD")));
		Y_Add.add(Float.parseFloat(props.getProperty("10_ADD")));
		Y_Add.add(Float.parseFloat(props.getProperty("100_ADD")));
		Y_Add.add(Float.parseFloat(props.getProperty("1000_ADD")));
		Y_Add.add(Float.parseFloat(props.getProperty("10000_ADD")));

		ArrayList<Float> Y_Remove = new ArrayList();

		Y_Remove.add(Float.parseFloat(props.getProperty("0_REMOVE")));
		Y_Remove.add(Float.parseFloat(props.getProperty("10_REMOVE")));
		Y_Remove.add(Float.parseFloat(props.getProperty("100_REMOVE")));
		Y_Remove.add(Float.parseFloat(props.getProperty("1000_REMOVE")));
		Y_Remove.add(Float.parseFloat(props.getProperty("10000_REMOVE")));



		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550, 500));
		this.setBackground(Color.WHITE);

		this.add(new Draw(X, Y_Add, Y_Remove));
	}
}
