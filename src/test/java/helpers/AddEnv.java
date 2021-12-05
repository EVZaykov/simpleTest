package helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class AddEnv {

    public static  void addEnvVar() {
        String path = "target/allure-results";//System.getProperty("target");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            String s = System.getProperty("BROWSER");
            String s1 = System.getenv("BUILD_URL");
            props.setProperty("BUILD_URL", "dasdsad");
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            props.setProperty("BUILD_URL", s1);
            props.setProperty("GIT_URL", System.getenv("GIT_URL"));
            props.setProperty("JOB_BASE_NAME", System.getenv("JOB_BASE_NAME"));
            props.setProperty("NODE_NAME", System.getenv("NODE_NAME"));
            props.setProperty("OS", System.getenv("OS"));
            props.setProperty("BROWSER", s);

            fos.close();

            //Files.move(Paths.get("D:\\simpleTestLastTryWithoutPG2\\src\\test\\resources\\environment.properties"), Paths.get("D:\\simpleTestLastTryWithoutPG2\\target\\allure-results\\"), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }
}
