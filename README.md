# DFA
it checks that the given DFA can accept a string or not.

to run the program:

### input

in the first line of input, four numbers entered in order:

- n: number of DFA states
   
- m: number of machine edges
   
- s: number of the initial state of the machine
   
- q: Number of input strings

Machine states are numbered from 1 to n.

in the second line of input, n number entered:

The i-th number specifies the acceptance of the i-th state:

1 means recognition status and 0 means non-recognition.

in the next m lines, a machine edge ​​is given with three input values at each line:

- read word

- The state of the beginning of the edge

- The state of the ending of the edge

in the next q lines, the w_i string entered in the i-th line which is the i-th word given to the machine.

### output

in the i-th line of the output, `yes` or `no` printed which means the string is in the machine language or not.

after that it prints the number of the states to read the string.
