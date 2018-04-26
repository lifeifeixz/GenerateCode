package test.gongxaing.windows;

import java.awt.*;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class IndexFrame extends Frame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Button start, choiceFileBtn, exitout;
    public int baseX = 0;
    public FileDialog d1;
    public Label uploadLabel;
    public TextArea sourceArea;
    public TextArea nameArea;
    public TextField urlText;
    public Choice type;

    public IndexFrame(String str) {
        super(str);
    }

    public void init() {
        /*设置窗口居中显示*/
        this.setLayout(null);
        /*设置icon*/
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        /*源label*/
        uploadLabel = new Label("SOURCE");
        uploadLabel.setBounds(baseX + 50, 100, 60, 30);
        add(uploadLabel);
        /*源输入*/
        sourceArea = new TextArea();
        sourceArea.setBounds(baseX + 110, 100, 50, 30);
        int sourAreaHeight = 100;
        sourceArea.setSize(30000, sourAreaHeight);
        add(sourceArea);
        
        //name label
        Label nameLabel = new Label("NAMES");
        nameLabel.setBounds(baseX+50, this.uploadLabel.getY()+30+sourAreaHeight, 60, 30);
        add(nameLabel);
        //name value
        nameArea = new TextArea();
        nameArea.setBounds(baseX+110, this.uploadLabel.getY()+30+sourAreaHeight, 50, 30);
        nameArea.setSize(30000, sourAreaHeight);
        add(nameArea);
        
        //url
        Label urlL = new Label("URL");
        urlL.setBounds(baseX+50, nameLabel.getY()+30+sourAreaHeight, 60, 30);
        add(urlL);
        urlText = new TextField();
        urlText.setBounds(baseX+110, this.nameArea.getY()+30+sourAreaHeight, 300, 30);
        add(urlText);
        
        
        /*下拉框label*/
        Label select = new Label("TYPE");
        select.setBounds(baseX + 50, urlL.getY()+20+urlL.getHeight(), 60, 30);
        add(select);
        //下拉框组件
        type = new Choice();
        type.setBounds(baseX + 110, this.urlText.getY()+20 + urlText.getHeight(), 150, 30);
        type.add("-table");
        type.add("-detail");
        type.add("-form");
        add(type);

         /*开始按钮*/
        start = new Button("made");
        start.setBounds(baseX + 110, select.getY()+30, 60, 30);
        start.addActionListener(new MadeEvent());
        add(start);

        /*退出按钮*/
        exitout = new Button("exit");
        exitout.setBounds(baseX + 250, select.getY()+30, 60, 30);
        exitout.addActionListener(new CloseEvent());
        add(exitout);

        /*文件选择窗口*/
        d1 = new FileDialog(this, "Open File", FileDialog.LOAD);
    }

    public static void main(String[] args) {
        IndexFrame indexFrame = new IndexFrame("生成工具");
        indexFrame.init();
    }
}
