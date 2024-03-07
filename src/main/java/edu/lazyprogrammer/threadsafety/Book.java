package edu.lazyprogrammer.threadsafety;
//Final Calss
public final class Book {
    //Private Final Fields
    private final String author;
    private final String title;
    //Constructor
    public Book(String author, String title){
        this.author=author;
        this.title=title;
    }
    //Getters
    public String getAuthor(){
        return this.author;
    }
    public String getTitle(){
        return this.title;
    }
    //Modified Title
    public Book bookWithNewTitle(String title){
        return new Book(this.author, title);
    }
    //Modified Author
    public Book bookWithNewAuthor(String author){
        return new Book(author, this.title);
    }
    //Override toString
    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", title=" + title + ", "
                + "hashCode="+this.hashCode()+"}";
    }
}
