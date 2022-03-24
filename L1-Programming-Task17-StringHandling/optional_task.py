# Input a string
string = input("Please enter a string: ")

# Check if the string is the same as its reverse and print relevant messages
if string == string[::-1]:
    print("Your word is a palindrome")
else:
    print("Your word is not a palindrome")