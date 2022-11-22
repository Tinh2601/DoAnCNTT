package vn.iotstar.model;

public class CategoryModel {
	private int cateId;
	private String cateName;
	private String images;
	private int status;

	public CategoryModel(int cateId, String cateName, String images, int status) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
		this.images = images;
		this.status = status;
	}

	public CategoryModel() {
		super();
	}

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryModel [cateId=" + cateId + ", cateName=" + cateName + ", images=" + images + ", status="
				+ status + "]";
	}
	
}
