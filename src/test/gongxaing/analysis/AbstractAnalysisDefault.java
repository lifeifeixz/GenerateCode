package test.gongxaing.analysis;

/**
 * 职责链
 * 1.需要有一个按行读取的方法
 * 2.每个解析实例只有一种解析能力。
 * 如果当前实例无法完成当前的解析任务，将转给下一个解析实例
 *
 * @author flysLi
 * @date 2018/3/15
 */
public abstract class AbstractAnalysisDefault implements Analysis {

    String type = "-1";

    protected Analysis analysis;

    /**
     * 每一个任职者都拥有接收责任者方法
     *
     * @param analysis
     */
    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }
}
