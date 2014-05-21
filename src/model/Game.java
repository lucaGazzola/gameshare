package model;

import java.util.Collection;

import javax.persistence.*;

@Entity
@TableGenerator(name="gameGen",pkColumnName="key",pkColumnValue="ID_game",initialValue=0,table="counters",valueColumnName="value")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="GAME_TYPE")
@Table(name="GAME")
@MappedSuperclass
public class Game {
	
	@OneToMany(mappedBy="game")
	private Collection<Like> likes;
	
	@Column(name="acceptCount")
	private int acceptCount;
	
	@Column(name="avgScore")
	private float avgScore;
	
	@Column(name="description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name="name")
	private String name;
	
	@Column(name="priceRange")
	private String priceRange;
	
	@Column(name="published")
	private boolean published;
	
	@Id @Column(name="ID_game")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gameGen") 
	private long ID_game;
	
	public Game() {}
	
	public Game(String name, String description, String priceRange) {
		this.name = name;
		this.description = description;
		this.priceRange = priceRange;
		this.avgScore = 0;
		this.acceptCount = 0;
		this.published = false;
	}
		

	public long getID_game() {
		return ID_game;
	}

	public void setID_game(long iD_game) {
		ID_game = iD_game;
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

	@Override
	public String toString() {
		return "Game [acceptCount=" + acceptCount + ", avgScore=" + avgScore
				+ ", description=" + description + ", name=" + name
				+ ", priceRange=" + priceRange + ", published=" + published
				+ ", ID_game=" + ID_game + "]";
	}
	
	
	
}
