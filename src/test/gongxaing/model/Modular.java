package test.gongxaing.model;

/**
 * 页面模块所需要的数据的容器
 *
 * @author flysLi
 * @date 2018/3/29
 */
public class Modular {

    /**
     * 列表显示字段
     **/
    private Fields tds;

    /**
     * 结果字段
     **/
    private Querys querys;

    /**
     * 模块类型
     **/
    private String type;
    
    /**
     * 模块依赖的远程服务
     */
    private String url;
    
    public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Modular(){
    	
    }
    public Modular(Fields tds){
    	
    }

    public Fields getTds() {
        return tds;
    }

    public void setTds(Fields tds) {
        this.tds = tds;
    }

    public Querys getQuerys() {
        return querys;
    }

    public void setQuerys(Querys querys) {
        this.querys = querys;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
