Create class wrapper:
        implement min being 1
        implement max being 100
        use scanner function for user interaction
    
Create main class:
        storage int for user selection
        do while start for menu
            0 for exit
            1 for human guessing
            2 for the computer guessing
            new line
            using previous storage int to read user input
            
            if else start:
                if 1:
                    humanguesser
            else if 2:
                     computerguesser
            loop as long as it's not 0

Create humanGuesser method:
        print "human guesser"
        storage int for secret number, random between min and max
        print the secret number
        storage int for tries, start at 0

        loop forever:
            add 1 to tries
            storage int for guess, read using readInt with the tries number in the prompt, between min and max

            if guess is less than secret:
                print "too low..."
            else if guess is greater than secret:
                print "too high..."
            else:
                print "got it!"
                break out of the loop

        new line
        print "Very good!"
        new line

Create computerGuesser method:
        print "computer guesser"
        storage int for low, start at min
        storage int for high, start at max
        storage int for tries, start at 0

        loop while low is less than or equal to high:
            add 1 to tries
            storage int for guess, the middle of low and high (add them, divide by 2)
            print tries number and "I guess" and the guess

            storage char for answer, read using readAnswer

            if answer is c:
                new line
                return to the menu
            else if answer is h:
                high becomes guess minus 1
            else:
                low becomes guess plus 1

        print "contradiction detected"
        new line

Create readAnswer method (returns a char):
        loop forever:
            print the prompt
            storage String for the line the user typed

            if line is not empty:
                storage char for the first character of the line
                if it is h, l, or c:
                    return it

            print "Please enter h, l, or c."

Create readInt method (returns an int, takes a prompt, min, and max):
        loop forever:
            print the prompt
            storage String for the line the user typed, trimmed

            try:
                convert the line to an int
                if it is between min and max:
                    return it
            if the conversion fails, ignore the error

            print "Invalid input" message with the allowed range
                 
                    
