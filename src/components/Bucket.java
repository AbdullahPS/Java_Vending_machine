package components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import payment.Coin;
import payment.Note;

import java.util.TreeMap;

public class Bucket {


	private TreeMap<Coin,Integer> machineCoins=new TreeMap<Coin, Integer>(Collections.reverseOrder());
	private TreeMap<Note,Integer> machineNotes =new TreeMap<Note, Integer>(Collections.reverseOrder());
	private ArrayList<Note> currentNotes =new ArrayList<Note>();
	private ArrayList<Coin> currentCoins=new ArrayList<Coin>();

	public Bucket(){
		  fillCoins();
		  fillNotes();
	}
	public void clearBucket() {
		currentNotes.clear();
		currentCoins.clear();
	}
	private void fillCoins() {
			machineCoins.put(Coin.TenCent,10 );
			machineCoins.put(Coin.TwentyCent, 10);
			machineCoins.put(Coin.FiftyCent, 10);
			machineCoins.put(Coin.OneDollar, 10);
	 }
	private void fillNotes() {
			machineNotes.put(Note.TwentyDollar, 5);
			machineNotes.put(Note.FiftyDollar, 5);
	 }
	public double getCurrentAmount() {
		double currentAmount=0;
	

		for (int i=0;i<currentNotes.size();i++) {
			currentAmount+=currentNotes.get(i).getValue();
			
		}
		for (int i=0;i<currentCoins.size();i++) {
			currentAmount+=currentCoins.get(i).getValue();
			
		}
		return currentAmount;
	}
	
	
	public void getPossibleCombinations(double change) {
		
		//we assume that the bucket of the vendor is always filled and that 
		//it will always give the least amount of notes
		Map <Note,Integer >noteQuantities= new HashMap<Note,Integer>();
		Map <Coin,Integer >coinQuantities= new HashMap<Coin,Integer>();

		for (Entry<Note, Integer> entry : machineNotes.entrySet()) {
			Note note=entry.getKey();
			int amount = (int) (change/note.getValue());
			noteQuantities.put(note,amount);
			change=change-noteQuantities.get(note)*note.getValue();
		}
		for (Entry<Coin, Integer> entry : machineCoins.entrySet()) {
			Coin coin=entry.getKey();
			int amount = (int) (change/coin.getValue());
			coinQuantities.put(coin,amount);
			change=change-coinQuantities.get(coin)*coin.getValue();
		}
		
		withDraw(noteQuantities,coinQuantities);

	}

		
	
	private void giveCoin(Coin coin) {
		int currentAmount=machineCoins.get(coin);
		machineCoins.put(coin,currentAmount-1);
	}
	public void giveNote(Note note) {
		int currentAmount=machineNotes.get(note);
		machineNotes.put(note,currentAmount-1);
	}
	
	public void insertCoin(Coin coin) {
		int currentAmount=machineCoins.get(coin);
		machineCoins.put(coin,currentAmount+1);
	}
	public void insertCurrentCoin(Coin coin) {

		currentCoins.add(coin);


	}
	
	
	public void insertCurrentNote(Note note) {
		currentNotes.add(note);


	}
	
	public void insertNote(Note note) {
		int currentAmount=machineNotes.get(note);
		machineNotes.put(note,currentAmount+1);


	}
	 public void insertPurchaseMoney() {
		System.out.println("Coins before inserting were: "+machineCoins);
		System.out.println("Notes before inserting were: "+machineNotes);
	for(int i=0;i<currentNotes.size();i++) {
		insertNote(currentNotes.get(i));
	}	
	for(int i=0;i<currentCoins.size();i++) {
		insertCoin(currentCoins.get(i));
	}
	clearBucket();
	System.out.println("Coins after inserting were: "+machineCoins);
	System.out.println("Notes after inserting were: "+machineNotes);
		
	}
	 private void withDraw(Map <Note,Integer >noteQuantities,Map <Coin,Integer >coinQuantities){
		 System.out.println("Coins before giving user change were: "+machineCoins);
		 System.out.println("Notes before giving user change: "+machineNotes);
		for (Entry<Coin, Integer> entry : coinQuantities.entrySet()) {
			Coin coin=entry.getKey();
			int amount=entry.getValue();
			if(amount>0)
				for(int i=0;i<amount;i++)
				giveCoin(coin);
		}
		for (Entry<Note, Integer> entry : noteQuantities.entrySet()) {
			Note note=entry.getKey();
			int amount=entry.getValue();
			if(amount>0)
				for(int i=0;i<amount;i++)
				giveNote(note);
		}
		 System.out.println("Coins after giving user change were: "+machineCoins);
		 System.out.println("Notes after giving user change: "+machineNotes);
		}
}
