package RESTfulExample;

public class OverVO {
	private CatVO[] categories = null;
	private ProVO[] product = null;
	public CatVO[] getCategories() {
		return categories;
	}
	public void setCategories(CatVO[] categories) {
		this.categories = categories;
	}
	public ProVO[] getProduct() {
		return product;
	}
	public void setProduct(ProVO[] product) {
		this.product = product;
	}

}
