package boot.spring.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//必须要有Lombok依赖
@Data                   //代替了Setter和Getter
@AllArgsConstructor     //代替了有参函数构造器
@NoArgsConstructor      //代替了无参函数构造器
@ToString               //代替了重写ToString
//该文件就是定义变量名字和方法
public class User {
	private String uid;
	private String username;
	private String password;
	private String sex;
	private String phone;
	private int is_admin=0;
	private int is_delete=0;
	private String create_time;

	public User(String uid, String username) {
		this.uid = uid;
		this.username = username;
	}
}