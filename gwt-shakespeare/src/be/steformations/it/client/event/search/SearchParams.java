package be.steformations.it.client.event.search;

public class SearchParams {
	
	private String play;
	private String speaker;
	private String start;
	
	public SearchParams() {
		super();
	}

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "SearchParams [play=" + play + ", speaker=" + speaker + ", start=" + start + "]";
	}
	
	
}
