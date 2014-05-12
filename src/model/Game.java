package model;

import javax.persistence.*;

@Entity
@TableGenerator(name="gameGen",pkColumnName="key",pkColumnValue="gameID",initialValue=0,table="counters",valueColumnName="value")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="GAME_TYPE")
@Table(name="GAME")
public class Game {
	
	@Column(name="acceptCount")
	private int acceptCount;
	
	@Column(name="avgScore")
	private float avgScore;
	
	@Column(name="description")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="priceRange")
	private String priceRange;
	
	@Column(name="published")
	private boolean published;
	
	@Id @Column(name="gameID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gameGen") 
	private long id;
	
	public Game() {}
	
	public Game(String name, String description, String priceRange) {
		this.name = name;
		this.description = description;
		this.priceRange = priceRange;
		this.avgScore = 0;
		this.acceptCount = 0;
		this.published = false;
	}
		
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAcceptCount() {
		return acceptCount;
	}

	public void setAcceptCount(int acceptCount) {
		this.acceptCount = acceptCount;
	}

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	
}
