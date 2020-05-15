public class HoleScoreDisplay implements Observer{
	private Subject golfer;
	private int strokes,par;
	
	public HoleScoreDisplay(Subject golfer) {
		this.golfer = golfer;
		golfer.registerObserver(this);
	}
	public void update(int strokes, int par){
		this.strokes = strokes;
		this.par = par;
		displayCurrentScore();
	}
	private void displayCurrentScore() {
		String[] messages = {"Made par", " under par", " over par"};
		System.out.println("Current Hole Stats");
		System.out.println("Par: " + par + "\r\n" + "Strokes: " + strokes);
		if(par == strokes) {
			System.out.println(messages[0] + "\r\n");
		}else if (par < strokes){
			int diff = strokes - par;
			System.out.println(diff + messages[1] + "\r\n");
		}else {
			int surplus = par - strokes;
			System.out.println(surplus + messages[0]+ "\r\n");
		}
	}
}
