const prompt = require ("prompt-sync")();

let books = [
  { title: "George Of The Jungle",
	 status: "available" },
  { title: "How To Be Rich In Millions", 
	status: "available" },
  { title: "Ikka Lobinrin", 
	status: "available" },
  { title: "Alakada", 
	status: "available" },
 { title: "Ayebaje Omo ole n daajo", 
	status: "available" },
 { title: "Igi Aloye", 
	status: "available" },
 { title: "The King's Monkey", 
	status: "available" },
 { title: "Onirese", 
	status: "available" }

];
function viewBooks() {
	console.log("Avaliable books are");
	books.forEach((book, index) => {
    console.log(`${index + 1}. ${book.title} (${book.status})`);
  });
}

function borrowABook(number) {
	let index = number - 1;
	if (index >= 0 && index < books.length) {
	if (books[index].status === "available") {
		books[index].status = "borrowed";
		console.log(`You borrowed "${books[index].title}"`);
	} else {
		console.log(`Sorry, "${books[index].title}" is already borrowed.`);
	}
	} else {
		console.log("That option nur dey.");
	}
}


function returnABook(number) {
	let index = number - 1;
	if(index >=0 && index < books.length) {
	if(books[index].status === "borrowed") {
		books[index].status = "available";
		console.log(`You returned "${books[index].title}"`);
	} else{
		console.log(`"${books[index]}.title" is now available`);
	}
	}else{
		console.log("That option nur dey")
	}
}


function MainMenu(){
	let answer;
	do {
	console.log("WELCOME TO EGELEGE LIBRARY APP");
	console.log(`
			1 -> View All Available Books
			2 -> Borrow A Book
			3 -> Return A book
			4 -> Exist
`)
answer = parseInt(prompt("Enter number to choose an option and 4 to exist:   "));
switch(answer) {
		case 1 :  viewBooks(); break;
		case 2 : 
			let userAnswerOne = parseInt(prompt("Borrow A Book:   "));
			borrowABook( userAnswerOne); break;
		case 3 : 
			let userAnswerTwo = parseInt(prompt("Return Book Wey you Borrow:   "));	
			returnABook(userAnswerTwo); break;
		default : console.log("Option nur dey");

} 
}while(answer !== 4) {
	console.log("Thanks for using the app!!");
}
}

MainMenu();