# Create an object f linked to the input.txt file
f = open('input.txt', 'r+', encoding='utf-8')

chars, words, lines, vowels = 0, 0, 0, 0        # Initialise the count variables

for line in f:      # Loop over object f
    chars = chars + len(line)       # Use len to find the number of characters for each line and add it to the char count
    words  = words + len(line.split())      # Use len to find the number of words for each after being split into a list 
    lines += 1      # Increase line count by 1 for each loop
    for char in line:       # Loop through the characters of each line and if they are a vowel i.e. a character in the vowel string then add to vowel count
        if char in 'aeiouAEIOU':
            vowels += 1

# Print the result
print("Number of characters is {}. Number of words is {}. Number of lines is {}. Number of vowels is {} ".format(str(chars), str(words), str(lines), str(vowels)))

f.close()