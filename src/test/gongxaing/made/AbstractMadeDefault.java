package test.gongxaing.made;

import test.gongxaing.BaseInfo;
import test.gongxaing.GenerateConfig;
import test.gongxaing.analysis.Analysis;
import test.gongxaing.model.Field;
import test.gongxaing.util.ResourceTransportationUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import test.gongxaing.BeanFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public abstract class AbstractMadeDefault implements MadeStrategy {
	List<Field> fieldList;
	Analysis analysis = BeanFactory.getAnalysisInstance();
	MadeStrategy madeStrategy;
	File rafaelia;

	/**
	 * 根据类型读取模板
	 *
	 * @param type
	 * @return
	 */
	public Document getTemplateByType(String type) {
		Document document = null;
		try {
			File path = new File(BaseInfo.getTemplateBasePath(), type + BaseInfo.TEMPLATE_SUFFIX);
			document = Jsoup.parse(path, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	@Override
	public void out(String dom) {
		ResourceTransportationUtil.writer(dom,
				BaseInfo.getProductBasePath() + GenerateConfig.generateConfig.getModularName() + ".html");
	}
}
