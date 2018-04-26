package test.gongxaing;

import java.io.File;

/**
 * 配置
 *
 * @author flysLi
 * @date 2018/3/21
 */
public class GenerateConfig {
    /**
     * 饿汉式单例
     */
    public static GenerateConfig generateConfig = new GenerateConfig();

    /**
     * 模块名称(在生成文件中将会用到该字符)
     **/
    private String modularName;

    /**
     * 文件路径
     **/
    private File file;

    private GenerateConfig() {

    }


    public String getModularName() {
        return modularName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        /*模块名，由文件名截取而来*/
        String fileName = file.getName();
        fileName = fileName.substring(0, fileName.indexOf("-"));
        this.modularName = fileName;
    }

    public static void main(String[] args) {
        GenerateConfig.generateConfig.setFile(new File("D:\\workspace_student\\FileClient\\src\\main\\java\\test\\gongxaing\\sources\\rawmaterial\\xunjiandingdanguanli-table"));
        System.out.println(GenerateConfig.generateConfig.getModularName());

    }
}
