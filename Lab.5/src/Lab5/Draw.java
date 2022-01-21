package Lab5;

import javax.swing.*;
import java.awt.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;


import javax.swing.JComponent;

/**
 * A component that displays rectangles and ellipses.
 */
class Draw extends JComponent
{

    private static final long serialVersionUID = 1L;

    private final ArrayList<Float> xData;
    private final ArrayList<Float> yDataAdd;
    private final ArrayList<Float> yDataRemove;
    private final String xTitle = "ед";
    private final String yTitle = "мкс";

    public Draw(ArrayList<Float> xDataValue,
                ArrayList<Float> yDataValueAdd, ArrayList<Float> yDataValueRemove) {
        this.xData = xDataValue;
        this.yDataAdd = yDataValueAdd;
        this.yDataRemove = yDataValueRemove;
    }


    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        //Рисуем рамку для графика

        double leftX = 50;
        double topY = 0;
        double width = 400;
        double height = 500;

        ArrayList<Float> allY = new ArrayList<Float>(yDataRemove);
        allY.addAll(yDataRemove);

        float scaleXW = (float) ((Math.log10(Collections.max(xData))) / width);
        float scaleYH = (float) 0.5;


        //Рисуем рамку графика
            Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
            g2.draw(rect);

        //Рисуем подпись графика
        Font FTitle = new Font("Arial", Font.PLAIN, 14);
        g2.setFont(FTitle);
        g2.drawString(xTitle, (int) (leftX + width+50), (int) (topY + height + 30));
        g2.drawString(yTitle, (int) (leftX - 35), (int) (topY - 15));



            for(int i = 0; i<xData.size()-1; i++) {
                double FirstX;
                double SecondX;
                double FirstY = 0;
                double SecondY = 0;
                double FirstY2 = 0;
                double SecondY2 = 0;

                if (xData.get(i) != 0)
                    FirstX = Math.round(Math.log10(xData.get(i)) / scaleXW) + leftX;
                else
                    FirstX = leftX;
                SecondX = Math.round(Math.log10(xData.get(i + 1)) / scaleXW + leftX);

                if(yDataAdd.get(i) <= 10)
                FirstY = Math.round(500-10*yDataAdd.get(i)+topY);
                else if(yDataAdd.get(i)<=100)
                    FirstY = Math.round(400-10*yDataAdd.get(i)/10+topY);
                else if(yDataAdd.get(i)<=1000)
                    FirstY = Math.round(300-100*yDataAdd.get(i)/1000+topY);
                else if(yDataAdd.get(i) <= 10000)
                    FirstY = Math.round(200 - 100*yDataAdd.get(i)/10000+topY);
                else if(yDataAdd.get(i) <= 100000)
                    FirstY = Math.round(100-100*yDataAdd.get(i)/10000+topY);

                if(yDataAdd.get(i+1) <= 10)
                    SecondY = Math.round(500-10*yDataAdd.get(i+1)+topY);
                else if(yDataAdd.get(i+1)<=100)
                    SecondY = Math.round(400-10*yDataAdd.get(i+1)/10+topY);
                else if(yDataAdd.get(i+1)<=1000)
                    SecondY = Math.round(300-100*yDataAdd.get(i+1)/1000+topY);
                else if(yDataAdd.get(i+1) <= 10000)
                    SecondY = Math.round(200 - 100*yDataAdd.get(i+1)/10000+topY);
                else if(yDataAdd.get(i+1) <= 100000)
                    SecondY = Math.round(100-100*yDataAdd.get(i+1)/10000+topY);

                if(yDataRemove.get(i) <= 10)
                    FirstY2 = Math.round(500-10*yDataRemove.get(i)+topY);
                else if(yDataRemove.get(i)<=100)
                    FirstY2 = Math.round(400-10*yDataRemove.get(i)/10+topY);
                else if(yDataRemove.get(i)<=1000)
                    FirstY2 = Math.round(300-100*yDataRemove.get(i)/1000+topY);
                else if(yDataRemove.get(i) <= 10000)
                    FirstY2 = Math.round(200 - 100*yDataRemove.get(i)/10000+topY);
                else if(yDataRemove.get(i) <= 100000)
                    FirstY2 = Math.round(100-100*yDataRemove.get(i)/10000+topY);

                if(yDataRemove.get(i+1) <= 10)
                    SecondY2 = Math.round(500-10*yDataRemove.get(i+1)+topY);
                else if(yDataRemove.get(i+1)<=100)
                    SecondY2 = Math.round(400-10*yDataRemove.get(i+1)/10+topY);
                else if(yDataRemove.get(i+1)<=1000)
                    SecondY2 = Math.round(300-100*yDataRemove.get(i+1)/1000+topY);
                else if(yDataRemove.get(i+1) <= 10000)
                    SecondY2 = Math.round(200 - 100*yDataRemove.get(i+1)/10000+topY);
                else if(yDataRemove.get(i+1) <= 100000)
                    SecondY2 = Math.round(200-100*yDataRemove.get(i+1)/10000+topY);

                /*double FirstY2 = Math.round(height-yDataRemove.get(i)/scaleYH+topY);
                double SecondY2 = Math.round(height-yDataRemove.get(i+1)/scaleYH+topY);*/

//

                //Рисуем засечки на осях
                g2.draw(new Line2D.Double(FirstX, height+topY-10, FirstX, height+topY+10));
                g2.draw(new Line2D.Double(leftX-10, FirstY, leftX+10, FirstY));
                g2.draw(new Line2D.Double(leftX-10, FirstY2, leftX+10, FirstY2));


                //Пишем значения
                g2.setFont(new Font("TimesRoman", Font.BOLD, 13));
                String messageX = xData.get(i).toString();
                g2.drawString(messageX, (int) FirstX-5, (int) ((int) height+topY+20));
                String messageY1 = yDataAdd.get(i).toString();
                g2.drawString(messageY1, (int) ((int) leftX-35), (int) FirstY);
                String messageY2 = yDataRemove.get(i).toString();
                g2.drawString(messageY2, (int) ((int) leftX-35), (int) FirstY2);

                //Устанавливаем цвет.
                //Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур
                g2.setColor(Color.MAGENTA);

                //Рисуем квадраты, обозначающие точки
                Rectangle2D rec = new Rectangle2D.Double(FirstX-3, FirstY-3, 6, 6);
                g2.draw(rec);
                g2.fill(rec);



                //Соединяем точки линиями
                g2.draw(new Line2D.Double(FirstX, FirstY, SecondX, SecondY));

                //Устанавливаем цвет.
                //Будет применяться для всего содержимого компонента: линий, текстов, заливки фигур
                g2.setColor(Color.RED);

                //Рисуем квадраты, обозначающие точки
                Rectangle2D rec2 = new Rectangle2D.Double(FirstX-3, FirstY2-3, 6, 6);
                g2.draw(rec2);
                g2.fill(rec2);

                //Соединяем точки линиями
                g2.draw(new Line2D.Double(FirstX, FirstY2, SecondX, SecondY2));

                //Особо обрабатываем последнюю точку
                if( i == xData.size()-2 ) {

                    g2.setColor(Color.MAGENTA);
                    g2.draw(new Rectangle2D.Double(SecondX - 3, SecondY - 3, 6, 6));
                    g2.fill(new Rectangle2D.Double(SecondX - 3, SecondY - 3, 6, 6));
                    g2.setColor(Color.RED);
                    g2.draw(new Rectangle2D.Double(SecondX - 3, SecondY2 - 3, 6, 6));
                    g2.fill(new Rectangle2D.Double(SecondX - 3, SecondY2 - 3, 6, 6));

                    //Возвращаем цвет к значению по умолчанию

                    g2.setColor(Color.BLACK);
                    g2.draw(new Line2D.Double(SecondX, height + topY - 10, SecondX, height + topY + 10));
                    g2.draw(new Line2D.Double(leftX - 10, SecondY, leftX + 10, SecondY));
                    g2.draw(new Line2D.Double(leftX - 10, SecondY2, leftX + 10, SecondY2));
                    messageX = xData.get(i + 1).toString();
                    messageY1 = yDataAdd.get(i + 1).toString();
                    messageY2 = yDataRemove.get(i + 1).toString();
                    g2.drawString(messageX, (int) SecondX - 5, (int) ((int) height + topY + 20));
                    g2.drawString(messageY1, (int) ((int) leftX - 35), (int) SecondY);
                    g2.drawString(messageY2, (int) ((int) leftX - 35), (int) SecondY2);

                }

                //Возвращаем цвет к значению по умолчанию
                g2.setColor(Color.BLACK);

            }

        }

    }

