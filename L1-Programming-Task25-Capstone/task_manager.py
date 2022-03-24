import datetime

# Function to load the tasks.txt data into a dict with the key as index number
def load_task():
    # create an empty dictionary variable to store indexes to tasks
    task_indexes = {}
    # create an empty list to store task details
    task_list = []

    index = 0

    # loop through the files, store each line in a list - which is then added as an a value to the index dict
    with open("tasks.txt", "r") as tasks_file_load:
        for line in tasks_file_load:
            if task_list == []:
                task_list = line.split(',')
                task_indexes[index] = task_list
                index += 1
                task_list = []
    
    return task_indexes

# Load the file into the dict when the programme starts
task_indexes = load_task()

# Register user: Ask for new username, password & password confirmation then write to user.txt 
def reg_user():
    new_username = input("\nPlease enter a new username: \n")
    while new_username in user_password:
        new_username = input("\nUsername already exists. Please enter a new username: \n")
    new_password = input("\nPlease enter a new password: \n")
    password_check = input("\nPlease confirm your password: \n")

    while password_check != new_password:       # Check if the password is enter correctly
        password_check = input("\nIncorrect. Please confirm your password: \n")

    with open("user.txt", "a") as user_file:        # Write out to the user file
        user_file.write(new_username + ',' + new_password + "\n")

def add_task():
    task_list = []
    task_list.append(input("\nPlease enter the username of the person the task is assigned to: \n"))
    task_list.append(input("\nPlease enter the title of the task: \n"))
    task_list.append(input("\nPlease enter the the description of the task: \n"))
    task_list.append(str(datetime.date.today()))
    task_list.append(input("\nPlease enter the due date of the task (yyyy-mm-dd): \n"))
    task_list.append('No\n')
    with open("tasks.txt", "a+") as tasks_file_add:
       tasks_file_add.write('\n'+ ', '.join(str(i) for i in task_list)) 
    task_indexes = load_task()      # Load the file into the task dict again after a new task is written out to the file

def view_all():
    for task_list_print in task_indexes.values():
        print("Task:\t" + task_list_print[1])
        print("Assigned to:\t" + task_list_print[0])
        print("Task description:\t" + task_list_print[2])
        print("Date assigned:\t" + task_list_print[3])
        print("Due date:\t" + task_list_print[4])
        print("Task complete?\t" + task_list_print[5])

def view_mine(username):
    user_task_index = []
    
    for index in task_indexes.keys():
        if username == task_indexes[index][0]:
                print("Task ID: " + str(index))
                print("Task:\t" + task_indexes[index][1])
                print("Assigned to:\t" + task_indexes[index][0])
                print("Task description:\t" + task_indexes[index][2])
                print("Date assigned:\t" + task_indexes[index][3])
                print("Due date:\t" + task_indexes[index][4])
                print("Task complete?\t" + task_indexes[index][5])

    task_menu_index = int(input("Which task ID would you like to edit? Or enter '-1' to return to the menu \n"))

    if task_menu_index in user_task_index:
        task_menu_input = input("What would you like to do with your tasks?\n\ta - Mark the task as complete\n\tb - Edit the task\n")
        while task_menu_input not in ['a', 'b']:
            task_menu_input = input("What would you like to do with your tasks?\n\ta - Mark the task as complete\n\tb - Edit the task\n")
        
        if task_menu_input == 'a':
            task_indexes[task_menu_index][5] = 'Yes\n'
            rewrite_file()
        
        elif task_menu_input == 'b' and task_indexes[task_menu_index][5] == 'No\n':
            task_indexes[task_menu_index] = edit_task(task_indexes[task_menu_index])
            rewrite_file()

    elif task_menu_index == -1:
        menu(username)

def edit_task(list):
    edit_option = input("What would you like to edit?\n\ta - User assigned\n\tb - Due date\n")
    
    while edit_option not in ['a', 'b']:
        edit_option = input("What would you like to edit?\n\ta - User assigned\n\tb - Due date\n")

    if edit_option == 'a':
        updated_username = input("Who should this task be assigned to? \n")
        list[0] = updated_username
        print("The task is now assigned to " + list[0])
    elif edit_option == 'b':
        new_due_date = input("Enter the new due date (yyyy-mm-dd) for the task: ")
        list[4] = new_due_date
        print("Task's new due date is " + list[4])
    
    return list

def rewrite_file():
    task_file = open('tasks.txt', 'w')
    for task in task_indexes.values():
        task_file.write(','.join(str(i) for i in task))
    task_file.close()
        
def my_task(username, task_number):
    task_menu_input = print("What would you like to do with your tasks?\n\ta - Mark the task as complete\n\tb - Edit the task")

    if task_menu_input == 'a':
        with open("tasks.txt", "r") as tasks_file_vm:
            for line_vm in tasks_file_vm:
                task_list_vm = line_vm.split(',')

def generate_reports():
    task_count = len(task_indexes)
    
    completed_count = 0
    
    for task_completed in task_indexes.values():
        if task_completed[5] == 'Yes\n':
            completed_count += 1

    uncompleted_count = task_count - completed_count

    percent_uncompleted = int((uncompleted_count / task_count) * 100)

    overdue = 0

    today = datetime.date.today()

    for task_overdue in task_indexes.values():
        due_date = datetime.date.fromisoformat(task_overdue[4])
        if (task_overdue[5] == 'No\n') and (due_date < today):
            overdue += 1

    percent_overdue = int((overdue / task_count) * 100)

    with open("task_overview.txt", "w") as task_overview:
        task_overview.write("The total number of tasks tracked: " + str(task_count) + "\n")
        task_overview.write("The total number of completed task: " + str(completed_count) + "\n")
        task_overview.write("The total number of uncompleted task: " + str(uncompleted_count) + "\n")
        task_overview.write("The total number of overdue task: " + str(overdue) + "\n")
        task_overview.write("The percentage of uncompleted tasks: " + str(percent_uncompleted) + "%\n")
        task_overview.write("The percentage of overdue tasks: " + str(percent_overdue) + "%")

    with open("user_overview.txt", "w") as user_overview:   
        user_count = len(user_password)
        user_overview.write("The total number of users registered: " + str(user_count) + "\n")
        user_overview.write("The total number of tasks tracked: " + str(task_count) + "\n\n")
        for user in user_password:
            user_task_count = 0
            user_completed_count = 0
            user_overdue = 0
            for task_user in task_indexes.values():
                if task_user[0] == user:
                    user_task_count += 1
                    
                    if task_user[5] == "Yes\n":
                        user_completed_count += 1
                    
                    user_due_date = datetime.date.fromisoformat(task_user[4])

                    if (task_user[5] == 'No\n') and (user_due_date < today):
                        user_overdue += 1

            user_overview.write("The total number of tasks assigned to {}: {}\n".format(user, str(user_task_count)))
            
            percent_user_task = int((user_task_count / task_count) * 100)                
            user_overview.write("The percentage of tasks assigned to {}: {}%\n".format(user, str(user_task_count)))
            
            if user_task_count > 0:
                percent_user_completed = int((user_completed_count / user_task_count) * 100)
                percent_user_overdue = int((user_overdue / user_task_count) * 100)
            else:
                percent_user_completed = 0
                percent_user_overdue = 0          
            
            user_overview.write("The percentage of tasks assigned to {} that has been completed: {}%\n".format(user, str(percent_user_completed)))
            
            user_overview.write("The percentage of tasks assigned to {} that must still be completed: {}%\n".format(user, str(100 - percent_user_completed)))

            
            user_overview.write("The percentage of tasks assigned to {} are overdue: {}%\n\n".format(user, str(percent_user_overdue)))

def display_stats():
    try:
        with open("task_overview.txt", "r") as task_overview, open("user_overview.txt", "r") as user_overview:
            print("===TASK OVERVIEW===")
            for task_line in task_overview:
                print(task_line)

            print("\n===USER OVERVIEW===")
            for user_line in user_overview:
                print(user_line)
    except FileNotFoundError:
        generate_reports()
        with open("task_overview.txt", "r") as task_overview, open("user_overview.txt", "r") as user_overview:
            print("===TASK OVERVIEW===")
            for task_line in task_overview:
                print(task_line)

            print("\n===USER OVERVIEW===")
            for user_line in user_overview:
                print(user_line)

def menu(username):
# Check if user is admin then display appropate menu options
    if username == 'admin':
        menu_input = input('''Please select one of the following options: 
        r - register user
        a - add task
        va - view all tasks
        vm - view my tasks
        gr - generate reports
        ds - display statistics
        e - exit\n\n''')
    else:
        menu_input = input('''Please select one of the following options: 
        a - add task
        va - view all tasks
        vm - view my tasks
        e - exit\n\n''')

    return menu_input

# MAIN PROGRAMME
# Open the files
users_file = open("user.txt", "r+")

# LOGIN MODULE
# Initialise lists of user and password variables
user_password = {}

# Create dicts of username and passwords from user.txt
for line in users_file:
    user_password_list = line.replace(' ', '').split(',')
    user_password[user_password_list[0].strip()] = user_password_list[1].strip()

# Ask users to enter uernsame
username = input("Please enter your username: \n")

# Check if username is valid
while username not in user_password:
    username = input("Invalid username. Please re-enter: \n")

# If username is valid, check if password is correct
if username in user_password:
    password = input("Please enter your password: \n")
    while password != user_password[username]:
        password = input("Incorrect password. Please re-enter: \n")
    else:
        print("\nYou've successfully logged in!\n")

menu_input = menu(username)

while menu_input != 'e':
    if (menu_input == 'r') & (username == 'admin'):     
        reg_user()

    # Add task: Ask for relevant inputs then write to tasks.txt
    elif menu_input == 'a':
        add_task()

    # View All: Read tasks.txt, split line into string then display them in an easy to read format
    elif menu_input == 'va':
        view_all()

    # View My Tasks: similar to above, but only display tasks whose assigned to the username
    elif menu_input == 'vm':
        view_mine(username)

    elif (menu_input == 'gr') & (username == 'admin'):    
        generate_reports()

    # View statistics
    elif menu_input == 'ds':
        display_stats()
    
    menu_input = menu(username)

# Exit
if menu_input == 'e':
    exit()