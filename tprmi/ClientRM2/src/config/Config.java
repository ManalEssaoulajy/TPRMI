package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


   
public class Config {
    public static String ip;
    public static String port;
    private static Config config = new Config();

    private Config() {
        FileInputStream f = null;
        try {
            f = new FileInputStream("config.properties");
            Properties p = new Properties();
            p.load(f);
            ip = p.getProperty("ip");
            port = p.getProperty("port");
        } catch (IOException ex) {
            // Gérer les exceptions correctement
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ex) {
                    // Gérer les exceptions correctement
                    Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static Config getConfig() {
        return config;
    }
}







