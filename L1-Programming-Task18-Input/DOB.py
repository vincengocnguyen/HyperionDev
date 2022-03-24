# Create an object f linked to the DOB.txt file
f = open('DOB.txt', 'r+', encoding='utf-8')

# Initiate 2 strings for the Name and Birthdate sections
name = 'Name\n'

birthdate = 'Birthdate\n'

for line in f:      # Loop over object f 
    for i in range(0, len(line)):
        if line[i].isdigit():       # Find the first digit of the line - which signifies the beginning of the birth date part - then break
            break
    name = name + line[0:i] +'\n'       # Add the name part of the line to the name string variable
    birthdate =  birthdate + line[(i - 1):len(line)].strip() +'\n'      # Add the birthdate part of the line to the birthdate string variable

print(name + "\n" + birthdate)

f.close()