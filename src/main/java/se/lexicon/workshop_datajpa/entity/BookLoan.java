package se.lexicon.workshop_datajpa.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class BookLoan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;
    @Column
    LocalDate loanDate;
    @Column(length = 10)
    LocalDate dueDate;
    @Column(length = 10)
    boolean returned;
    
    @ManyToOne
    AppUser borrower;
    
    @ManyToOne
    Book book;
    
    public BookLoan() {
        this.loanDate = LocalDate.now();
    }
    
    public BookLoan( int loanId, LocalDate loanDate, LocalDate dueDate, boolean returned, AppUser borrower, Book book ) {
        this();
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }
    
    public BookLoan( LocalDate loanDate, LocalDate dueDate, boolean returned ) {
        this();
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }
    
    public BookLoan( LocalDate loanDate, LocalDate dueDate, AppUser borrower, Book book ) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.borrower = borrower;
        this.book = book;
    }
    
    public int getLoanId() {
        return loanId;
    }
    
    public void setLoanId( int loanId ) {
        this.loanId = loanId;
    }
    
    public LocalDate getLoanDate() {
        return loanDate;
    }
    
    public void setLoanDate( LocalDate loanDate ) {
        this.loanDate = loanDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public void setDueDate( LocalDate dueDate ) {
        this.dueDate = dueDate;
    }
    
    public boolean isReturned() {
        return returned;
    }
    
    public void setReturned( boolean returned ) {
        this.returned = returned;
    }
    
    public AppUser getBorrower() {
        return borrower;
    }
    
    public void setBorrower( AppUser borrower ) {
        this.borrower = borrower;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook( Book book ) {
        this.book = book;
    }
    
    @Override
    public boolean equals( Object o ) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return loanId == bookLoan.loanId && returned == bookLoan.returned && Objects.equals(loanDate, bookLoan.loanDate) && Objects.equals(dueDate, bookLoan.dueDate) && Objects.equals(borrower, bookLoan.borrower) && Objects.equals(book, bookLoan.book);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanDate, dueDate, returned, borrower, book);
    }
    
    @Override
    public String toString() {
        return "BookLoan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", dueDate=" + dueDate +
                ", returned=" + returned +
                ", borrower=" + borrower +
                ", book=" + book +
                '}';
    }
}
