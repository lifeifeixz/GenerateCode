package test.gongxaing.made;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import test.gongxaing.model.Field;
import test.gongxaing.model.Modular;

/**
 * 详情的拼接方式
 *
 * @author flysLi
 * @date 2018/3/15
 */
public class MadeDetail extends AbstractMadeDefault {
    private Document dom;
    private Element box;
    private Element row;
    private Element item;
    private Element detailLab;
    private Element detailValue;
    private static final String TYPE = "-detail";

    public MadeDetail() {
        
    }

    @Override
    public void setMadeStrategy(MadeStrategy madeStrategy) {
        this.madeStrategy = madeStrategy;
    }

    @Override
    public String make(Modular modular) {
        Document document = null;
        if (modular.getType().equals(TYPE)) {
        	this.initAnalysisTemplate();
            this.fieldList = modular.getTds();
            /*删除原有的item*/
            document = Jsoup.parse(this.dom.outerHtml());
            Element row = document.getElementsByClass("row").get(0);
            document.getElementsByClass("item").get(0).remove();
            for (Field field : this.fieldList) {
                Element item = this.item;
                Element lab = this.detailLab;
                Element val = this.detailValue;
                lab.text(field.getName());
                String str = lab.outerHtml() + val.outerHtml();
                System.out.println(str);
                item.html(str);
                row.append(item.outerHtml());
            }
            this.out(document.outerHtml());
        } else {
            return this.madeStrategy.make(modular);
        }
        return document.outerHtml();
    }

    /**
     * 初始化模板
     */
    public void initAnalysisTemplate() {
        //2018/3/15 找到模板
        this.dom = this.getTemplateByType("detail");
        /*外层容器*/
        this.box = dom.getElementsByClass("detail-rows").get(0);
        /*行模板*/
        this.row = dom.getElementsByClass("row").get(0);
        /*item模板*/
        this.item = dom.getElementsByClass("item").get(0);
        /*detail-lab模板*/
        this.detailLab = dom.getElementsByClass("detail-lab").get(0);
        /*detail-value模板*/
        this.detailValue = dom.getElementsByClass("detail-value").get(0);
    }
}
