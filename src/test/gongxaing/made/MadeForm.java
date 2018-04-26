package test.gongxaing.made;

import test.gongxaing.model.Modular;

/**
 * @author flysLi
 * @date 2018/3/21
 */
public class MadeForm extends AbstractMadeDefault {

    private static final String TYPE = "-form";

    @Override
    public String make(Modular modular) {
        if (modular.getType().equals(TYPE)) {
            return null;
        } else {
            return this.madeStrategy.make(modular);
        }
    }

    @Override
    public void setMadeStrategy(MadeStrategy strategy) {

    }
}
