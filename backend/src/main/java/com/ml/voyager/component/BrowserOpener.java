package com.ml.voyager.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Profile("prod")
public class BrowserOpener implements CommandLineRunner {

    Logger logger = Logger.getLogger(BrowserOpener.class.getName());

    @Override
    public void run(String... args) throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        String url = "http://localhost:8080";
        ProcessBuilder processBuilder;

        try {
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("rundll32", "url.dll,FileProtocolHandler", url);
            } else if (os.contains("mac")) {
                processBuilder = new ProcessBuilder("open", url);
            } else if (os.contains("nix") || os.contains("nux")) {
                processBuilder = new ProcessBuilder("xdg-open", url);
            } else {
                logger.log(Level.WARNING, "Nicht unterstütztes Betriebssystem für die Browseröffnung");
                return;
            }

            processBuilder.start();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ein Fehler ist aufgetreten beim Versuch, den Webbrowser zu öffnen", e);
        }
    }
}

