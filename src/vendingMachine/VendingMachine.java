package vendingMachine;

import java.util.Scanner;

import payment.Card;
import payment.Coin;
import payment.Note;


public interface VendingMachine {
void getInput(Scanner scanner);
void onCancelPress();
void acceptMoney(Coin Coin);
void acceptMoney(Note note);
void acceptMoney(Card card);

}
