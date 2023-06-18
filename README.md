# scissors-paper-rock ✂️📰🪨
Or rock-paper-scissors, whichever way you call it 

This is a fun project where you can play scissors-paper-rock against the computer for as long as you want. It's primarily in Java, and uses the java swing GUI in order to bring an interactive interface.

To run the code, you'll need specific image and font files that can be replaced if you like!

## What's the logic behind it?
Nothing fancy, but a random number generator that generates positive integer numbers from 0 to 2.

✂️ scissors - 0; 
📰 paper - 1; 
🪨 rock - 2

The instant the user chooses an option, the random number generator runs its code, determining the computer's moves. 

# Breakdown of code
## List of Frames
1.	**start**:
This is the first frame you see when you run the code. It just shows the rules of the game, and a button to start the game which leads it to the next frame **m**

2.	**m**:
This is the main frame where the user can play against the computer. The game controls such as the icons to pick scissors, paper and rock and options to reset the game or end the game.
*Reset Game* all scores to be set to zero
*End Game* will lead to **fin** frame.

3.	**fin**:
The last frame shows the results of the number of rounds won by the user, won by the computer, rounds that were in a tie and whether did the user win against the computer at the end of all the rounds.


## List of Components
### Buttons:
1. _s_: The button that takes the user from ‘start’ frame to ‘m’ frame
2. _f_: The button that allows user to end the game and takes them to the ‘fin’ frame where the results of the game are displayed
3. _reset_: The button that resets the recorded wins, losses and ties to zero.
4. _user[3]_ (array): The buttons that allow the user to pick the icon they want to play: ‘rock’, ‘paper’ or ‘scissors’.

### Labels:
1. _wol_: This label displays the result of the move (after the computer and user play their move)
2. _rules_: This label shows the rules of the game from the Icon rule on the start page
3. _win_ctr_: This label displays “Wins”.
4. _Comp_: This label displays the icon the computer has played
5. _Wins_: This label displays the number of moves the user has won
6. _l11_: This label displays “User Wins”.
7. _l12_: This label displays the number of moves the user won.
8. _l21_: This label displays “Computer Wins”.
9. _l22_: This label displays the number of moves the computer won.
10. _l31_: This label displays “Ties”.
11. _l32_: This label displays the number of moves that resulted in a tie.
12. _l41_: This label displays “Result of the game”.
13. _l42_: This label displays the end result of the game.
14. _t1_ and _t2_: labels that are used to display which side is user’s buttons and computer’s move respectively

~~(in hindsight, I should have come up with better naming)~~

### Font:
1. _font_: Pixel Emulated is the type of font used in plain style of font size 20. This font is used for displaying main output text.
2. _fonts_: Pixel Emulated is the type of font used in plain style of font size 14. This font is used in displaying the results.

You can find this font for free download on fontspace: https://www.fontspace.com/pixel-emulator-font-f21507

### Color:
1. _c_: Colour of rgb value 255, 231, 214 used as the background colour on all frames
2. _b_: Colour of rgb value 234, 239, 210 used as the background colour on all buttons

### Icon:
1. _scissors_: An icon of scissors
2. _paper_: An icon of paper
3. _rock_: An icon of rock
4. _rules_: Has the rules for the game
5. _blank_: just a blank icon that gets utilized when the user decides to reset the game

## List of Methods
### 1.	Game():
Default constructor that is called during object creation. It created the frames ‘start’, ‘m’ and ‘fin’, specifying their dimensions, location and default action on close. The start frame is fully developed in this constructor, and the rest are just created.

### 2.	void spr():
This function is the main part of the game which creates and adds the required components to the ‘m’ frame. The buttons for the user to play their move, as well as the reset and end game buttons and required labels showing the number of wins by the user are created in this function.

### 3.	int computer():
This function specifies how the computer is to play their move. The move is determines using a random() function withing the limits of 0 and 3 where 0 is inclusive and 3 is exclusive. When the variable r is 0, the icon is set to scissors. When the variable is 1, the icon is set to paper and when the variable is 2 the icon is set to rock. The value r is returned which can be used to determine if the user won or lost the round in the WinOrLose () function

### 4.	actionPerformed(ActionEvent e):
Overridden method from interface 'ActionListener'. All buttons’ functions that are registered to the actionListener are specified in the method.

1. **s “Start game”**:
When this button is clicked, it changes the visibility of frame ‘start’ to false and ‘m’ to true and calls the function spr().
2. **user[0] (Icon scissors)**:
If the button clicked is scissor, then the computer’s move is played and the corresponding number is returned from the computer() function. The returned number (stored in variable compres) and 0 is passed as arguments to function WinOrLose() to determine the result for that round.
3. **user[1] (Icon paper)**:
If the button clicked is paper, then the computer’s move is played and the corresponding number is returned from the computer() function. The returned number (stored in variable compres) and 1 is passed as arguments to function WinOrLose() to determine the result for that round.
4. **user[2] (Icon rock)**:
If the button clicked is rock, then the computer’s move is played and the corresponding number is returned from the computer() function. The returned number (stored in variable compres) and 2 is passed as arguments to function WinOrLose() to determine the result for that round.
5. **f “End Game”**:
When this button is clicked the visibility of frame ‘m’ is changed to false and the frame ‘fin’ is set to true.
6. **reset “Reset Game”**:
When this button is clicked, the variables userwins, compwins, ties are set to zero, the labels ‘wol’ and ‘wins’ are set to empty and the ‘comp’ icon is set to blank

### 7.	void WinOrLose (int compres, int in):
This function compares the variable compres and in to determine if the user or the computer won the round. It displays the necessary output in the label wol and correspondingly increments the require counter (that is compwins, userwins or ties)

### 8.	void results():
This function shows the results of the game in a grid format. The results of the game consist of user wins, computer wins, ties and the result of the game.

### 9.	public static void main(String args[]):
In the main method an object g is created which called the default constructor Game() and therefore gets the whole GUI running.

# Screenshots
### The first screen
![image](https://github.com/SHAlockHolmes/scissors-paper-rock/assets/128177155/3d15d782-7c30-4a14-9d21-af20a900ff6f)

### The game itself (oh look, we're winning!)
![image](https://github.com/SHAlockHolmes/scissors-paper-rock/assets/128177155/11d83efd-de84-448f-8a57-19fb2bdb723d)

### Et fin, we won!
![image](https://github.com/SHAlockHolmes/scissors-paper-rock/assets/128177155/dacbb651-ad6a-468b-a356-f3f260279edb)


Well I hope this helps, and you enjoy the game as much as I enjoyed coding it! 😄🍀


