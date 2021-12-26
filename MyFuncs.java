
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammadi
 */
public class MyFuncs {
    public static void printComponenet(Component component){
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable (new Printable() {    
          public int print(Graphics pg, PageFormat pf, int pageNum){
            if (pageNum > 0){
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            component.paint(g2);
                return Printable.PAGE_EXISTS;
          }
        });
        if (pj.printDialog() == false) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException ex) {
        // handle exception
        }
    }
}
