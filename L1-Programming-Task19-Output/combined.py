ofile = open('all_numbers.txt', 'w')        # Open the output file in write mote

# Initialise list variables and add the numbers read from the files to them
list1 = []      
list1 = open('numbers1.txt', 'r+', encoding='utf-8').read().splitlines()

list2 = []
list2 = open('numbers2.txt', 'r+', encoding='utf-8').read().splitlines()

# Create a merged list and sort it
merged_list = list1 + list2
merged_list = [int(x) for x in merged_list]
sorted_list = sorted(merged_list)

# Write out the sorted merged list as a string with linebreak
ofile.write('\n'.join(str(y) for y in sorted_list) + '\n')

# Close files
ofile.close()