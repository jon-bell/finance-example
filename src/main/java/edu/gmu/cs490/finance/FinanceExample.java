package edu.gmu.cs490.finance;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class FinanceExample {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (true) {
			YahooFinance.logger.setLevel(Level.OFF);
			String query = s.nextLine();
			if (query.equals("exit"))
				break;
			Stock stock = YahooFinance.get(query);

			BigDecimal price = stock.getQuote().getPrice();
			BigDecimal change = stock.getQuote().getChangeInPercent();
			BigDecimal peg = stock.getStats().getPeg();
			BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

			stock.print();

			System.out.println(stock.getHistory());
		}
		s.close();
	}
}
