# Ask for number of students and store into a variable
number = int(input("How many students are registering? "))

# Open the file
f = open("reg_form.txt", "w")

# Create a loop to ask for the IDs
for i in range(0, number):
    print("Please enter student ID #{}: ".format(str(i+1)))
    f.write(input()+"\n") 

# Close the file
f.close()