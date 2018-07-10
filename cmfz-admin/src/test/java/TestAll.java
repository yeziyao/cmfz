/*

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestAll {
   @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AdminService adminService = (AdminService) ctx.getBean("adminServiceImpl");
        Admin admin = new Admin(null,"zs","111111",null);
        adminService.addAdmin(admin);
    }

    @Test
    public void test02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MasterService masterService = (MasterService) ctx.getBean("masterServiceImpl");
        Map<String, Object> map = masterService.queryBlur("masterName", "1", 1, 5);
        System.out.println(map);
    }

    @Test
    public void test03(){
*/
/*        ImportParams params = new ImportParams();
        params.setTitleRows(1);
//        params.setHeadRows(1);
        List<Master> list = ExcelImportUtil.importExcel(
                new File(PoiPublicUtil.getWebRootPath("master.xls")), Master.class, params);
        System.out.println(list.size());
        for(Master master:list){
            System.out.println(master);
        }*//*

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

   */
/* @Test
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

    @Test
    public void test06(){
        //创建安全管理器工厂
        String iniResourcePath = "classpath:shiro1.ini";
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory(iniResourcePath);
        //通过工厂创建安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
        //对安全管理器做初始化
        SecurityUtils.setSecurityManager(securityManager);
        //获取当前访问系统的主题对象
        Subject subject = SecurityUtils.getSubject();
        //认证(token=身份信息+凭证信息)
        AuthenticationToken token = new UsernamePasswordToken("zs","111111");
        try {
            subject.login(token);
            System.out.println("认证成功");
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码不正确");
        }
    }*//*

}
*/
