import com.project.pojo.User;
import org.junit.jupiter.api.Test;

public class demo1 {
    @Test
    public void test1(){
        User user=new User("zhangsan","123456");
        System.out.println(user.getUsername());
    }
}
