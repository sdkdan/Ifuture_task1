package sample;

import java.util.ArrayList;
import java.util.Map;

public class History {
    private String wordsToFind;
    private String fileName;
    public static Map<User,String> userHistory;
    public static ArrayList<String> filesFounded = new ArrayList<>();
    public static ArrayList<String> wordsSearched = new ArrayList<>();

    public String getWordsToFind() {
        return wordsToFind;
    }

    public void setWordsToFind(String wordsToFind) {
        this.wordsToFind = wordsToFind;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//   public Map<User, String> getUserHistory() {
//        return userHistory;
//    }
//
//    public void setUserHistory(Map<User, String> userHistory) {
//        this.userHistory = userHistory;
//    }
}
