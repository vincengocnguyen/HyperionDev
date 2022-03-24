# Case 1
> A real estate agent is in charge of assigning prices to empty
plots in new development. The estate agent has some examples from a
very similar development nearby and identifies that the cost of a
property should be dependent on the size of the plot of land the
property is on. They wish to create a model to represent this to predict
the price of the new plots.

**Linear regression** is more suited in this case. 
The explanatory variable is 'size of the plot of land the property is on' (continous). 

# Case 2
> A programmer is developing a spam detector. They notice that
spam emails often have the words “prize” or “win” in them, as well as the
presence of spelling errors. They wish to create a model to predict
whether or not an email is indeed spam or not.

**Logistic regression** is more suited in this case. 

The explanatory variables are:
* the number of times the word "win" or "prize" in the email (discrete)
* the number of spelling errors (discrete)

# Case 3
> A researcher is investigating how long after its expiry date a
particular brand of milk tends to actually go off. For their research they
assume that this transition is sudden. They test samples of some of the
milk at regular time intervals to determine the status of the milk as
sour/not sour and use this data to develop a model.

**Logistic regression** is more suited in this case to predict the probabability of the milk turning sour at a particular time after the expiry date.

The explanatory variables are:
* the amount of time after the expiry date

