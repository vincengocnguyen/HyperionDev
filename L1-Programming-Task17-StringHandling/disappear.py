# Input a string
string = input("Please enter a string: ")

# Input the characters using a string
chars = input("Please enter the characters you'd like to make disappear, separated by spaces e.g. 'a e i o u': ")

# Remove the spaces
list_chars = chars.replace(' ', '')

# Create a loop to remove the characters from the string
for i in range(0, len(list_chars)):
    string = string.replace(list_chars[i], '')

# Print the result
print(string)