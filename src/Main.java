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

import java.util.List;

/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static boolean run = true;

    public static void main(String[] args) {
        // TODO code application logic here
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // Use false here to switch to hook instead of raw input
        Screen s = new Screen();
        ImagePath.add("src/images");
        ImagePath.add("images");
        List<ImagePath.PathEntry> paths = ImagePath.getPaths();
        for (ImagePath.PathEntry path : paths) {
            System.out.println(path);
        }

        System.out.println(
                "Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");

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

        try {
            while (run) {

                try {
                    while (true) {
                        s.wait("1.png");
                        s.click();
                        s.wait("2.png");
                        s.click();
                        s.wait("3.png");
                        s.click();
                    }
                } catch (SikuliException e) {
                }
            }
        } catch (Exception e) {
            //Do nothing
        } finally {
            keyboardHook.shutdownHook();
        }

    }

}
