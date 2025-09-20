fun main() {
    while (true) {
        println("\uD83D\uDCDAWelcome to Pluto Book Manager! What would you like to do?\uD83D\uDCDA")
        println("1- Add Books")
        println("2- Remove Books")
        println("3- Search by Title")
        println("4- Search by Author")
        println("5- Show Saved Books")
        println("6- Exit")
        print("Selected : ")
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> addBook()
            2 -> removeBook()
            3 -> searchByTitle()
            4 -> searchByAuthor()
            5 -> showBook()
            6 -> return
            else -> println("Invalid Option! Try again.")
        }

    }

}

data class Books(var name: String, var author: String, var num: Int)
object ListBook {
    var count = 1
    val listBook = arrayListOf<Books>()
}

fun addBook() {

    do {
        print("Enter book's title : ")
        val name = readln()
        print("Enter book's author : ")
        val author = readln()
        print("Enter book's ISBN : ")
        val num = readln().toInt()
        ListBook.listBook.add(Books(name, author, num))
        println("Book successfully added!")
        print("Add more books? (y/n) : ")
        val results = readln()
    } while (results == "y")

}

fun removeBook() {
    println("Enter book's number to delete : ")
    ListBook.count = 1
    for (item in ListBook.listBook) {
        print("${ListBook.count} - Book's title : ${item.name} | Book's author: ${item.author} | Book's ISBN : ${item.num} \n")
        ListBook.count++
    }
    try {
        val numrem = readln().toInt()
        ListBook.listBook.removeAt(numrem - 1)
    } catch (e: IndexOutOfBoundsException) {
        println("Enter the number correctly!")
    }
}

fun searchByTitle() {
    print("Enter book's title : ")
    val enteredTitle = readln()
    val searchres = ListBook.listBook.filter { it.name == enteredTitle }
    if (searchres.isNotEmpty()){
        println("Found ${searchres.size} book(s) : ")
    for (item in searchres){
        print("${searchres.size} - Book's title : ${item.name} | Book's author: ${item.author} | Book's ISBN : ${item.num} \n")
    }
    }else{
        println("No books found with entered title : '$enteredTitle' ")
    }
}

fun searchByAuthor() {
    print("Enter book's author : ")
    val enteredAuthor = readln()
    val searchres = ListBook.listBook.filter { it.author == enteredAuthor }
    if (searchres.isNotEmpty()){
        println("Found ${searchres.size} book(s) : ")
        for (item in searchres){
            print("${searchres.size} - Book's title : ${item.name} | Book's author: ${item.author} | Book's ISBN : ${item.num} \n")
        }
    }else{
        println("No books found with entered author : '$enteredAuthor' ")
    }
}

fun showBook() {
    ListBook.count = 1
    for (item in ListBook.listBook) {
        print("${ListBook.count} - Book's title : ${item.name} | Book's author: ${item.author} | Book's ISBN : ${item.num} \n")
        ListBook.count++
    }
}


