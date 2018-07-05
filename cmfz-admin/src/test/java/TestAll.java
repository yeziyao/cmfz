import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.MenuService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.List;

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
        MenuService menu = (MenuService) ctx.getBean("menuServiceImpl");
        List<Menu> menus = menu.queryAll();
        for(Menu m:menus){
            System.out.println(m);
        }
    }
}
