Player1 = input("Player 1's name? ")
Player2 = input("Player 2's name? ")

Player1_answer = input(Player1 + ", do you want to choose rock, paper or scissors? ").lower()
Player2_answer = input(Player2 + ", do you want to choose rock, paper or scissors? ").lower()

if Player1_answer == Player2_answer:
    print("It's a tie!")
elif Player1_answer == 'rock':
    if Player2_answer == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif Player1_answer == 'scissors':
    if Player2_answer == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif Player1_answer == 'paper':
    if Player2_answer == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")