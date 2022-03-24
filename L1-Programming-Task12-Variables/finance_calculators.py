# This is a programe that allows the user to access two different financial calculators: an investment calculator and a home loan repayment calculator
# Author: Vince Nguyen

import math

# Print the instruction
print('''Choose either 'invesment' or 'bond' from the menu below to proceed:
investment\t - to calculate the amount of interest you'll earn on interest
bond\t\t - to calculate the amount you'll have to pay on a home loan''')

# Convert the input to all lowercase
menu = input().lower()

# Investment option
if menu == 'investment':
    deposit = float(input('Please enter the amount of deposit: '))      # Ask for amount of deposit
    rate = float(input('Please enter the interest rate as a percentage: '))     # Ask for the interest rate
    years = float(input('Please enter the number of years you plan on investing for: '))        # Ask for the number of years
    interest = input("Which type of interest would you like to calculate? 'simple' or 'compound'? ").lower() # Ask for the type of interest

    if interest == 'simple':
        interest_value = deposit * (1 + rate / 100 * years) - deposit       # Calculate simple interest
    elif interest == 'compound':
        interest_value = deposit * ((1 + rate / 100) ** years) - deposit        # Calculate compound interest

    print("The amount of {} interest you'll earn is {}.".format(interest, str(interest_value)))     # Display the interest value
elif menu == 'bond':
    present_value = float(input('Please enter the present value of the house: '))       # Ask for PV
    rate = float(input('Please enter the interest rate: '))     # Ask for the interest rate
    months = int(input('Please enter the number of months you plan to repay the bond: '))     # Ask for number of months

    r = rate / (12 * 100) # Calculate monthly rate
    repayment = present_value * ((r * ((1 + r) ** months))/(((1 + r) ** months) -1))      # Calculate monthly repayment
    
    print("The amount you will have to repay each month is {}.".format(str(repayment)))     # Display the repayment
else:
    print("Please enter a valid menu option")       # Error message for menu options

# ****************** END OF PROGRAMME ********************* # 