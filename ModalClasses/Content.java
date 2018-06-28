package ModalClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Content {

	@Id
	private int content_id;
	private String img_link;
	private String video_link;
	private String textParagraphs;
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public String getImg_link() {
		return img_link;
	}
	public void setImg_link(String img_link) {
		this.img_link = img_link;
	}
	public String getVideo_link() {
		return video_link;
	}
	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}
	public String getTextParagraphs() {
		return textParagraphs;
	}
	public void setTextParagraphs(String textParagraphs) {
		this.textParagraphs = textParagraphs;
	}
}
