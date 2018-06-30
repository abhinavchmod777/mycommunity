package ModalClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Content {

	//-----------------------primary Attributes---------------------------//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="content_id")
	private int contentId;
	
	private String text;
	private String imagesLink;
	private String videosLink;
	
	//------------------------getters and setters-------------------------//
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImagesLink() {
		return imagesLink;
	}
	public void setImagesLink(String imagesLink) {
		this.imagesLink = imagesLink;
	}
	public String getVideosLink() {
		return videosLink;
	}
	public void setVideosLink(String videosLink) {
		this.videosLink = videosLink;
	}
	@Override
	public String toString() {
		return "Content [" + contentId + ", " + text + ", " + imagesLink + ", " + videosLink + "]";
	}
	
	
}
