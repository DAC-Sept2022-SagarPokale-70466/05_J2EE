package beans;

import java.util.List;

import dao.UserDaoImpl;
import pojos.Blog;
import pojos.User;

public class UserBean {
	private UserDaoImpl udao;
	private String fname;
	private String email;
	private String pass;
	private String phoneno;
	private String title;
	private String content;
	private String categoryid;
	private String cattitle;
	private String id;
	private Blog blog;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog b) {
		this.blog = b;
	}
	public String getCattitle() {
		return cattitle;
	}
	public void setCattitle(String cattitle) {
		this.cattitle = cattitle;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public UserBean() {
		
		this.udao = new UserDaoImpl();
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
		System.out.println("title="+title);
	}
	
	public void setContent(String content) {
		this.content = content;
		System.out.println("content="+content);
	}
	
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
		System.out.println("id="+categoryid);
	}
	
	public String registerUser() {
		String msg= udao.registerUser(new User(this.fname,this.email,this.pass,this.phoneno));
		if(msg.equals("User Registration Successful")) {
			return "login";
		}else {
			return "register";
		}
	}
	public String confirmUser() {
		user = udao.authenticateUser(this.email, this.pass);
		if(user!=null) {
			return "showcategory";
		}else {
			return "login";
		}
	}
	
	public String addBlog() {
		
		if(udao.addBlog(Long.parseLong(categoryid), new Blog(this.title, this.content),this.email).equals("added blog to the category")){
			return "myblogs";
		}else {
			return "addblog";
		}
	}
	public List<Blog> getAllblogs(){
		return udao.displayBlogs();
	}
	public Blog BlogById() {
		Long id = Long.parseLong(this.id);
		return udao.blogById(id);
	}
	public String updateBlog() {
		if(udao.updateBlog(Long.parseLong(this.id),this.title,this.content)==1)
			return "myblogs";
		else
			return "update";
	}
	public String deleteBlog() {
		if(udao.deleteBlog(Long.parseLong(this.id))==1)
			return "myblogs";
		else
			return "myblogs";
	}
	public void searchBlog() {
		this.blog=udao.findBlog(this.title);
		this.title="";
	}
}