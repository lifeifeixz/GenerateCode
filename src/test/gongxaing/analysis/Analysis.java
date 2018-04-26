package test.gongxaing.analysis;

import test.gongxaing.model.Fields;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public interface Analysis {

	/**
	 * 解析出字段
	 *
	 * @return
	 */
	Fields analysis(String dom);
}
