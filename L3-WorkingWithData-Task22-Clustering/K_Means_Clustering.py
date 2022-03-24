import os 
import random
import matplotlib.pyplot as plt     # For plots to be generated
import numpy as np      # For data wrangling
import pandas as pd     # For reading data
import seaborn as sns   # For data visualisation

def distance(item, mean):
  # Euclidean distance from a data item to a mean
  sum = 0.0
  dim = len(item)
  for j in range(dim):
    sum += (item[j] - mean[j]) ** 2
  return np.sqrt(sum)

def update_clustering(norm_data, clustering, means):
  # given a (new) set of means, assign new clustering
  # return False if no change or bad clustering
  n = len(norm_data)
  k = len(means)

  new_clustering = np.copy(clustering)  # proposed new clustering
  distances = np.zeros(shape=(k), dtype=np.float32)  # from item to each mean

  for i in range(n):  # walk thru each data item
    for kk in range(k):
      distances[kk] = distance(norm_data[i], means[kk])  
    new_id = np.argmin(distances)
    new_clustering[i] = new_id
  
  if np.array_equal(clustering, new_clustering):  # no change so done
    return False

  # make sure that no cluster counts have gone to zero
  counts = np.zeros(shape=(k), dtype=np.int)
  for i in range(n):
    c_id = clustering[i]
    counts[c_id] += 1
  
  for kk in range(k):  # could use np.count_nonzero
    if counts[kk] == 0:  # bad clustering
      return False

  # there was a change, and no counts have gone 0
  for i in range(n):
   clustering[i] = new_clustering[i]  # update by ref
  return True

def update_means(norm_data, clustering, means):
  # given a (new) clustering, compute new means
  # assumes update_clustering has just been called
  # to guarantee no 0-count clusters
  (n, dim) = norm_data.shape
  total_distance = []

  k = len(means)
  counts = np.zeros(shape=(k), dtype=np.int)
  new_means = np.zeros(shape=means.shape, dtype=np.float32)  # k x dim
  for i in range(n):  # walk thru each data item
    c_id = clustering[i]
    counts[c_id] += 1
    for j in range(dim):
      new_means[c_id,j] += norm_data[i,j]  # accumulate sum

  for kk in range(k):  # each mean
    for j in range(dim):
      new_means[kk,j] /= counts[kk]  # assumes not zero

  # print the sum of squared means as a sanity check
  sanity_check = distance(means, new_means)
  print(sanity_check[0])
  print(sanity_check[1])

  for i in range(n):  # walk thru each data item
    total_distance.append(distance(norm_data[i], new_means[clustering[i]]))
  
  print("Sum of distances between each point & the centroid to which it belongs = " + str(sum(total_distance)))
    
  for kk in range(k):  # each mean
    for j in range(dim):
      means[kk,j] = new_means[kk,j]  # update by ref

def initialize(norm_data, k):
  (n, dim) = norm_data.shape
  clustering = np.zeros(shape=(n), dtype=np.int)  # index = item, val = cluster ID
  for i in range(k):
    clustering[i] = i
  for i in range(k, n):
    clustering[i] = np.random.randint(0, k) 

  means = np.zeros(shape=(k,dim), dtype=np.float32)
  update_means(norm_data, clustering, means)
  return(clustering, means) 
  
def cluster(norm_data, k, iter):
  (clustering, means) = initialize(norm_data, k)

  ok = True  # if a change was made and no bad clustering
  max_iter = iter
  sanity_ct = 1
  while sanity_ct <= max_iter:
    ok = update_clustering(norm_data, clustering, means)  # use new means
    if ok == False:
      break  # done
    update_means(norm_data, clustering, means)  # use new clustering
    sanity_ct += 1

  return clustering

def means(norm_data, k, iter):
  (clustering, means) = initialize(norm_data, k)

  ok = True  # if a change was made and no bad clustering
  max_iter = iter
  sanity_ct = 1

  while sanity_ct <= max_iter:
    ok = update_clustering(norm_data, clustering, means)  # use new means
    if ok == False:
      break  # done
    update_means(norm_data, clustering, means)  # use new clustering 
  
  return means

def display(data, clustering, k):
  data_groups = data[['Country', 'Clusters']].groupby('Clusters')
  count_groups = data[['Country', 'Clusters']].groupby('Clusters').count()
  birth_group = data[['Birth Rate', 'Clusters']].groupby('Clusters')
  birth_avg = birth_group.mean()
  life_group = data[['Life Expectancy', 'Clusters']].groupby('Clusters')
  life_avg = life_group.mean()
    
  for key, items in data_groups:
    print(items.to_string())
  
  print(count_groups)
  print(birth_avg)
  print(life_avg)


def main():
  # get user input for the number of clusters
  k = int(input("Please enter the number of clusters you want: "))
  iter = int(input("Please enter the number of maxmium iterations: "))

  # get user input for the data file to open (data1953, data2008 or dataBoth)
  filename = input("Please enter the name of the file you would like to open (data1953, data2008 or dataBoth): ") + ".csv"
  filepath = "/Users/vinceq/Documents/HyperionDev/Data Science, Algorithms and Advanced Software Engineering/Task 22/"
  
  # store the data in a data frame
  data = pd.read_csv(os.path.join(filepath, filename), delimiter=',')
  
  # rename the columns of the data frame
  data.columns = ['Country', 'Birth Rate', 'Life Expectancy']

  # store the clustering data in a numpy array
  birth, life = data['Birth Rate'], data['Life Expectancy']
  cluster_data = np.array(list(zip(birth, life)))

  
  # call the clustering method with required arguments
  # it should return the data grouped by cluster
  cluster_groups = cluster(cluster_data, k, iter)

  means_data = means(cluster_data, k, iter)
  print(means_data)

  # add the clustered data to a new column in the dataframe
  data['Clusters'] = cluster_groups

  data_grouped = data[['Country', 'Clusters']].groupby('Clusters')
    
  # call the display method and pass required values from main function to the display function
  display(data, cluster_groups, k)

  # display the final dataframe
  print(data)

  # plot the data with seaborn
  plot = sns.scatterplot(data=data, x='Birth Rate', y='Life Expectancy', hue='Clusters', style='Clusters', legend=False)
  plt.scatter(means_data[:,0], means_data[:,1], marker='*', s=150, c='red')
  plt.show(plot)


if __name__ == "__main__":
  main()