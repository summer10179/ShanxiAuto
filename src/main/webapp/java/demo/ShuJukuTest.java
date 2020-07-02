package demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Map;
import java.util.Random;

public class ShuJukuTest {
    @Test
    public void  ChaRu() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@172.19.188.198:1521:iimadev";
        String user = "JC_PRO";
        String password = "8P2621Xct-gFLUVm-_kV";


        //1.加载驱动程序
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Random rd = new Random();
        int code = rd.nextInt(100000);
        String s = "insert into P_CHECK_CONS_DTL (DET_DATA_ID, ORG_NO, PERIOD, TOPIC_CODE, STAT_CYCLE, CONS_NO, ATTR1, ATTR2, ATTR3, ATTR4, ATTR5, ATTR6, ATTR7, ATTR8, ATTR9, ATTR10, ATTR11, ATTR12, ATTR13, ATTR14, ATTR15, ATTR16, ATTR17, ATTR18, ATTR19, ATTR20, ATTR21, ATTR22, ATTR23, ATTR24, ATTR25, ATTR26, ATTR27, ATTR28, ATTR29, ATTR30, ATTR31, ATTR32, ATTR33, ATTR34, ATTR35, ATTR36, ATTR37, ATTR38, ATTR39, ATTR40, ATTR41, ATTR42, ATTR43, ATTR44, ATTR45, ATTR46, ATTR47, ATTR48, ATTR49, ATTR50, ATTR51, ATTR52, ATTR53, ATTR54, ATTR55, ATTR56, ATTR57, ATTR58, ATTR59, ATTR60, ATTR61, ATTR62, ATTR63, ATTR64, ATTR65, ATTR66, ATTR67, ATTR68, ATTR69, ATTR70, ATTR71, ATTR72, ATTR73, ATTR74, ATTR75, ATTR76, ATTR77, ATTR78, ATTR79, ATTR80, ATTR81, ATTR82, ATTR83, ATTR84, ATTR85, ATTR86, ATTR87, ATTR88, ATTR89, ATTR90, ATTR91, ATTR92, ATTR93, ATTR94, ATTR95, ATTR96, ATTR97, ATTR98, ATTR99, " +
                "ATTR100) values (+code+, '614015403', '03', 'ZT0004', '202004', '0000359724', 'LXH', 'AC02202', 'XQDJ36H1HL3DY802S', '9910', '200', '5', '5', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '')";
        PreparedStatement pst = conn.prepareStatement(s);
        pst.execute();
        pst.close();
        String s1 = "select * from P_CHECK_CONS_DTL where DET_DATA_ID=90226";
        PreparedStatement pst1 = conn.prepareStatement(s1);
        ResultSet rs = pst1.executeQuery();
    }
}
