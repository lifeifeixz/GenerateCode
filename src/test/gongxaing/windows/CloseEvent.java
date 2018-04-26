package test.gongxaing.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class CloseEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);//退出程序
    }
}
