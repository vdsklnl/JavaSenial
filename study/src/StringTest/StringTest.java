package StringTest;

import java.util.Arrays;

/**
 * @author vdsklnl
 * @create 2022-04-05 17:59
 * @Description
 */

public class StringTest {
    public static void main(String[] args) {
//        String str = "shivauguw";
        StringTest test = new StringTest();

//        System.out.println(test.sortTest(str));
//        System.out.println(test.trimTest(str));
//        System.out.println(test.subReverse(str,2,5));

//        String str1 = "ab";
//        String str2 = "abkkcadkabkebfkabkskab";
//        System.out.println(test.getCount(str1, str2));

        String str1 = "abcwerthelloyuiodefabcde";
        String str2 = "cvhellobnmabcde";
//        System.out.println(test.getMaxSameString(str1, str2));
        String[] strings = test.getAllMaxSameString(str1, str2);
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) {
                break;
            }
            System.out.println(strings[i]);
        }

    }

    //去除String两端空格(String trim()方法)
    public String trimTest(String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (str.charAt(start) == ' ' && start < end) {
                start++;
            }
            while (str.charAt(start) == ' ' && start < end) {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }
            return str.substring(start, end);
        }
        return null;
    }

    //反转部分字符串
    public String subReverse(String str, int start, int end) {
        //方式一：String不可变，需进行char[]转化才能反转
//        if (str != null){
//            char[] charArray = str.toCharArray();
//            for (int i = start,j = end; i < j ; i++,j--) {
//                char temp = charArray[i];
//                charArray[i] = charArray[j];
//                charArray[j] = temp;
//            }
//            return new String(charArray);
//        }
//        return null;

        //方式二：采用StringBuffer进行字符串拼接
        if (str != null){
            StringBuffer s = new StringBuffer();
            s.append(str.substring(0, start));
            for (int i = end; i >= start ; i--) {
                s.append(str.charAt(i));
            }
            s.append(str.substring(end + 1));
            //两种方式均可
            return new String(s);
//            return s.toString();
        }
        return null;
    }

    // 获取一个字符串在另一个字符串中出现的次数
    public int getCount(String subString, String mainString) {
        if (mainString.length() >= subString.length()) {
            int count = 0;
            int index = 0;
            while (mainString.indexOf(subString, index) != -1) {
                index = mainString.indexOf(subString, index) + subString.length();
                count++;
            }
            return count;
        }
        return 0;
    }

    //获取两个字符串中最大相同子串。
    // 单子串
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null){
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() <= str2.length()) ? str1 : str2;

            int len = minString.length();

            for (int i = 0;i < len;i++) { //控制字符数量，去掉几个字符
                for (int x = 0,y = len - i;y <= len;x++,y++) {
                    if (maxString.contains(minString.substring(x, y))) {
                        return minString.substring(x, y);
                    }
                }
            }
        }
        return null;
    }
    //多子串1
//    public String[] getAllMaxSameString(String str1, String str2) {
//        if (str1 != null && str2 != null){
//            String maxString = (str1.length() > str2.length()) ? str1 : str2;
//            String minString = (str1.length() <= str2.length()) ? str1 : str2;
//            int len = minString.length();
//            String[] strings = new String[len];
//            int count = 0;
//            for (int i = 0;i < len;i++) { //控制字符数量，去掉几个字符
//                for (int x = 0,y = len - i;y <= len;x++,y++) {
//                    if (maxString.contains(minString.substring(x, y))) {
//                        strings[count++] = minString.substring(x, y);
//                    }
//                }
//                if (strings[0] != null) {
//                    break;
//                }
//            }
//            return strings;
//        }
//        return null;
//    }
    //多子串2 (正则表达式与StringBuffer)
    public String[] getAllMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null){
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() <= str2.length()) ? str1 : str2;
            int len = minString.length();
            StringBuffer s = new StringBuffer();
            for (int i = 0;i < len;i++) { //控制字符数量，去掉几个字符
                for (int x = 0,y = len - i;y <= len;x++,y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        s.append(subString + ',');
                    }
                }
                if (s.length() != 0) {  //不能用null来做判断，s=""初始
                    break;
                }
            }
            //先去除末尾逗号，再根据逗号分割
//            String[] strings = s.toString().replaceAll(",$", "").split("\\,");
            s = s.delete(s.length() - 1, s.length());
            String[] strings = s.toString().split("\\,");
            return strings;
        }
        return null;
    }
    //多子串3 (集合Arraylist)

    //对字符串中字符进行自然顺序排序
    public String sortTest(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}

