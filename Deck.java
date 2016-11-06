import java.util.ArrayList;//Needed for ArrayList class
import java.util.Random;//Needed for Random class

/*
 * Description: 處理牌組的class，並有printDeck、 ArrayList<Card>getAllCards
 * 、shuffle、Card getOneCard的四種方法
 */
class Deck {
	private ArrayList<Card> cards;//所有的牌
    private ArrayList<Card> usedCard;//發出去的牌紀錄
    public int nUsed;//發了幾張牌
	
	public Deck(int nDeck) {//Constructors
		cards = new ArrayList<Card>();
		usedCard=new ArrayList<Card>();
		for (int i = 1; i <= nDeck; i++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int y = 1; y <= 13; y++) {
					Card card = new Card(s, y);
					cards.add(card);
				}
			}
		}
		shuffle();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(s,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(Club,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end

	}

	
	public void printDeck() {
		for (int index = 0; index < cards.size(); index++) {
			Card account = cards.get(index);
			account.printCard();
		}
		// Hint: print all items in ArrayList<Card> cards,
		// please implement and reuse printCard method in Card class

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
	public void shuffle(){//全部牌收回（不管發出去幾張），重新洗牌 
		Random rnd = new Random();
		int size=usedCard.size();
		//如果不先在這存usedCard.size()的話，usedCars.size()可能會隨著for迴圈改變
		for(int number=0;number<usedCard.size();number++){
				Card onecard=usedCard.get(number);
				cards.add(onecard);//把usedCard的東西放回cards
				}
			
		for(int i=0;i<size;i++){
			usedCard.remove(0);//reset usedCard
		}
		nUsed=0;//reset nUsed
		for(int index=0;index<cards.size();index++){
		int j = rnd.nextInt(cards.size());
		//要取亂數0~51,cards.size()=52,rnd.nextInt(52)是指0≦a<52
		Card temp=cards.get(index);
		cards.set(index,cards.get(j));
		cards.set(j, temp);
		//上面三行是在做洗牌的動作
		}
	}
    public Card getOneCard(){//發一張牌出來
    	if(cards.size()==0)//if(usedCard.size==52)也可以，兩者都代表沒牌發的情況
    	{shuffle();}
    	Card oneCard=cards.get(0);//取最上面那張牌
    	usedCard.add(oneCard);//記錄發過他了
    	cards.remove(0);//刪掉那張牌，否則下一次取還是那張牌
    	nUsed++;
    	return oneCard;
    	
    }
	
	
	
}