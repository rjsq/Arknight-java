/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.sikuli.script.*;
import java.util.List;


/**
 * @author Yin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static boolean run = true;

    public static void main(String[] args) {
        // TODO code application logic here
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input

        //initialize sikulix screen, add ImagePath
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
        (new Thread(() -> keyboardHook.addKeyListener(
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
        ))).start();

        //click 1.png
        (new Thread(() -> {
            while (run) {
                try {
                    s.wait("1.png", 30000);
                    Thread.sleep(1000);
                    s.click();
                    Thread.sleep(10000);
                } catch (FindFailed | InterruptedException findFailed) {
                    findFailed.printStackTrace();
                }
            }

        })).start();

        //click 2.png
        (new Thread(() -> {
                while (run) {
                    try {
                        s.wait("2.png", 30000);
                        Thread.sleep(1000);
                        s.click();
                        Thread.sleep(10000);
                    } catch (FindFailed | InterruptedException findFailed) {
                        findFailed.printStackTrace();
                    }
                }
        })).start();

        //click 3.png
        (new Thread(() -> {
                while (run) {
                    try {
                        s.wait("3.png", 30000);
                        Thread.sleep(1000);
                        s.click();
                        Thread.sleep(10000);
                    } catch (FindFailed | InterruptedException findFailed) {
                        findFailed.printStackTrace();
                    }
                }
        })).start();
    }

}
