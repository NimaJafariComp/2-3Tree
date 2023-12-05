# MyTree23 Java Project

Welcome to the MyTree23 Java Project, an implementation of a 2-3 tree in Java adapted from implementation of 2-3-4 tree. This project provides functionality for searching, inserting, splitting, and displaying a 2-3 tree.

## Table of Contents

- [Usage](#usage)
- [Methods](#methods)
- [Contributing](#contributing)
- [License](#license)

## Usage

You can use the MyTree23 class in your Java projects by including it in your codebase. Here's a basic example:

```java
public class Main {
    public static void main(String[] args) {
        MyTree23 myTree = new MyTree23();

        // Insert values into the tree
        myTree.insert(10);
        myTree.insert(20);
        myTree.insert(30);

        // Find a value in the tree
        int result = myTree.find(20);
        System.out.println("Found at index: " + result);

        // Display the tree
        System.out.println("Tree Structure:");
        myTree.display();
    }
}
```

## Methods

- `find(long data)`: Finds the index of a specified data in the tree.
- `insert(long value)`: Inserts a value into the tree.
- `split(Node23 node)`: Splits a node if it is full, maintaining the tree's structure.
- `display()`: Displays the tree structure in a recursive traversal.

## Contributing

If you have any ideas for improvements or new features, feel free to contribute! Fork the repository, make your changes, and submit a pull request. Your input is highly appreciated.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute it as needed.
