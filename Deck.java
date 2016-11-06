import java.util.ArrayList;//Needed for ArrayList class
import java.util.Random;//Needed for Random class

/*
 * Description: �B�z�P�ժ�class�A�æ�printDeck�B ArrayList<Card>getAllCards
 * �Bshuffle�BCard getOneCard���|�ؤ�k
 */
class Deck {
	private ArrayList<Card> cards;//�Ҧ����P
    private ArrayList<Card> usedCard;//�o�X�h���P����
    public int nUsed;//�o�F�X�i�P
	
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
	public void shuffle(){//�����P���^�]���޵o�X�h�X�i�^�A���s�~�P 
		Random rnd = new Random();
		int size=usedCard.size();
		//�p�G�����b�o�susedCard.size()���ܡAusedCars.size()�i��|�H��for�j�����
		for(int number=0;number<usedCard.size();number++){
				Card onecard=usedCard.get(number);
				cards.add(onecard);//��usedCard���F���^cards
				}
			
		for(int i=0;i<size;i++){
			usedCard.remove(0);//reset usedCard
		}
		nUsed=0;//reset nUsed
		for(int index=0;index<cards.size();index++){
		int j = rnd.nextInt(cards.size());
		//�n���ü�0~51,cards.size()=52,rnd.nextInt(52)�O��0��a<52
		Card temp=cards.get(index);
		cards.set(index,cards.get(j));
		cards.set(j, temp);
		//�W���T��O�b���~�P���ʧ@
		}
	}
    public Card getOneCard(){//�o�@�i�P�X��
    	if(cards.size()==0)//if(usedCard.size==52)�]�i�H�A��̳��N��S�P�o�����p
    	{shuffle();}
    	Card oneCard=cards.get(0);//���̤W�����i�P
    	usedCard.add(oneCard);//�O���o�L�L�F
    	cards.remove(0);//�R�����i�P�A�_�h�U�@�����٬O���i�P
    	nUsed++;
    	return oneCard;
    	
    }
	
	
	
}