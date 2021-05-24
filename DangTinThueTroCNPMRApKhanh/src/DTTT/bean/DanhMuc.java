 
package DTTT.bean;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMuc {
    private String loai;
    private JLabel jlb;
    private JPanel jpn;
    
    public DanhMuc(String loai, JPanel jpn, JLabel jlb) {
        this.loai = loai;
        this.jlb = jlb;
        this.jpn = jpn;
    }

    public String getLoai() {
        return loai;
    }
    public void setLoai(String loai) {
        this.loai = loai;
    }
    public JLabel getJlb() {
        return jlb;
    }
    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    public JPanel getJpn() {
        return jpn;
    }
    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
    
}
