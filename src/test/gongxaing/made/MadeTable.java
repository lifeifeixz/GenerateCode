package test.gongxaing.made;

import test.gongxaing.model.Field;
import test.gongxaing.model.Fields;
import test.gongxaing.model.Modular;
import test.gongxaing.util.ResourceTransportationUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 生成table类型
 *
 * @author flysLi
 * @date 2018/3/16
 */
public class MadeTable extends AbstractMadeDefault {
	private static final String TYPE = "-table";

	@Override
	public String make(Modular modular) {
		Document product = null;
		if (modular.getType().equals(TYPE)) {
			Fields fields = modular.getTds();
			Document page = this.getTemplateByType("table");
			// 抽取模板
			product = Jsoup.parse(page.getElementsByTag("template").get(0).toString());
			// 脚本
			String script = ResourceTransportationUtil.readLocalResource(
					"D:\\workspace\\BlueCoves\\src\\test\\gongxaing\\sources\\templates\\table-template.js");

			// 产品table
			Element productTable = product.getElementsByClass("operation").get(0);
			/* 产品form */
			Element productForm = product.getElementsByClass("demo-form-inline").get(0);
			/* 查询按钮组件 */
			Element queryBtn = product.getElementById("queryBtn");

			/* 组件模板 */
			Element tdTemplate = page.getElementsByClass("td-template").get(0);
			/* 输入框模板 */
			Element formInputTemplate = page.getElementsByClass("form-input").get(0);
			/* 下拉框模板 */
			Element formSelectTemplate = page.getElementsByClass("form-select").get(0);
			/* 时间框模板 */
			Element formTimeTemplate = page.getElementsByClass("form-time").get(0);

			/* 清除产品form中的组件 */
			product.getElementsByClass("form-input").remove();
			product.getElementsByClass("form-select").remove();
			product.getElementsByClass("form-time").remove();
			/* 清空产品table中的td */
			product.getElementsByClass("td-template").get(0).remove();
			for (Field field : fields) {
				/* 如果包含'：'表示是form组件；否则是td */
				if (field.getName().indexOf("：") > -1) {
					Element component = null;
					if (field.getName().indexOf("时间") > -1 || field.getName().indexOf("日期") > -1) {
						component = formTimeTemplate.attr("label", field.getName().replaceAll("：", ""));
					} else {
						component = formInputTemplate.attr("label", field.getName());
						component.child(0).attr("placeholder", "请输入" + field.getName().replaceAll("：", ""));
					}
					queryBtn.before(component.outerHtml());
				} else {
					Element td = tdTemplate.attr("label", field.getName());
					td = tdTemplate.attr("property", field.getField());
					productTable.before(td.outerHtml());
				}
			}
			// 接口访问地址等修改
			String urlPos = "\\$url\\$";
			String prd = product.getElementsByTag("template").get(0).toString();
			prd=prd.replaceAll(urlPos, modular.getUrl());
			script = script.replaceAll(urlPos, modular.getUrl());
			prd =prd+script;
			Document m = Jsoup.parse(prd);
			return m.outerHtml();
		} else {
			return this.madeStrategy.make(modular);
		}
	}

	@Override
	public void setMadeStrategy(MadeStrategy madeStrategy) {
		this.madeStrategy = madeStrategy;
	}
}
