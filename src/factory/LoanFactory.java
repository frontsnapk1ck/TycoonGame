package factory;

import java.util.List;

import player.Loan;

public class LoanFactory {

    private List<Loan> stockLoans;
    private List<Loan> ownedLoans;

    public void loadStock(String filename) 
    {
        List<String> stockData = FileReader.readTextFile(filename);
        loadStockLoans (stockData);
	}

    private void loadStockLoans(List<String> stockData) 
    {
        if (stockData.size() == 0)
            return;
        for (String loan : stockData)
            loadStockLoan (loan);
    }

    private void loadStockLoan(String loan) 
    {
        String[] slices = loan.split("\\|");

        double initAmount = Double.parseDouble(slices[0]);
        int time = Integer.parseInt(slices[1]);
        double rate = Double.parseDouble(slices[2]);

        Loan l = new Loan(initAmount, time, rate);
        this.stockLoans.add(l);
    }

    
    public void loadOwned(String filename) 
    {
        List<String> ownedData = FileReader.readTextFile(filename);
        loadOwnedLoans(ownedData);
	}

    private void loadOwnedLoans(List<String> ownedData) 
    {
        if (ownedData == null || ownedData.size() == 0)
            return;
        for (String loan : ownedData)
            loadOwnedLoan(loan);
    }

    private void loadOwnedLoan(String loan) 
    {
        String[] slices = loan.split("\\|");

        double initAmount = Double.parseDouble(slices[0]);
        int time = Integer.parseInt(slices[1]);
        double rate = Double.parseDouble(slices[2]);
        double current = Double.parseDouble(slices[3]);

        Loan l = new Loan(initAmount, time, rate);
        l.setCurrent(current);
        this.stockLoans.add(l);
    }

    public List<Loan> getStock() 
    {
		return this.stockLoans;
	}

    public List<Loan> getLoans() 
    {
		return this.ownedLoans;
	}

}