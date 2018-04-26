package test.gongxaing;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 流程线
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class AssemblyLine {

    public static void main(String[] args) throws Exception {
      String str = "asdsa$url$asedasd";
      str=str.replaceAll("\\$url\\$", "000");
      System.out.println(str);
        
    }
}
