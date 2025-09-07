books = [
	{"title": "George Of The Jungle", "status": "available"},
	{"title": "How To Be Rich In Millions", "status": "available"},
	{"title": "Ikka Lobinrin", "status": "available"},
	{"title": "Alakada", "status": "available"},
	{"title": "Ayebaje Omo ole n daajo", "status": "available"},
	{"title": "Igi Aloye", "status": "available"},
	{"title": "The King's Monkey", "status": "available"},
	{"title": "Onirese", "status": "available"},
]

def view_books() :
	print("Available books are")
	for index, book in enumerate(books, start=1):
		print(f"{index}. {book['title']} ({book['status']})")


def borrow_a_book(number) :
	index = number - 1
	if 0 <= index < len(books) :
		if books[index]["status"] == "available" :
			books[index]["status"] = "borrowed"
			print(f'You borrowed "{books[index]["title"]}"')
		else :
			print(f'Sorry, "{books[index]["title"]}" is already borrowed.')
	else :
		print("That option nur dey.")


def return_a_book(number) :
	index = number - 1
	if 0 <= index < len(books) :
		if books[index]["status"] == "borrowed" : 
			books[index]["status"] = "available"
			print(f'You returned "{books[index]["title"]}"')
		else :
			print(f'"{books[index]["title"]}" is now available')
	else :
		print("That option nur dey")


def main_menu() :
	answer = 0
	while answer != 4 :
		print("WELCOME TO EGELEGE LIBRARY APP")
		print("""
			1 -> View All Available Books
			2 -> Borrow A Book
			3 -> Return A Book
			4 -> Exist
		""")
		try :
			answer = int(input("Enter number to choose an option and 4 to exit:   "))
		except ValueError :
			print("Option nur dey")
			continue

		if answer == 1 :
			view_books()
		elif answer == 2 :
			try :
				user_answer_one = int(input("Borrow A Book:   "))
				borrow_a_book(user_answer_one)
			except ValueError :
				print("Invalid input")
		elif answer == 3 :
			try :
				user_answer_two = int(input("Return Book Wey you Borrow:   "))
				return_a_book(user_answer_two)
			except ValueError :
				print("Invalid input")
		elif answer == 4 :
			print("Thanks for using the app!!")
		else :
			print("Option nur dey")


main_menu()
