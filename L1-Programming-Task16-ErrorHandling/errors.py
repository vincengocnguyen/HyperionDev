# This example program is meant to demonstrate errors.
 
# There are some errors in this program, try run the program by pressing F5.
# Now look at the error messages and find and fix the errors.

# print "Welcome to the error program" >> Syntax error (missing parentheses)
print("Welcome to the error program")       # Print welcome message

#    print "\n" >> Syntax error (incorrect indentation)
print("\n")

#    ageStr == "24 years old" #I'm 24 years old. >> Syntax error (incorrect indentation & used == instead of = to assign a value to a variable)
#    age = int(ageStr) >> Syntax error (incorrect indentation)
#    print("I'm"+age+"years old.") >> Runtime error (adding an int variable to a string, use the string ageStr instead)
#    three = "3" >> Syntax error (incorrect indentation)

#    answerYears = age + three >> Logical error (this would add the int age variable with the string three)

ageStr = "24"   #I'm 24 years old.        # Create a new string variable
age = int(ageStr)       # Cast the string to integer
    
print("I'm " + ageStr + " years old.")      # Use the string variable to print the relevant result
    
three = 3

answerYears = age + three    # Create a new integer variable

# print "The total number of years:" + "answerYears" >> Syntax error (missing parentheses and wrong double quotes used for answerYears)
print("The total number of years: " + str(answerYears))     # Print the years using a casted variable

# answerMonths = answer*12 >> Runtime error (answer variable does not exist) & logical error (wrong calculation used)
answerMonths = (answerYears) * 12 + 6

# print "In 3 years and 6 months, I'll be " + answerMonths + " months old" >> Syntax error (missing parentheses) & runtime error (answerMonths needs to be casted to str)
print("In 3 years and 6 months, I'll be " + str(answerMonths) + " months old")

#HINT, 330 months is the correct answer

