# This example program is meant to demonstrate errors.
 
# There are some errors in this program, try run the program by pressing F5.
# Now look at the error messages and find and fix the errors.

print("Welcome to the error program")       # Print welcome message

print("\n")

ageStr = "24" #I'm 24 years old.        # Create a new string variable
age = int(ageStr)       # Cast the string to integer
    
print("I'm " + ageStr + " years old.")      # Use the string variable to print the relevant result
    
three = "3"

answerYears = age + int(three)      # Create a new integer variable

print("The total number of years: " + str(answerYears))     # Print the years using a casted variable

answerMonths = (answerYears) * 12 + 6

print("In 3 years and 6 months, I'll be " + str(answerMonths) + " months old")

#HINT, 330 months is the correct answer