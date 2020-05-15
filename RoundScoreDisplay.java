public class RoundScoreDisplay implements Observer{
	 private Subject golfer;
	 private int strokesTotal, parTotal;
	 
	 public RoundScoreDisplay(Subject golfer) {
		 this.golfer = golfer;
		 golfer.registerObserver(this);
	 }
	 public void update(int strokes, int par) {
		 this.strokesTotal = strokes;
		 this.parTotal = par;
		 displayRoundScore();
	 }
	 private void displayRoundScore() {
			String[] messages = {"Made par", " under par", " over par"};
			System.out.println("Round Hole Stats");
			System.out.println("Par: " + parTotal + "\r\n" + "Strokes: " + strokesTotal);
			if(parTotal == strokesTotal) {
				System.out.println(messages[0] + "\r\n");
			}else if (parTotal < strokesTotal){
				int diff = strokesTotal - parTotal;
				System.out.println(diff + messages[1] + "\r\n");
			}else {
				int surplus = parTotal - strokesTotal;
				System.out.println(surplus + messages[0] + "\r\n");
			}
	 }
}
