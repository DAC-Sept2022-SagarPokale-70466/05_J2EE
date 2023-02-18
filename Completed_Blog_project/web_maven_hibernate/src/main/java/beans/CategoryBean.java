package beans;

import java.util.List;

import dao.CategoryDaoImpl;
import pojos.Category;

public class CategoryBean {
	private String title;
	private String description;
	private CategoryDaoImpl cdao;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryBean() {
		
		this.cdao = new CategoryDaoImpl();
	}
	public String addCategory() {
		String msg = cdao.createNewCategory(new Category(this.title,this.description));
		if(msg.equals("Category addition successful")) {
			return "showcategory";
		}else {
			return "addcategory";
		}
	}
	public List<Category> getAllCategories(){
		return cdao.displayAllCat();
	}
	
}
