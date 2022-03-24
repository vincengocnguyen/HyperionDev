word = input("Please input a string: ")     # Read a string

result = ''     # Initiate an empty string

# Create a loop to extract characters from the string and transform them to uppercase and lowercase appropriately

# Add these chracters to the empty string

for i in range(0, len(word)):
    if i % 2 == 0:
        result = result + word[i].lower()       
    else:
        result = result + word[i].upper()

# Print the result string
print(result)