/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.sikuli.script.*;
import org.sikuli.script.ImagePath;

import java.awt.*;
import java.util.List;


/**
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static boolean run = true;

    public static void main(String[] args) throws AWTException {
        // TODO code application logic here
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input

        //initialize silkulix screen, add ImagePath
        Screen s = new Screen();
        ImagePath.add("src/images");
        ImagePath.add("images");

        //check ImagePath
        List<ImagePath.PathEntry> paths = ImagePath.getPaths();
        for (ImagePath.PathEntry path : paths) {
            System.out.println(path);
        }

        System.out.println(
                "Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");

        //create thread for global key listener, press ESCAPE to stop the loop
        (new Thread() {
            public void run() {
                keyboardHook.addKeyListener(
                        new GlobalKeyAdapter() {

                            @Override
                            public void keyPressed(GlobalKeyEvent event
                            ) {
                                System.out.println(event);
                                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                                    run = false;
                                }
                            }

                            @Override
                            public void keyReleased(GlobalKeyEvent event
                            ) {
                                System.out.println(event);
                            }
                        }
                );


            }
        }).start();

        //click 1.png
        (new Thread() {
            public void run() {

                Robot r1 = null;
                try {
                    r1 = new Robot();
                    while (run) {
                        try {
                            s.wait("1.png", 3000);
                        } catch (FindFailed findFailed) {
                            findFailed.printStackTrace();
                        }
                        r1.delay(1000);
                        s.click();
                    }
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //click 2.png
        (new Thread() {
            public void run() {

                Robot r2 = null;
                try {
                    r2 = new Robot();
                    while (run) {
                        try {
                            s.wait("2.png", 3000);
                        } catch (FindFailed findFailed) {
                            findFailed.printStackTrace();
                        }
                        r2.delay(1000);
                        s.click();
                    }
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        //click 3.png
        (new Thread() {
            public void run() {
                Robot r3 = null;
                try {
                    r3 = new Robot();
                    while (run) {
                        try {
                            s.wait("3.png", 3000);
                        } catch (FindFailed findFailed) {
                            findFailed.printStackTrace();
                        }
                        r3.delay(1000);
                        s.click();
                    }
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
