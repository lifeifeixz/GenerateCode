package test.gongxaing.windows;

import test.gongxaing.BaseInfo;
import test.gongxaing.made.MadeStrategy;
import test.gongxaing.model.Field;
import test.gongxaing.model.Fields;
import test.gongxaing.BeanFactory;
import test.gongxaing.model.Modular;
import test.gongxaing.util.ResourceTransportationUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class MadeEvent implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Button start = (Button) e.getSource();
		IndexFrame indexFrame = (IndexFrame) start.getParent();
		TextField url = indexFrame.urlText;
		TextArea nameArea = indexFrame.nameArea;
		Choice type = indexFrame.type;
		TextArea texts = indexFrame.sourceArea;

		// 1.得到输入的source(使用客户端传入的source暂时使用新的解析器TextAreaAnalysis)
		String source = texts.getText();
		String[] tds = source.split("\n");
		String name = nameArea.getText();
		String[] names = name.split("\n");

		// 2.开始生成
		Modular modular = new Modular();
		Fields fields = this.getVal(tds, names);
		modular.setTds(fields);
		modular.setType(type.getSelectedItem());
		modular.setUrl(url.getText());

		// 3.made
		MadeStrategy madeStrategy = BeanFactory.getMadeStrategyInstance();
		String product = madeStrategy.make(modular);
		String outPath = BaseInfo.getProductBasePath() + System.currentTimeMillis() + new Random().nextInt(100000) + ".vue";
		ResourceTransportationUtil.writer(product, outPath);
		// 4.打开生成文件
		File file = new File(outPath);
		Runtime ce = Runtime.getRuntime();
		try {
			ce.exec("cmd   /c   start  " + file.getAbsolutePath());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 将text和name对应好放到Fields中
	 * 
	 * @param texts
	 * @param names
	 * @see Fields
	 * @author flysLi
	 * @return Fields
	 */
	public Fields getVal(String[] texts, String[] names) {
		Fields fieldList = new Fields();
		for (int i = 0; i < texts.length; i++) {
			Field field = new Field();
			String fieldText = texts[i].replaceAll("\r", "");
			field.setName(fieldText);
			for (int j = 0; j < names.length; j++) {
				// 这里需要对names[i]进行一次有规则的拆分处理
				String[] nameLine = names[j].split("\\(");
				String name = nameLine[0].trim();
				String text = nameLine[1].split("\\:")[1].replaceAll(",", "").trim();
				if (text.equals(fieldText)) {
					field.setField(name);
				}
			}
			fieldList.add(field);
		}
		return fieldList;
	}

}
