import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here B0344144 蘇鵬均
 * Try to write some comments for your codes (methods, 15 points)
 * Deck()method added the 52 cards of n deck by implement Card class into arrayList
 * printDeck() print all the cards in arrayList,each 52 card will change one deck
 * Card() gets cards and printCard() select the each card to right translation
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		for(int i =0;i<nDeck ; i++)  //N副牌
		{
			for(int x =1;x<=4;x++) //4花色
			{
				for (int y =1; y<=13 ;y++)  //13張
				{
					Card card = new Card(x,y);
					cards.add(card);
										
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int DC=1; //計算第幾副撲克牌的數量
		for(int i=0;i<cards.size();i++) {
			if(i%52==0) { //print deck number when a new deck start
				System.out.println("Deck-"+DC); //印出第DC副牌
				DC++;
				}
			cards.get(i).printCard();   //print所有牌
			}
	
		
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		switch(suit)//把數字改英文
		{ 
		case 1:
			switch(rank) {
			case 11:
				System.out.println(suit+"-"+rank + " = J of Clubs");
				break;
			case 12:
				System.out.println(suit+"-"+rank + " = Q of Clubs");
				break;
			case 13:
				System.out.println(suit+"-"+rank + " = K of Clubs");
				break;
			default:
				System.out.println(suit+"-"+rank + " is "+ rank +" of Clubs");
				break;
			}
			break;
		case 2:
			switch(rank) {
			case 11:
				System.out.println(suit+"-"+rank + " = J of Diamonds");
				break;
			case 12:
				System.out.println(suit+"-"+rank + " = Q of Diamonds");
				break;
			case 13:
				System.out.println(suit+"-"+rank + " = K of Diamonds");
				break;
			default:
				System.out.println(suit+"-"+rank + " = "+ rank +" of Diamonds");
				break;
			}
			break;
		case 3:
			switch(rank) {
			case 11:
				System.out.println(suit+"-"+rank + " = J of Hearts");
				break;
			case 12:
				System.out.println(suit+"-"+rank + " = Q of Hearts");
				break;
			case 13:
				System.out.println(suit+"-"+rank + " = K of Hearts");
				break;
			default:
				System.out.println(suit+"-"+rank + " = "+ rank +" of Hearts");
				break;
			}
			break;
		case 4:
			switch(rank) {
			case 11:
				System.out.println(suit+"-"+rank + " = J of Speads");
				break;
			case 12:
				System.out.println(suit+"-"+rank + " = Q of Speads");
				break;
			case 13:
				System.out.println(suit+"-"+rank + " = K of Speads");
				break;
			default:
				System.out.println(suit+"-"+rank + " = "+ rank +" of Speads");
				break;
			}
			break;
			}
		}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
