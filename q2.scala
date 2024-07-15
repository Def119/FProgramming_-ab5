import scala.io.StdIn._

case class Book(title: String, author: String, isbn: String)

var bookCollection: Set[Book] = Set(
Book("asdasdsd", "sad", "1213"),
Book("AAAAAAA", "SSSDDDD", "9782"),
Book("asdsa", "sad", "123")
)

def addBook(book: Book): Unit = {
if (bookCollection.exists(_.isbn == book.isbn)) {
    println(s"Book with ISBN '${book.isbn}' already exists in the collection.")
} else {
    bookCollection += book
    println(s"Book '${book.title}' by ${book.author} added to the collection.")
}
}

def removeBook(isbn: String): Unit = {
val bookOpt = bookCollection.find(_.isbn == isbn)
bookOpt match {
    case Some(book) =>
    bookCollection -= book
    println(s"Book '${book.title}' by ${book.author} removed from the collection.")
    case None =>
    println(s"No book found with ISBN $isbn.")
}
}

def checkBook(isbn: String): Boolean = {
bookCollection.exists(_.isbn == isbn)
}

def displayBooks(): Unit = {
if (bookCollection.isEmpty) {
    println("No books in the collection.")
} else {
    println("Books in the collection:")
    bookCollection.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
}
}

def searchBookByTitle(title: String): Unit = {
val books = bookCollection.filter(_.title.equalsIgnoreCase(title))
if (books.isEmpty) {
    println(s"No book found with title '$title'.")
} else {
    books.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
}
}

def displayBooksByAuthor(author: String): Unit = {
val books = bookCollection.filter(_.author.equalsIgnoreCase(author))
if (books.isEmpty) {
    println(s"No books found by author '$author'.")
} else {
    println(s"Books by $author:")
    books.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
}
}

@main def main(args: Array[String]): Unit = {
var continue = true
while (continue) {
    println("\nLibrary Management System")
    println("1. Add a book")
    println("2. Remove a book")
    println("3. Check if a book is in the library")
    println("4. Display all books")
    println("5. Search for a book by title")
    println("6. Display all books by a specific author")
    println("7. Exit")
    print("Choose an option: ")
    val choice = readInt()

    choice match {
    case 1 =>
        print("Enter book title: ")
        val title = readLine()
        print("Enter book author: ")
        val author = readLine()
        print("Enter book ISBN: ")
        val isbn = readLine()
        addBook(Book(title, author, isbn))
    case 2 =>
        print("Enter ISBN of the book to remove: ")
        val isbn = readLine()
        removeBook(isbn)
    case 3 =>
        print("Enter ISBN of the book to check: ")
        val isbn = readLine()
        if (checkBook(isbn)) {
        println(s"Book with ISBN '$isbn' is in the library.")
        } else {
        println(s"No book found with ISBN '$isbn'.")
        }
    case 4 =>
        displayBooks()
    case 5 =>
        print("Enter book title to search: ")
        val title = readLine()
        searchBookByTitle(title)
    case 6 =>
        print("Enter author name to search: ")
        val author = readLine()
        displayBooksByAuthor(author)
    case 7 =>
        continue = false
    case _ =>
        println("Invalid option. Please try again.")
    }
}
}

