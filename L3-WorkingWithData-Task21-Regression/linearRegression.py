import matplotlib.pyplot as plt
import numpy as np
from sklearn.datasets import load_diabetes
from sklearn import linear_model

d = load_diabetes()
d_X = d.data[:, np.newaxis, 2]
dx_train = np.squeeze(d_X[:-20])
dy_train = d.target[:-20]
dx_test = d_X[-20:]
dy_test = d.target[-20:]

m = (np.mean(dx_train) * np.mean(dy_train) - np.mean(np.multiply(dx_train, dy_train))) / ((np.mean(dx_train))**2 - np.mean(np.square(dx_train)))
b = np.mean(dy_train) - m * np.mean(dx_train)


plt.scatter(dx_test, dy_test, c='r', label = 'Test data')
plt.scatter(dx_train, dy_train, c='g', label = 'Training data')
plt.plot(dx_train, (m * dx_train + b), c='b', label = 'Best fit line')
plt.legend()
plt.show()