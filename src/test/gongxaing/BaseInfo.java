package test.gongxaing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * 文件配置
 * 
 * @author flysLi
 * @date 2018/3/12
 */
public class BaseInfo {
	public static final String TEMPLATE_SUFFIX = "-template.html";

	public static String getBasePath() {
		return BaseInfo.class.getResource("/").getPath().replaceFirst("/", "");
	}

	public static String getTemplateBasePath() {
		return System.getProperty("user.dir") + "\\build\\classes\\test\\gongxaing\\sources\\templates\\";
	}

	public static String getProductBasePath() {
		return System.getProperty("user.dir") + "\\build\\classes\\test\\gongxaing\\sources\\product\\";
	}

	public static void main(String[] args) throws Exception {
		System.out.println(BaseInfo.class.getResourceAsStream("/AssemblyLine.java"));

	}
}
