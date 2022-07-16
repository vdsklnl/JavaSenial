package test;

import view.ExamView;

/**
 * @author vdsklnl
 * @create 2022-05-03 20:50
 * @Description  测试
 */

public class Exam {

    public static void main(String[] args) {
        //测试一：
//    	ItemService itemService = new ItemService();
//    	List<String> list = itemService.readTextFile("Project5\\items.txt");
//    	for(String s : list){
//    		System.out.println(s);
//    	}

		//测试二：
//    	ItemService itemService = new ItemService();
//    	Item item = itemService.getItem(1);
//    	System.out.println(item);

		ExamView examView = new ExamView();
		examView.enterMainMenu();

    }

}
