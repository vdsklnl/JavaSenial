package service;

import domain.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vdsklnl
 * @create 2022-05-03 20:50
 * @Description
 */

public class ItemService {

    private Item[] items;  // 题目组
    private final String ITEM_FILENAME = "Project5\\items.txt";  // 读取文件位置
    private final String ANSWER_FILENAME = "Project5\\answer.dat";  // 答案存放位置
    private final int ITEM_LINES = 6;  // 每题占用行数
    public final int TOTAL_ITEMS;  // 总题目数

    public ItemService() {

        List<String> list = readTextFile(ITEM_FILENAME);
        TOTAL_ITEMS = list.size() / ITEM_LINES;

        items = new Item[TOTAL_ITEMS];
        for (int i = 0; i < TOTAL_ITEMS; i++) {
            String question = list.get(i * ITEM_LINES);
            String[] options = {
                    list.get(i * ITEM_LINES + 1),
                    list.get(i * ITEM_LINES + 2),
                    list.get(i * ITEM_LINES + 3),
                    list.get(i * ITEM_LINES + 4),
            };
            char answer = list.get(i * ITEM_LINES + 5).charAt(0);
            items[i] = new Item(question, options, answer);
        }

    }

    private List<String> readTextFile(String filename) {

        List<String> content = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if(!("".equals(line.trim()))){
                    content.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;

    }

    public Item getItem(int no) {
        if(no < 0 || no > TOTAL_ITEMS){
            return null;
        }
        return items[no - 1];
    }

    public void saveAnswer(char[] answer) {

        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(ANSWER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(answer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public char[] readAnswer() {

        char[] answer = null;
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(ANSWER_FILENAME);
            ois = new ObjectInputStream(fis);
            answer = (char[]) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return answer;

    }

}
