package test.gongxaing.windows;

import java.awt.TextArea;

public class IndexFrameV2 extends IndexFrame {
	public TextArea nameArea;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndexFrameV2(String str) {
		super(str);

	}

	public static void main(String[] args) {
		IndexFrameV2 indexFrameV2 = new IndexFrameV2("更新版本的生成器v2(20180425)");
		indexFrameV2.init();
	}

}
