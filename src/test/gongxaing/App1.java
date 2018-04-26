package test.gongxaing;

import test.gongxaing.analysis.Analysis;
import test.gongxaing.made.MadeStrategy;
import test.gongxaing.model.Modular;

import java.io.*;

import org.jsoup.Jsoup;

/**
 * @author flysLi
 * @date 2018/3/12
 */
public class App1 {
    public static void main(String[] args) throws Exception {
        String name = "调度派单操作记录-table";
        GenerateConfig.generateConfig.setFile(new File("D:\\workspace_student\\FileClient\\src\\main\\java\\test\\gongxaing\\sources\\rawmaterial\\" + name));
        File file = new File(GenerateConfig.generateConfig.getFile().getPath());
        Analysis analysis = BeanFactory.getAnalysisInstance();
        Modular modular = new Modular();
        modular.setTds(analysis.analysis(Jsoup.parse(file.getPath()).toString()));
        modular.setType("-table");
        /*made*/
        MadeStrategy madeStrategy = BeanFactory.getMadeStrategyInstance();
        madeStrategy.make(modular);
        System.out.println("制作完成");
    }
}
