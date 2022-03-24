""" 
Description: An example programme which models the 
salary dataset using polynomial regression 
"""

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd 
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

# Import the salaries dataset
df = pd.read_csv('/Users/vinceq/Documents/HyperionDev/Data Science, Algorithms and Advanced Software Engineering/Task 23/position_salaries.csv', delimiter=',')
X = df.iloc[:, 1:2].values
Y = df.iloc[:, 2].values

# Print out the variable arrays
print(X)
print(Y)

# Splitting the dataset into the training & test sets
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=0)

# Fitting Linear Regression to the dataset
linear_reg = LinearRegression()
linear_reg.fit(X_train, Y_train)

# Visualising the Linear Regression model
plt.scatter(X, Y, color='blue')
plt.plot(X, linear_reg.predict(X), color='red')
plt.xlabel('Position Level')
plt.ylabel('Salary')

# Fitting Polynomial Regression to the dataset
poly_reg = PolynomialFeatures(degree=4)
X_poly = poly_reg.fit_transform(X_train)
regressor_quadratic = LinearRegression()
regressor_quadratic.fit(X_poly, Y_train)

# Smoothing the Polynomial Regression line by reshaping the input variables
XX = np.arange(min(X), max(X), 0.01)
XX = XX.reshape(len(XX), 1)

# Print out the reshaped array
print(XX)

# Plot the smooth line
plt.plot(XX, regressor_quadratic.predict(poly_reg.fit_transform(XX)), c='green', linestyle='--')

plt.grid(True)
plt.show()