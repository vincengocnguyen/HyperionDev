def load_task():
    # create an empty dictionary variable to store indexes to tasks
    task_indexes = {}
    # create an empty list to store task details
    task_list = []

    index = 0

    with open("tasks.txt", "r") as tasks_file_load:
        for line in tasks_file_load:
            if task_list == []:
                task_list = line.split(',')
                task_indexes[index] = task_list
                index += 1
                task_list = []
    
    return task_indexes

print(load_task())