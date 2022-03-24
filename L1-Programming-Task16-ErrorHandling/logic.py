print("This is a compilation error")      # Compilation error 1: missing brackets

error = "Indent Error"      #  Compilation error 2: incorrect indentation

number1 = 1917
print(error + str(number1))       # Runtime error: number1 variable needs to be casted into string before being combined with another string

number2 = 1917
print("The average of number1 and number2 is: " + str(number1+number2/2))       # Logical error: missing parentheses cause the programme to miscalculate the average of 2 numbers