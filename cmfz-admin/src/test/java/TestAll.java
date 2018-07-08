import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestAll {
   /* @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AdminService adminService = (AdminService) ctx.getBean("adminServiceImpl");
        Admin admin = new Admin(null,"张三","123456",null);
        Admin ad = adminService.queryByName(admin);
        System.out.println(ad);
    }*/

    @Test
    public void test02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MasterService masterService = (MasterService) ctx.getBean("masterServiceImpl");
        Map<String, Object> map = masterService.queryBlur("masterName", "1", 1, 5);
        System.out.println(map);
    }

    @Test
    public void test03(){
/*        ImportParams params = new ImportParams();
        params.setTitleRows(1);
//        params.setHeadRows(1);
        List<Master> list = ExcelImportUtil.importExcel(
                new File(PoiPublicUtil.getWebRootPath("master.xls")), Master.class, params);
        System.out.println(list.size());
        for(Master master:list){
            System.out.println(master);
        }*/
    }

    @Test
    public void test04(){
        ExcelReader reader = ExcelUtil.getReader("master.xls");
        List<List<Object>> read = reader.read();
        List<Master> list = reader.readAll(Master.class);
        for(Master master:list){
            System.out.println(master);
        }
    }

    @Test
    public void test05(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MasterService masterService = (MasterService) ctx.getBean("masterServiceImpl");
        List<Master> masters = new ArrayList<Master>();
        masters.add(new Master(null,"nihao","1.jpg","没有什么介绍",null,null));
        masters.add(new Master(null,"nihao","1.jpg","没有什么介绍",null,null));
        masters.add(new Master(null,"nihao","1.jpg","没有什么介绍",null,null));
        masters.add(new Master(null,"nihao","1.jpg","没有什么介绍",null,null));
        System.out.println(masterService.batchAdd(masters));
    }
}
