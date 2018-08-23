package swing.Jtree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Branch {
    DefaultMutableTreeNode r;

    // DefaultMutableTreeNode????????????е??????,?????????ж??????
    public Branch(String[] data) {
        r = new DefaultMutableTreeNode(data[0]);//根节点
        for (int i = 1; i < data.length; i++)
            r.add(new DefaultMutableTreeNode(data[i]));
        // ?????r?????????
    }

    public DefaultMutableTreeNode node() {// ??????
        return r;
    }
}

public class Trees extends JPanel {
    String[][] data = { { "Colors", "Red", "Blue", "Green" },
            { "Flavors", "Tart", "Sweet", "Bland" },
            { "Length", "Short", "Medium", "Long" },
            { "Volume", "High", "Medium", "Low" },
            { "Temperature", "High", "Medium", "Low" },
            { "Intensity", "High", "Medium", "Low" } };
    static int i = 0; // I?????????????????
    DefaultMutableTreeNode root, child, chosen;
    JTree tree;
    DefaultTreeModel model;

    public Trees() {
        setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("root");
        // ???????г????
        tree = new JTree(root);
        // ?????г?????????????????root????
        add(new JScrollPane(tree));
        // ????????????Trees??
        model = (DefaultTreeModel) tree.getModel();
        // ??????????DefaultTreeModel
        JButton test = new JButton("Press me");
        // ???test???г????
        test.addActionListener(new ActionListener() {
            // ???test????????
            public void actionPerformed(ActionEvent e) {
                if (i < data.length) {
                    // ???test????????С??data?????
                    child = new Branch(data[i++]).node();
                    // ????????
//                    chosen = (DefaultMutableTreeNode)
//                            // ???child??????
//                            tree.getLastSelectedPathComponent();
//                    if (chosen == null)
//                        chosen = root;
//                    model.insertNodeInto(child, chosen, 0);
                    // ??child????chosen
                    //???????????
                    model.insertNodeInto(child,root,0);
                }
            }
        });
        test.setBackground(Color.blue);
        // ???test????????????
        test.setForeground(Color.white);
        // ???test????????????
        JPanel p = new JPanel();
        // ???p?????
        p.add(test);
        // ???????????p??
        add(p, BorderLayout.SOUTH);
        // ?????p????Trees??
    }

    public static void main(String args[]) {
        JFrame jf = new JFrame("JTree demo");

        jf.getContentPane().add(new Trees(), BorderLayout.CENTER);
        // ??Trees????????JFrame?????????
        jf.setSize(200, 500);
        jf.setVisible(true);
    }
}