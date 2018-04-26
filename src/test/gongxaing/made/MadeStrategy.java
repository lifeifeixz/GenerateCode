package test.gongxaing.made;

import test.gongxaing.model.Modular;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public interface MadeStrategy {

    /**
     * 指定输出路径
     *
     * @param dom
     */
    void out(String dom);

    /**
     * 制作
     */
    String make(Modular modular);

    void setMadeStrategy(MadeStrategy strategy);
}
