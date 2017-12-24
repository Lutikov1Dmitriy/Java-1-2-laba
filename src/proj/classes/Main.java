package proj.classes;

import proj.classes.Territories.ConsoleGUI;
import proj.classes.Territories.RequestHashManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int requestCounter = 5;
    public static void main(String[] args) throws IOException {
        ConsoleGUI gui = new ConsoleGUI();
        gui.Start();
    }
}
